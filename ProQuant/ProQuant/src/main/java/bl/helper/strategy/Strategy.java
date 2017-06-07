package bl.helper.strategy;

import java.util.Date;

import VO.StockPlateVO;
import VO.strategyPageVO.StrategyCallbackVO;
import model.StockPlate;
import model.StrategyType;

public abstract class Strategy {
    StockPlateVO stockPlateVO;
	Date startDate;
    Date endDate;
    StockPlate stockPlate;
    int possessingDays;
    int maxHoldNum;
    StrategyType type;
    
    public Strategy(StockPlateVO stockPlateVO, StockPlate strategyStandard,
            int possessingDays, int maxHoldNum, Date startDate, Date endDate
            ,StrategyType type){
    	this.stockPlateVO=stockPlateVO;
    	this.startDate=startDate;
    	this.endDate=endDate;
    	this.stockPlate=strategyStandard;
    	this.possessingDays=possessingDays;
    	this.maxHoldNum=maxHoldNum;
    	this.type=type;
    }
    
    public abstract StrategyCallbackVO getResult();
}
