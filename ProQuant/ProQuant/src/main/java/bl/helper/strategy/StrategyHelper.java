package bl.helper.strategy;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import PO.BenchData;
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
	
}
