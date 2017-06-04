package bl.helper;

import java.util.Date;

import VO.StockPlateVO;
import VO.strategyPageVO.EarningsCircleVO;
import VO.strategyPageVO.EarningsLineVO;
import VO.strategyPageVO.ParamDataVO;
import VO.strategyPageVO.StrategyCallbackVO;
import VO.strategyPageVO.StrategyEvalutingVO;
import model.StrategyStandard;
import model.StrategyType;
/**
 * 
 * @author yk
 *均值回归策略类
 */
public class ReversionDrivenStrategy extends Strategy {

	public ReversionDrivenStrategy(StockPlateVO stockPlateVO, StrategyStandard strategyStandard, int possessingDays,
			int maxHoldNum, Date startDate, Date endDate, StrategyType type) {
		super(stockPlateVO, strategyStandard, possessingDays, maxHoldNum, startDate, endDate, type);
	}

	@Override
	public StrategyCallbackVO getResult() {
		EarningsCircleVO earningCircleVO=new EarningsCircleVO();
		EarningsLineVO earningsLineVO=new EarningsLineVO();
		StrategyEvalutingVO strategyEvalutingVO=new StrategyEvalutingVO();
		ParamDataVO paramStrategyDataVO=null;
		ParamDataVO paramBaseDataVO=null;
		StrategyCallbackVO strategyCallbackVO=new StrategyCallbackVO(earningsLineVO, earningCircleVO,
				strategyEvalutingVO, paramStrategyDataVO, paramBaseDataVO);
		return strategyCallbackVO;
	}

}
