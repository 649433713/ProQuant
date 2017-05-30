package bl;

import java.util.ArrayList;
import java.util.Date;

import VO.StockDataVO;
import VO.StockKLine;
import VO.StockVO;
import bl.helper.StockInfoHelper;
import blservice.StockInfoBlService.StockInfoService;

public class StockInfoBl implements StockInfoService {

	@Override
	public StockVO getStockVO(String stockNameOrId) {
		
		return null;
	}

	@Override
	public ArrayList<StockKLine> getStockForKLine(String stockNameOrId, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StockDataVO> getStockData(String stockNameOrId, int numberOfDay) {
		int code=StockInfoHelper.getStockCode(stockNameOrId);
		//从数据层得到股票的map
		
		return null;
	}

}
