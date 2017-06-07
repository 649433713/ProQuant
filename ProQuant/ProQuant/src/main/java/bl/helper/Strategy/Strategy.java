package bl.helper.Strategy;

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
    int holdDays;
    int maxHoldNum;
    StrategyType type;
    
    public Strategy(StockPlateVO stockPlateVO, StockPlate stockPlate,
            int possessingDays, int holdDays,int maxHoldNum, Date startDate, Date endDate
            ,StrategyType type){
    	this.stockPlateVO=stockPlateVO;
    	this.startDate=startDate;
    	this.endDate=endDate;
    	this.stockPlate=stockPlate;
    	this.possessingDays=possessingDays;
    	this.maxHoldNum=maxHoldNum;
    	this.type=type;
    }
    
    public abstract StrategyCallbackVO getResult();
}
