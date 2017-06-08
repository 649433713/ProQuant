package bl.helper.strategy;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import bl.helper.strategy.Strategy;
import org.springframework.beans.factory.annotation.Autowired;

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
			strategyProfit.put(dates[count], profit);
		}
		
		EarningsLineVO earningsLineVO=new EarningsLineVO();
		earningsLineVO.setBaseEarningsData(db.getBaseearning());
		earningsLineVO.setStrategyEarningsData(strategyProfit);
		
		
		
		
		EarningsCircleVO earningCircleVO=new EarningsCircleVO();
		
		StrategyEvalutingVO strategyEvalutingVO=new StrategyEvalutingVO();
		ParamDataVO paramStrategyDataVO=null;
		ParamDataVO paramBaseDataVO=null;
		StrategyCallbackVO strategyCallbackVO=new StrategyCallbackVO(earningsLineVO, earningCircleVO,
				strategyEvalutingVO, paramStrategyDataVO, paramBaseDataVO);
		return strategyCallbackVO;
	}
    
	public void calEarningCircle(EarningsCircleVO earningCircleVO,EarningsLineVO earningsLineVO){
		
	}
}
