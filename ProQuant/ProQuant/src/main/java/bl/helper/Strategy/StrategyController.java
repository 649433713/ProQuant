package bl.helper.Strategy;

import java.util.Date;

import VO.StockPlateVO;
import VO.strategyPageVO.StrategyCallbackVO;
import model.StockPlate;
import model.StrategyType;

public class StrategyController {
    public StrategyCallbackVO getStrategyResult(StockPlateVO stockPlateVO, StockPlate stockPlate,
			int possessingDays,int holdDays,int maxHoldNum, Date startDate, Date endDate,StrategyType type){
    	Strategy strategy=null;
    	switch (type) {
		case ReversionDriven:
			strategy=new ReversionDrivenStrategy(stockPlateVO, stockPlate, possessingDays,holdDays, maxHoldNum, startDate, endDate, type);
			break;
		case MomentumDriven:
			strategy=new MomentumDrivenStrategy(stockPlateVO, stockPlate, possessingDays,holdDays, maxHoldNum, startDate, endDate, type);
			break;
		default:
			break;
		}
    	return strategy.getResult();
    }
}
