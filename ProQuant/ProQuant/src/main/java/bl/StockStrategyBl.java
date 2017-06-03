package bl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import VO.StockPlateVO;
import VO.strategyPageVO.PrecisionVO;
import VO.strategyPageVO.StrategyCallbackVO;
import VO.strategyPageVO.StrategyIndexVO;
import blservice.strategyBlService.StrategyService;
import model.StrategyStandard;
@Service
public class StockStrategyBl implements StrategyService {

	@Override
	public StrategyCallbackVO getCalResultOnExistStrategy(StockPlateVO stockPlateVO, StrategyStandard strategyStandard,
			int possessingDays, int maxHoldNum, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StrategyCallbackVO getCalResultOnNewStrategy(StockPlateVO stockPlateVO, StrategyStandard strategyStandard,
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