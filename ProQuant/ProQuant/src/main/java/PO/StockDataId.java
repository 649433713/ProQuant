package PO;
// default package
// Generated 2017-5-25 12:54:38 by Hibernate Tools 4.0.1.Final

import java.util.Date;

/**
 * StockDataId generated by hbm2java
 */
public class StockDataId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5260520207527599592L;
	private String code;
	private Date date;
	private Double open;
	private Double high;
	private Double low;
	private Double close;
	private Double change;
	private Double chg;
	private Double volume;
	private Double turnover;
	private Double amplitude;
	private Double turnoverRatio;

	public StockDataId() {
	}

	public StockDataId(String code, Date date) {
		this.code = code;
		this.date = date;
	}

	public StockDataId(String code, Date date, Double open, Double high, Double low, Double close, Double change,
			Double chg, Double volume, Double turnover, Double amplitude, Double turnoverRatio) {
		this.code = code;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.change = change;
		this.chg = chg;
		this.volume = volume;
		this.turnover = turnover;
		this.amplitude = amplitude;
		this.turnoverRatio = turnoverRatio;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Double getClose() {
		return this.close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Double getChange() {
		return this.change;
	}

	public void setChange(Double change) {
		this.change = change;
	}

	public Double getChg() {
		return this.chg;
	}

	public void setChg(Double chg) {
		this.chg = chg;
	}

	public Double getVolume() {
		return this.volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getTurnover() {
		return this.turnover;
	}

	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}

	public Double getAmplitude() {
		return this.amplitude;
	}

	public void setAmplitude(Double amplitude) {
		this.amplitude = amplitude;
	}

	public Double getTurnoverRatio() {
		return this.turnoverRatio;
	}

	public void setTurnoverRatio(Double turnoverRatio) {
		this.turnoverRatio = turnoverRatio;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StockDataId))
			return false;
		StockDataId castOther = (StockDataId) other;

		return ((this.getCode() == castOther.getCode()) || (this.getCode() != null && castOther.getCode() != null
				&& this.getCode().equals(castOther.getCode())))
				&& ((this.getDate() == castOther.getDate()) || (this.getDate() != null && castOther.getDate() != null
						&& this.getDate().equals(castOther.getDate())))
				&& ((this.getOpen() == castOther.getOpen()) || (this.getOpen() != null && castOther.getOpen() != null
						&& this.getOpen().equals(castOther.getOpen())))
				&& ((this.getHigh() == castOther.getHigh()) || (this.getHigh() != null && castOther.getHigh() != null
						&& this.getHigh().equals(castOther.getHigh())))
				&& ((this.getLow() == castOther.getLow()) || (this.getLow() != null && castOther.getLow() != null
						&& this.getLow().equals(castOther.getLow())))
				&& ((this.getClose() == castOther.getClose()) || (this.getClose() != null
						&& castOther.getClose() != null && this.getClose().equals(castOther.getClose())))
				&& ((this.getChange() == castOther.getChange()) || (this.getChange() != null
						&& castOther.getChange() != null && this.getChange().equals(castOther.getChange())))
				&& ((this.getChg() == castOther.getChg()) || (this.getChg() != null && castOther.getChg() != null
						&& this.getChg().equals(castOther.getChg())))
				&& ((this.getVolume() == castOther.getVolume()) || (this.getVolume() != null
						&& castOther.getVolume() != null && this.getVolume().equals(castOther.getVolume())))
				&& ((this.getTurnover() == castOther.getTurnover()) || (this.getTurnover() != null
						&& castOther.getTurnover() != null && this.getTurnover().equals(castOther.getTurnover())))
				&& ((this.getAmplitude() == castOther.getAmplitude()) || (this.getAmplitude() != null
						&& castOther.getAmplitude() != null && this.getAmplitude().equals(castOther.getAmplitude())))
				&& ((this.getTurnoverRatio() == castOther.getTurnoverRatio())
						|| (this.getTurnoverRatio() != null && castOther.getTurnoverRatio() != null
								&& this.getTurnoverRatio().equals(castOther.getTurnoverRatio())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCode() == null ? 0 : this.getCode().hashCode());
		result = 37 * result + (getDate() == null ? 0 : this.getDate().hashCode());
		result = 37 * result + (getOpen() == null ? 0 : this.getOpen().hashCode());
		result = 37 * result + (getHigh() == null ? 0 : this.getHigh().hashCode());
		result = 37 * result + (getLow() == null ? 0 : this.getLow().hashCode());
		result = 37 * result + (getClose() == null ? 0 : this.getClose().hashCode());
		result = 37 * result + (getChange() == null ? 0 : this.getChange().hashCode());
		result = 37 * result + (getChg() == null ? 0 : this.getChg().hashCode());
		result = 37 * result + (getVolume() == null ? 0 : this.getVolume().hashCode());
		result = 37 * result + (getTurnover() == null ? 0 : this.getTurnover().hashCode());
		result = 37 * result + (getAmplitude() == null ? 0 : this.getAmplitude().hashCode());
		result = 37 * result + (getTurnoverRatio() == null ? 0 : this.getTurnoverRatio().hashCode());
		return result;
	}

}