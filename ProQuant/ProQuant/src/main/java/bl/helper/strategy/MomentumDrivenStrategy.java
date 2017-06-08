package bl.helper.strategy;
import java.util.Date;

import bl.helper.strategy.Strategy;
import org.springframework.beans.factory.annotation.Autowired;

import VO.StockPlateVO;
import VO.strategyPageVO.EarningsCircleVO;
import VO.strategyPageVO.EarningsLineVO;
import VO.strategyPageVO.ParamDataVO;
import VO.strategyPageVO.StrategyCallbackVO;
import VO.strategyPageVO.StrategyEvalutingVO;
import dataservice.BenchDataService;
import model.StockPlate;
import model.StrategyType;
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

	public MomentumDrivenStrategy(StockPlateVO stockPlateVO,
			StockPlate stockPlate
			, int possessingDays,int holdDays,int maxHoldNum, Date startDate, Date endDate, 
			StrategyType type) {
		//删除了holdDays参数，因为和父类的构造函数不匹配
		super(stockPlateVO, stockPlate, possessingDays, holdDays,maxHoldNum, startDate, endDate, type);
	}

	@Override
	public StrategyCallbackVO getResult() {
		
		DatesAndBase db=StrategyHelper.stadardEarning(startDate, endDate, holdDays, stockPlate,benchService);
		Date dates[]=db.getDates();
		int size=dates.length;
		int count=0;
		while(count<size){
			int temp=count;
			count+=holdDays;
			if(count>=size){
				count=size-1;
			}
			//有了开始日期和结束日期
			//计算可选股票
			//筛选
			//over
		}
		
		
		
		
		
		EarningsCircleVO earningCircleVO=new EarningsCircleVO();
		EarningsLineVO earningsLineVO=new EarningsLineVO();
		
		earningsLineVO.setBaseEarningsData(db.getBaseearning());
		StrategyEvalutingVO strategyEvalutingVO=new StrategyEvalutingVO();
		ParamDataVO paramStrategyDataVO=null;
		ParamDataVO paramBaseDataVO=null;
		StrategyCallbackVO strategyCallbackVO=new StrategyCallbackVO(earningsLineVO, earningCircleVO,
				strategyEvalutingVO, paramStrategyDataVO, paramBaseDataVO);
		return strategyCallbackVO;
	}

}
