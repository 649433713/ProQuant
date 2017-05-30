package bl.helper;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dataservice.GetStockData;

public class StockInfoHelper {
	
	
	public static int getStockCode(String str){
//		GetStockData 
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if(isNum.matches()){
			return 123;
		}
		return Integer.parseInt(str);
	}
	
	public  static double format(double d) {
		DecimalFormat dFormat=new DecimalFormat("#.0000");
		String string1=dFormat.format(d);
		return Double .parseDouble(string1);
	}
}
