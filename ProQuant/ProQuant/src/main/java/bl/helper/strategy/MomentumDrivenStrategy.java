package bl.helper.strategy;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import bl.helper.StockInfoHelper;
import bl.helper.strategy.Strategy;
import PO.StockData;
import VO.StockPlateVO;
import VO.strategyPageVO.EarningsCircleVO;
import VO.strategyPageVO.EarningsLineVO;
import VO.strategyPageVO.ParamDataVO;
import VO.strategyPageVO.StrategyCallbackVO;
import VO.strategyPageVO.StrategyEvalutingVO;
import dataservice.BenchDataService;
import dataservice.StockDataService;
import dataservice.StockStrategyService;
import javafx.scene.chart.PieChart.Data;
import model.StockPlate;
import model.StrategyType;
import utility.DateHelper;
/**
 * 
 * @author yk
 *这个是动量策略的策略类，他继承了抽象类Strategy
 */
public class MomentumDrivenStrategy extends Strategy {
/*
 * stockPlateVo  存放股票列表
 * strategyStandard 基准使用
 * possessingDays 形成期
 * maxHoldNum
 * startDate
 * endDate
 * type
 */
	@Autowired
	BenchDataService benchService;
    @Autowired
    StockDataService stockDataService;
    @Autowired
    StockStrategyService stockStrategyService;
	public MomentumDrivenStrategy(StockPlateVO stockPlateVO,
			StockPlate stockPlate
			, int possessingDays,int holdDays,int maxHoldNum, Date startDate, Date endDate, 
			StrategyType type) {
		super(stockPlateVO, stockPlate, possessingDays, holdDays,maxHoldNum, startDate, endDate, type);
	}

	@Override
	public StrategyCallbackVO getResult() {
		
		DatesAndBase db=StrategyHelper.stadardEarning(startDate, endDate, holdDays, stockPlate,benchService);
		Date dates[]=db.getDates();
		Map<Date, Double> strategyProfit=new LinkedHashMap<>();
		int size=dates.length;
		int count=0;
		while(count<size){
			int temp=count;//开始的日期
			count+=holdDays;
			if(count>=size){
				count=size-1;
			}
			
			//有了开始日期和结束日期
			Map<String , StockData> todayPO=stockStrategyService.getSomeStocks(dates[temp], stockPlateVO);
			Map<String , StockData> lastHoldPO=null;
			if(temp==0){
			    lastHoldPO=stockStrategyService.getSomeStocks(DateHelper.add(startDate, -holdDays), stockPlateVO);
		    }else{
		    	lastHoldPO=stockStrategyService.getSomeStocks(dates[temp-holdDays], stockPlateVO);
		    }
			StockPlateVO resultList=StrategyHelper.getMomentumStocks(todayPO, lastHoldPO, maxHoldNum);
			//计算可选股票
			//筛选
			Map<String, StockData> todResult=stockStrategyService.getSomeStocks(dates[count], resultList);
			Map<String , StockData> yesResult=stockStrategyService.getSomeStocks(dates[temp], resultList);
			//over
			double profit=0.0;
			for(Map.Entry<String , StockData> entry :todResult.entrySet()){
				double yes=yesResult.get(entry.getKey()).getClose();
				double tod=entry.getValue().getClose();
				profit+=(tod-yes)/yes;
			}
			profit/=todResult.size();
			strategyProfit.put(dates[count], profit);
		}
		
		EarningsLineVO earningsLineVO=new EarningsLineVO();
		earningsLineVO.setBaseEarningsData(db.getBaseearning());
		earningsLineVO.setStrategyEarningsData(strategyProfit);
		
		EarningsCircleVO earningCircleVO=new EarningsCircleVO();
		calEarningCircle(earningCircleVO, earningsLineVO);
		
		StrategyEvalutingVO strategyEvalutingVO=new StrategyEvalutingVO();
		ParamDataVO paramStrategyDataVO=null;
		ParamDataVO paramBaseDataVO=null;
		calParamData(paramStrategyDataVO, paramBaseDataVO, earningsLineVO);
		StrategyCallbackVO strategyCallbackVO=new StrategyCallbackVO(earningsLineVO, earningCircleVO,
				strategyEvalutingVO, paramStrategyDataVO, paramBaseDataVO);
		return strategyCallbackVO;
	}
    
