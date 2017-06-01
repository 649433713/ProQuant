package dataservice;

import java.util.Date;
import java.util.Map;

import PO.BenchCurrentData;
import PO.BenchData;
import PO.StockData;
import model.StockPlate;


/**
 * @author 凡
 *
 */
public interface BenchDataService {
	
	public Map<Date , BenchData> getDataByNumAndPlate(Date end,int count,StockPlate plate);
	
	public Map<Date , BenchData> getDataByDateAndPlate(StockPlate plate,Date start,Date end);
	
	public BenchCurrentData getBenchCurrentData(StockPlate plate);
}
