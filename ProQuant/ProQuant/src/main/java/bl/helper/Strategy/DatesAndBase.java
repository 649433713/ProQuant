package bl.helper.Strategy;

import java.util.Date;
import java.util.Map;

public class DatesAndBase {
    private Date dates[];
    private Map<Date, Double> baseResult;
    
	public DatesAndBase(Date[] dates, Map<Date, Double> baseResult) {
		this.dates = dates;
		this.baseResult = baseResult;
	}
	
	public Date[] getDates() {
		return dates;
	}
	public void setDates(Date[] dates) {
		this.dates = dates;
	}
	public Map<Date, Double> getBaseResult() {
		return baseResult;
	}
	public void setBaseResult(Map<Date, Double> baseResult) {
		this.baseResult = baseResult;
	}
    
}