	private  void calEarningCircle(EarningsCircleVO earningCircleVO,EarningsLineVO earningsLineVO){
		Map<Integer, Integer>peData=new LinkedHashMap<>();
		Map<Integer, Integer>neData=new LinkedHashMap<>();
		Map<Date, Double> strategyData=earningsLineVO.getStrategyEarningsData();
		Map<Date, Double> baseData=earningsLineVO.getBaseEarningsData();
		int peCircleNum=0;
		int neCircleNum=0;
		int maxProfit=0;
		for(Map.Entry<Date, Double> entry:strategyData.entrySet()){
			double profitRate=StockInfoHelper.format(entry.getValue()-baseData.get(entry.getKey()));
			if(profitRate>0){
            	profitRate+=0.01;
            }else{
            	profitRate-=0.01;
            }
			
			int key=(int)(profitRate*100);

            if(Math.abs(key)>maxProfit){
            	maxProfit=Math.abs(key);
            }
            
          //添加到结果里
            if(profitRate>=0){
            	peCircleNum++;
            	if(peData.containsKey(key)){
            		peData.put(key, peData.get(key)+1);
            	}else{
            		peData.put(key, 1);
            	}
            }else{
            	neCircleNum++;
            	if(neData.containsKey(key)){
            		neData.put(key, neData.get(key)+1);
            	}else{
            		neData.put(key, 1);
            	}
            }
		}
		earningCircleVO.setNeCircleNum(neCircleNum);
		earningCircleVO.setPeCircleNum(peCircleNum);
		earningCircleVO.setNeData(neData);
		earningCircleVO.setPeData(peData);
		earningCircleVO.setWinRate(peCircleNum/(peCircleNum+neCircleNum));
	}
	
	private void calParamData(ParamDataVO paramStrategyDataVO,	ParamDataVO paramBaseDataVO,EarningsLineVO earningsLineVO){
		//计算年化收益率
		double baseYear=0.0;
		baseYear=(Statistics.calculateAVG(earningsLineVO.getBaseEarningsData())/holdDays)*365;
		paramBaseDataVO.setAnnualizedRateOfReturn((baseYear));

		double profitYear=0.0;
		profitYear=(Statistics.calculateAVG(earningsLineVO.getStrategyEarningsData())/holdDays)*365;
		paramStrategyDataVO.setAnnualizedRateOfReturn((profitYear));
		
		//首先计算贝塔系数
	    double beta=0;
		beta=Statistics.calaulateCOV(earningsLineVO.getStrategyEarningsData(), earningsLineVO.getBaseEarningsData());
		beta/=Statistics.calaulateCOV(earningsLineVO.getBaseEarningsData(), earningsLineVO.getBaseEarningsData());
		paramStrategyDataVO.setBeta(beta);
		paramBaseDataVO.setBeta(-1);
		
		//计算夏普比率
		double sharpRate=0;
		sharpRate=Statistics.calculateAVG(earningsLineVO.getStrategyEarningsData())-DepositRate.getRate(startDate);
		sharpRate/=Math.sqrt(Statistics.calaulateCOV(earningsLineVO.getStrategyEarningsData(), earningsLineVO.getStrategyEarningsData()));
		paramStrategyDataVO.setSharpeRatio(sharpRate);
		paramBaseDataVO.setSharpeRatio(-1);
		
		//计算阿尔法
		double alpha=0;
		alpha=(profitYear-DepositRate.getRate(startDate));
		double temp=( Statistics.calculateAVG(earningsLineVO.getBaseEarningsData())- DepositRate.getRate(startDate));
		alpha=alpha-(beta*temp);
		paramStrategyDataVO.setAlpha(alpha);			
		
		//计算最大回撤
        double  maxBack=0;
        double  peak=0;
        ArrayList<Double> list=new ArrayList<>();
   
        for (Map.Entry<Date, Double > entry : earningsLineVO.getStrategyEarningsData().entrySet()) {
       			list.add(entry.getValue());
     	}
        for(int i=0;i<list.size();i++){
        	if(list.get(i)>peak){
        		peak=list.get(i);
        	}
        	double back=peak-list.get(i);
            if(back>maxBack){
            	maxBack=back;
            }
        }
        paramStrategyDataVO.setBiggestReturn(maxBack);
        paramBaseDataVO.setBiggestReturn(-1);
        
        paramStrategyDataVO.setRateOfTotalReturn(Statistics.calculateAll(earningsLineVO.getStrategyEarningsData()));
	    paramBaseDataVO.setRateOfTotalReturn(Statistics.calculateAll(earningsLineVO.getBaseEarningsData()));
	}
}
