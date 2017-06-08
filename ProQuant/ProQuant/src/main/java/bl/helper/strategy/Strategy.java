package bl.helper.strategy;

/**
 * Created by xiezhenyu on 2017/6/8.
 */
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
    int holdDays;
    public Strategy(StockPlateVO stockPlateVO, StockPlate strategyStandard,
                    int possessingDays,int holdDays, int maxHoldNum, Date startDate, Date endDate
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
