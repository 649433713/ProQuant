package bl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import VO.StockPlateVO;
import VO.strategyPageVO.PrecisionVO;
import VO.strategyPageVO.StrategyCallbackVO;
import VO.strategyPageVO.StrategyIndexVO;
import bl.helper.strategy.StrategyController;
import blservice.strategyBlService.StrategyService;
import model.StockPlate;
import model.StrategyType;
@Service("StrategyService")
public class StockStrategyBl implements StrategyService {

	@Override
	public StrategyCallbackVO getCalResultOnExistStrategy(StockPlateVO stockPlateVO, StockPlate stockPlate,
			int possessingDays, int holdDays,int maxHoldNum, Date startDate, Date endDate,StrategyType type) {
		StrategyController strategyController=new StrategyController();
		return strategyController.getStrategyResult(stockPlateVO,stockPlate, possessingDays,holdDays, maxHoldNum, startDate, endDate, type);
	}

	@Override
	public StrategyCallbackVO getCalResultOnNewStrategy(StockPlateVO stockPlateVO, StockPlate stockPlate,
			int possessingDays, int maxHoldNum, Date startDate, Date endDate,
			ArrayList<StrategyIndexVO> strategyStandardVOS) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrecisionVO getDataForShowPrecision() {
		// TODO Auto-generated method stub
		return null;
	}

}
