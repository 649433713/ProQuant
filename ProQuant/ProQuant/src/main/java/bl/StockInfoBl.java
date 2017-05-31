package bl;

import java.util.ArrayList;
import java.util.Date;

import VO.StockDataVO;
import VO.StockKLine;
import VO.StockVO;
import bl.helper.StockInfoHelper;
import blservice.StockInfoBlService.StockInfoService;
import dataservice.GetStockData;
import dataservice.KLineDataService;

public class StockInfoBl implements StockInfoService {
//    GetStockData 
	@Override
	public StockVO getStockVO(String stockNameOrId) {
		
		return null;
	}

	@Override
	public ArrayList<StockKLine> getStockForKLine(String stockNameOrId, Date startDate, Date endDate) {
//		KLineDataService kLineDataService 
		int count=1;
		Date tmpDate=new Date();
		tmpDate=startDate;
		while(tmpDate.before(endDate)){
			count++;
			tmpDate=StockInfoHelper.add(tmpDate, 1);
		}
		
		return null;
	}

	@Override
	public ArrayList<StockDataVO> getStockData(String stockNameOrId, int numberOfDay) {
		String code=StockInfoHelper.getStockCode(stockNameOrId);
		//从数据层得到股票的map
		
		return null;
	}

}
