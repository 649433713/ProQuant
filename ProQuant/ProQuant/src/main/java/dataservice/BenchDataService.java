package dataservice;

import java.util.Date;
import java.util.Map;

import PO.BenchData;
import model.StockPlate;


/**
 * @author 凡
 *
 */
public interface BenchDataService {
	public Map<Date , BenchData> getStocksByDateAndPlate(StockPlate plate,Date start,Date end);
}
