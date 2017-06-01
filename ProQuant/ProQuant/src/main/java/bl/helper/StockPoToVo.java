package bl.helper;

import PO.StockData;
import PO.kLinePO.KLineDayData;
import VO.StockDataVO;
import VO.StockKLine;

public class StockPoToVo{
	
     public static StockDataVO stockDataToStockDataVO(StockData stockData){
         StockDataVO stockDataVO=new StockDataVO(null, Integer.parseInt(stockData.getId().getCode()), stockData.getId().getDate()
        		 , stockData.getHigh(), stockData.getLow()
        		 ,stockData.getOpen(), stockData.getClose(), stockData.getTurnoverRatio(), 0.0,0.0);		
    	 return null;
     }
     
     public static StockKLine KLineDataToStockKLine(KLineDayData kLineDayData){
    	 StockKLine kLine=new StockKLine(null, 0, kLineDayData.getDate(), kLineDayData.getKline().getHigh(), kLineDayData.getKline().getLow()
    			 , kLineDayData.getKline().getOpen(),kLineDayData.getKline().getClose());
    	 return kLine;
     }
}
