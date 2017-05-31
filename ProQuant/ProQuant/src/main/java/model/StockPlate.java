package model;


/**
 * @author 凡
 * 板块名称，分别是：沪深板(主板)、中小板、创业板
 *
 */
public enum StockPlate {
    CSI300,SME,CHINEXT;
    
    public static String codeOf(StockPlate stockPlate){
    	switch (stockPlate) {
		case CSI300:
			return "000300";
		case SME:
			return "399005";
		case CHINEXT:
			return "399006";
		default:
			return null;
		}
    	
    }
}
