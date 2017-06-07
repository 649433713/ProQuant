package bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PO.InfoData;
import PO.StockCurrentData;
import PO.StockData;
import PO.StockScore;
import PO.kLinePO.KLineDayData;
import VO.StockDataVO;
import VO.StockForCompare;
import VO.StockKLine;
import VO.StockVO;
import bl.helper.StockInfoHelper;
import bl.helper.StockPoToVo;
import blservice.StockInfoBlService.StockInfoService;
import dataservice.KLineDataService;
import dataservice.StockDataService;
import dataservice.StockScoreService;
import model.KLineType;

@Service("StockInfoService")
public class StockInfoBl implements StockInfoService {
	@Autowired
	StockDataService stockDataService;
	@Autowired
	StockScoreService stockScoreService;
    @Autowired
	KLineDataService kLineDataService;	
    
	@Override
	public StockVO getStockVO(String stockNameOrId) {
		String code=StockInfoHelper.getStockCode(stockNameOrId,stockDataService);
		StockCurrentData stockCurrent=stockDataService.getStockCurrentData(code);
		InfoData infoData=stockDataService.getStockInfo(code);
		StockScore stockScore=stockScoreService.getStockScore(code);
		return StockPoToVo.stockCurrentToStockVO(stockCurrent, infoData, stockScore);
	}

	@Override
	public ArrayList<StockKLine> getStockForKLine(String stockNameOrId, Date startDate, Date endDate
			,KLineType kLineType,boolean fq) {
        //得到id和name
		String code=StockInfoHelper.getStockCode(stockNameOrId,stockDataService);
		String name=stockDataService.getName(code);
		int id=Integer.parseInt(code);
		
		//得到预计的天数
        int count=1;
		Date tmpDate=new Date();
		tmpDate=startDate;
		while(tmpDate.before(endDate)){
			count++;
			tmpDate=StockInfoHelper.add(tmpDate, 1);
		}
		//从数据层取数据
		ArrayList<KLineDayData> kLineDayDatas=new ArrayList<>();
		switch (kLineType){
		case Day:kLineDayDatas=kLineDataService.getdayLine(code, endDate, count, fq);
			break;
		case Week:kLineDayDatas=kLineDataService.getweekLine(code, endDate, count, fq);
			break;
		case Mouth:kLineDayDatas=kLineDataService. getmonthLine(code, endDate, count, fq);
			break;
		}
		//删去多余的po
		while(kLineDayDatas.get(0).getDate().before(startDate)){
			kLineDayDatas.remove(0);
		}
		
		//po转化成vo
		ArrayList<StockKLine> kLines=new ArrayList<>();
		for(int i=0;i<kLineDayDatas.size();i++){
			StockKLine stockKLine=StockPoToVo.KLineDataToStockKLine(kLineDayDatas.get(i));
			stockKLine.setName(name);
			stockKLine.setId(id);
			kLines.add(stockKLine);
		}
		return kLines;
	}

	@Override
	public ArrayList<StockDataVO> getStockData(String stockNameOrId, int numberOfDay) {
		String code=StockInfoHelper.getStockCode(stockNameOrId,stockDataService);
		//从数据层得到股票的map
		Date now =new Date();
		Map<Date, StockData> stockPO=stockDataService.getBasicDateStock(now, numberOfDay, code);
		String name=stockDataService.getName(code);
//		System.out.println(name);
		ArrayList<StockDataVO> stockDataVOs=new ArrayList<>();
		for (Map.Entry<Date, StockData> entry : stockPO.entrySet()) {
            StockDataVO stockDataVO=StockPoToVo.stockDataToStockDataVO(entry.getValue());
            stockDataVO.setName(name);
            stockDataVO.setId(Integer.parseInt(code));
            stockDataVOs.add(stockDataVO);
		}
		return stockDataVOs;
	}

	@Override
	public ArrayList<StockForCompare> stockCompare(ArrayList<String> stockLists) {
//		Map<D, V>
		
		return null;
	}

}
