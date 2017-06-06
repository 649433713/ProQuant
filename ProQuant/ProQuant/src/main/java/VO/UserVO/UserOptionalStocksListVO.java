package VO.UserVO;


/**
 * Created by xiezhenyu on 2017/6/6.
 * 该VO对应用户界面的自选股
 */
public class UserOptionalStocksListVO {
    //股票ID
    private String id;
    //股票名称
    private String name;
    //股票现价
    private double currentPrice;
    //涨幅跌幅
    private Double chg;
    //成交量
    private Double volume;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getChg() {
        return chg;
    }

    public void setChg(Double chg) {
        this.chg = chg;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }
}
