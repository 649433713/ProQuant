package dataservice;

import java.util.Date;
import java.util.Map;

import PO.StockData;

/**
 * 
 * @author yk
 * 这个借口主要是用来获取数据
 */
public interface GetStockData {
	/**
	 * 这个方法用于把股票名称转化为股票Id，方便下一步的使用
	 * @param name 股票的名称
	 * @return 返回股票code
	 */
	public String  getStockName(String  name);
	
	/**
	 * 
	 * @param name股票id
	 * @return
	 */
	public StockData getSpecificStock(int code);
	
	/**
	 * 得到一段时间内的股票数据的集合
	 * @param end 结束的时间，如果为null，则为现在的时间
	 * @param count 结束时间之前的count天
	 * @param code 股票的id
	 * @return 返回对应日期的股票集合，日期为key，map有序就最好了
	 */
	public Map<Date , StockData> getSpecificDateStock(Date end,int count,int code);    
}
