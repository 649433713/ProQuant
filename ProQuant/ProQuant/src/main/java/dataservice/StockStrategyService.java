package dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import PO.StockData;
import VO.StockPlateVO;

public interface StockStrategyService {
   
    /**
     *计算选定股票的所需要的股票 ，需要确定当天某股票是否可以交易，不能交易的需要剔除
     * @param selectedLists 所选股票名称或编号
     * @param Growdays 形成期的天数
     * @param startDate 回测的起止日期
     * @return 返回所选股票的名称
     */
    public Map<String, Double> getYieldOfSelectsStocks(StockPlateVO selectedLists , int Growdays,Date startDate);
    /**
     * 这个方法用于返回这一段时间内某个属性的值
     * @param date结束的日期
     * @param days结束日期前需要多少天,要包括结束日期这一天的po
     * @param selectedLists需要股票
     * @return
     */
    public Map<String, Map<Date, StockData>> getSomeStocksOfSomeDays(Date date,int days,StockPlateVO selectedLists);
    
    /**
     * 用于返回这一天的list的股票信息
     * @param date这一天的日期
     * @param selectedLists需要计算的股票池，具体见vo
     * @return String为code
     */
    public Map<String, StockData> getSomeStocks(Date date,StockPlateVO selectedLists);
}
