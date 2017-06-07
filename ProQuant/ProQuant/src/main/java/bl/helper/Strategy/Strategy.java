package bl.helper;

import java.util.Date;

import VO.StockPlateVO;
import VO.strategyPageVO.StrategyCallbackVO;
import model.StrategyStandard;
import model.StrategyType;

public abstract class Strategy {
    StockPlateVO stockPlateVO;
	Date startDate;
    Date endDate;
    StrategyStandard strategyStandard;
    int possessingDays;
    int maxHoldNum;
    StrategyType type;
    
    public Strategy(StockPlateVO stockPlateVO, StrategyStandard strategyStandard,
            int possessingDays, int maxHoldNum, Date startDate, Date endDate
            ,StrategyType type){
    	this.stockPlateVO=stockPlateVO;
    	this.startDate=startDate;
    	this.endDate=endDate;
    	this.strategyStandard=strategyStandard;
    	this.possessingDays=possessingDays;
    	this.maxHoldNum=maxHoldNum;
    	this.type=type;
    }
    
    public abstract StrategyCallbackVO getResult();
}
