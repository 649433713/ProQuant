package bl.helper.strategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import PO.BenchData;
import PO.StockData;
import VO.StockPlateVO;
import VO.strategyPageVO.StrategyCompareVO;
import dataservice.BenchDataService;
import model.StockPlate;

public class StrategyHelper {
	public static Map<Date, Double> holdField(){
		
		return null;
	}
	
	public static DatesAndBase stadardEarning(Date startDay,Date endDate,int holdDays,StockPlate stockPlate,BenchDataService benchService){
		Map<Date, Double > baseEarning=new LinkedHashMap<>();
		
		Map<Date, BenchData> benchPO=benchService.getDataByDateAndPlate(stockPlate, startDay, endDate);
		int size=benchPO.size();
		Date dates[]=new Date[size];
		BenchData benchs[]=new BenchData[size];
		int count=0;
		for (Map.Entry<Date, BenchData> entry : benchPO.entrySet()) {
		    dates[count]=entry.getKey();
		    benchs[count]=entry.getValue();
		    count++;
		}
		count=0;
		while(count<size){
			int temp=count;
			count+=holdDays;
			if(count>=size){
				count=size-1;
			}
			Double earning=benchs[count].getClose()-benchs[temp].getClose();
			baseEarning.put(dates[count], earning);
		}
		DatesAndBase db=new DatesAndBase(dates, baseEarning);
		return db;
	}

	public static StockPlateVO getMomentumStocks(Map<String , StockData> todayPO,
			Map<String , StockData> yesPO,int maxHoldNum){
		
		StockPlateVO stockPlateVO=new StockPlateVO();
		
		ArrayList<StrategyCompareVO> lists=new ArrayList<>();
		for(Map.Entry<String, StockData> entry: todayPO.entrySet()){
			if(entry.getValue().getChg()>-0.1&&entry.getValue().getChg()<0.1){
				double today=entry.getValue().getClose();
				double yes=yesPO.get(entry.getKey()).getClose();
				StrategyCompareVO strategyCompareVO=new StrategyCompareVO(entry.getKey(), (today-yes)/yes);
			    lists.add(strategyCompareVO);
			}
		}
		sort(lists, 0, lists.size()-1);
		stockPlateVO.setStockPlate(null);
		ArrayList<String > result=new ArrayList<>();
		for(int i=0;i<maxHoldNum;i++){
			result.add(lists.get(i).code);
		}
		stockPlateVO.setStocksNameList(result);
		return stockPlateVO;
	}
	
	     
	     private  static void sort(ArrayList<StrategyCompareVO> a,int low,int high){
	         int start = low;
	         int end = high;
	         double  key = a.get(low).value;
	         while(end>start){
	             //浠庡悗寰�鍓嶆瘮杈�
	             while(end>start&&a.get(end).value>=key)  //濡傛灉娌℃湁姣斿叧閿�煎皬鐨勶紝姣旇緝涓嬩竴涓紝鐩村埌鏈夋瘮鍏抽敭鍊煎皬鐨勪氦鎹綅缃紝鐒跺悗鍙堜粠鍓嶅線鍚庢瘮杈�
	                 end--;
	             if(a.get(end).value<=key){
	                 StrategyCompareVO temp = a.get(end);
	                 StrategyCompareVO temp2=a.get(start);
	                 a.set(end, temp2);
	                 a.set(start, temp);
	             }
	             //浠庡墠寰�鍚庢瘮杈�
	             while(end>start&&a.get(start).value<=key)//濡傛灉娌℃湁姣斿叧閿�煎ぇ鐨勶紝姣旇緝涓嬩竴涓紝鐩村埌鏈夋瘮鍏抽敭鍊煎ぇ鐨勪氦鎹綅缃�
	                start++;
	             if(a.get(start).value>=key){
	                 StrategyCompareVO temp = a.get(start);
	                 a.set(start, a.get(end));
//	                 a[start] = a[end];
	                 a.set(end, temp);
//	                 a[end] = temp;
	             }
	         //姝ゆ椂绗竴娆″惊鐜瘮杈冪粨鏉燂紝鍏抽敭鍊肩殑浣嶇疆宸茬粡纭畾浜嗐�傚乏杈圭殑鍊奸兘姣斿叧閿�煎皬锛屽彸杈圭殑鍊奸兘姣斿叧閿�煎ぇ锛屼絾鏄袱杈圭殑椤哄簭杩樻湁鍙兘鏄笉涓�鏍风殑锛岃繘琛屼笅闈㈢殑閫掑綊璋冪敤
	         }
	         //閫掑綊
	         if(start>low) sort(a,low,start-1);//宸﹁竟搴忓垪銆傜涓�涓储寮曚綅缃埌鍏抽敭鍊肩储寮�-1
	         if(end<high) sort(a,end+1,high);//鍙宠竟搴忓垪銆備粠鍏抽敭鍊肩储寮�+1鍒版渶鍚庝竴涓�
	     }
	     
	
}
