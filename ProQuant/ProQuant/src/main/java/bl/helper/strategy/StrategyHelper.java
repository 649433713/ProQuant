package bl.helper.strategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.mysql.cj.mysqlx.protobuf.MysqlxDatatypes.Array;

import PO.BenchData;
import PO.StockData;
import VO.StockPlateVO;
import VO.strategyPageVO.StrategyCallbackVO;
import VO.strategyPageVO.StrategyCompareVO;
import dataservice.BenchDataService;
import javafx.scene.chart.PieChart.Data;
import model.StockPlate;
import model.StrategyType;

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
	             //从后往前比较
	             while(end>start&&a.get(end).value>=key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
	                 end--;
	             if(a.get(end).value<=key){
	                 StrategyCompareVO temp = a.get(end);
	                 StrategyCompareVO temp2=a.get(start);
	                 a.set(end, temp2);
	                 a.set(start, temp);
	             }
	             //从前往后比较
	             while(end>start&&a.get(start).value<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
	                start++;
	             if(a.get(start).value>=key){
	                 StrategyCompareVO temp = a.get(start);
	                 a.set(start, a.get(end));
//	                 a[start] = a[end];
	                 a.set(end, temp);
//	                 a[end] = temp;
	             }
	         //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
	         }
	         //递归
	         if(start>low) sort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1
	         if(end<high) sort(a,end+1,high);//右边序列。从关键值索引+1到最后一个
	     }
	     
	
}
