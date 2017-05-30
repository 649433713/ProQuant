// Generated 2017-5-25 12:54:38 by Hibernate Tools 4.0.1.Final
package PO;
import java.util.Date;

/**
 * BenchCurrentData generated by hbm2java
 */
public class BenchCurrentData implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9181171205874475523L;
	private Integer index;
	private String code;
	private String name;
	private Date date;
	private Double trade;
	private Double open;
	private Double high;
	private Double low;
	private Double settlement;
	private Double change;
	private Double changepercent;
	private Long volume;
	private Double turnoverratio;
	private Double amplitudeRatio;

	public BenchCurrentData() {
	}

	public BenchCurrentData(String code, String name, Date date, Double trade, Double open, Double high, Double low,
			Double settlement, Double change, Double changepercent, Long volume, Double turnoverratio,
			Double amplitudeRatio) {
		this.code = code;
		this.name = name;
		this.date = date;
		this.trade = trade;
		this.open = open;
		this.high = high;
		this.low = low;
		this.settlement = settlement;
		this.change = change;
		this.changepercent = changepercent;
		this.volume = volume;
		this.turnoverratio = turnoverratio;
		this.amplitudeRatio = amplitudeRatio;
	}

	public Integer getIndex() {
		return this.index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTrade() {
		return this.trade;
	}

	public void setTrade(Double trade) {
		this.trade = trade;
	}

	public Double getOpen() {
		return this.open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getHigh() {
		return this.high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return this.low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getSettlement() {
		return this.settlement;
	}

	public void setSettlement(Double settlement) {
		this.settlement = settlement;
	}

	public Double getChange() {
		return this.change;
	}

	public void setChange(Double change) {
		this.change = change;
	}

	public Double getChangepercent() {
		return this.changepercent;
	}

	public void setChangepercent(Double changepercent) {
		this.changepercent = changepercent;
	}

	public Long getVolume() {
		return this.volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public Double getTurnoverratio() {
		return this.turnoverratio;
	}

	public void setTurnoverratio(Double turnoverratio) {
		this.turnoverratio = turnoverratio;
	}

	public Double getAmplitudeRatio() {
		return this.amplitudeRatio;
	}

	public void setAmplitudeRatio(Double amplitudeRatio) {
		this.amplitudeRatio = amplitudeRatio;
	}

}
