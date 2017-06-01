package dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import PO.InfoData;
import PO.StockCurrentData;
import PO.StockData;


public interface StockDataService {
	
	public StockCurrentData getStockCurrentData(String code);
	/**
	 * 得到一段时间内的股票数据的集合
	 * @param end 结束的时间，如果为null，则为现在的时间
	 * @param count 结束时间之前的count天
	 * @param code 股票的id
	 * @return 返回对应日期的股票集合，日期为key
	 */
	public Map<Date , StockData> getBasicDateStock(Date end,int count,String code);
	
	
	public Map<Date , StockData> getBasicDateStock(Date start,Date end,String code);
	
	/**
	 * @TODO：
	 * @param date
	 * @param codes code的list集合，如果为null则查询所有股票
	 * @return
	 */
	public Map<String,StockData> getSomeStocksByDate(Date date,ArrayList<String> codes);
	
	public Map<String,Integer> searchStock(String nameOrCode);
	
	public Integer getCode(String name);
	
	public String getName(String code);
	
	public InfoData getStockInfo(String code);
    
}
