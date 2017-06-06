package VO.UserVO;

/**
 * Created by xiezhenyu on 2017/6/6.
 * 该VO对应用户中心界面使用过的策略界面
 */
public class StrategyRecordVO {
    //策略算法名称(bl使用枚举类实现，见  文件，返回界面对应的字符串)
    private String strategAlgorithmName;
    //使用策略时存下来的开始时间
    private String startDate;
    //使用策略时存下来的结束时间
    private String endDate;
    //股票池
    private String stockPlate;
    //策略基准
    private String strategyBaseRule;
    //调仓周期
    private String tiaoCangChouQi;
    //最大持股数
    private String maxHoldStocksNum;

    public StrategyRecordVO() {
    }

    public String getStrategAlgorithmName() {
        return strategAlgorithmName;
    }

    public void setStrategAlgorithmName(String strategAlgorithmName) {
        this.strategAlgorithmName = strategAlgorithmName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStockPlate() {
        return stockPlate;
    }

    public void setStockPlate(String stockPlate) {
        this.stockPlate = stockPlate;
    }

    public String getStrategyBaseRule() {
        return strategyBaseRule;
    }

    public void setStrategyBaseRule(String strategyBaseRule) {
        this.strategyBaseRule = strategyBaseRule;
    }

    public String getTiaoCangChouQi() {
        return tiaoCangChouQi;
    }

    public void setTiaoCangChouQi(String tiaoCangChouQi) {
        this.tiaoCangChouQi = tiaoCangChouQi;
    }

    public String getMaxHoldStocksNum() {
        return maxHoldStocksNum;
    }

    public void setMaxHoldStocksNum(String maxHoldStocksNum) {
        this.maxHoldStocksNum = maxHoldStocksNum;
    }
}
