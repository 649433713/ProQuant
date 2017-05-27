package blservice.StockInfoBlService;

import VO.StockDataVO;
import VO.StockKLine;
import VO.StockVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by LENOVO on 2017/5/26.
 */
public interface StockInfoService {

    /**
     * 获取股票信息
     * @param stockNameOrId 股票的名称或id
     * @return 返回对应股票的VO
     */
    public StockVO getStockVO(String stockNameOrId);

    /**
     * 获取股票K线图所需的数据
     * @param stockNameOrId 股票的名称或id
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 返回包含股票K线图数据VO的ArrayList
     */
    public ArrayList<StockKLine> getStockForKLine(String stockNameOrId, Date startDate, Date endDate);

    /**
     * 获取距离今天的一段时间内的股票历史数据
     * @param stockNameOrId 股票的名称或id
     * @param numberOfDay 距离今天的天数
     * @return 返回包含股票历史数据VO的ArrayList
     */
    public ArrayList<StockDataVO> getStockData(String stockNameOrId, int numberOfDay);
}
