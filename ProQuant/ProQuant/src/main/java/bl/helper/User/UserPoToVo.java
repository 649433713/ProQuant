package bl.helper.User;

import java.util.ArrayList;
import java.util.List;

import PO.StockCurrentData;
import PO.user.UserAccount;
import PO.user.UserStockOwned;
import PO.user.UserTradeRecord;
import VO.UserVO.AccountPageTotalVO;
import VO.UserVO.AccountVO;
import VO.UserVO.DealRecordsVO;
import VO.UserVO.OwnedStocksVO;
import VO.UserVO.UserOptionalStocksListVO;

public  class UserPoToVo {
    public static UserOptionalStocksListVO stockCurrentPOToUserOptionalStocksListVO(StockCurrentData current){
    	UserOptionalStocksListVO vo=new UserOptionalStocksListVO(current.getCode(), current.getName(), current.getTrade()
    			, current.getChangepercent(), current.getVolume());
    	return vo;
    }
    
    public static AccountPageTotalVO threePOToAccountPageTotalVO(UserAccount userAccount,
    		List<UserStockOwned>  userStocks,List<UserTradeRecord> userTradeRecords){
    	
    	//账户金额等信息
        AccountVO accountVO=new AccountVO(userAccount.getUsername(),userAccount.getAvailablePrincipal()+userAccount.getStoragePrincipal()
        ,userAccount.getAvailablePrincipal(),userAccount.getProfit(),userAccount.getTodayProfit());
        //持仓记录
        ArrayList<OwnedStocksVO> ownedStocksVOs=getOwn(userStocks);
    	//成交记录
        ArrayList<DealRecordsVO> dealRecordsVOs=getDeal(userTradeRecords);
        AccountPageTotalVO accountPageTotalVO=new AccountPageTotalVO(accountVO, ownedStocksVOs, dealRecordsVOs);
    	return accountPageTotalVO;
    }
    
    private static  ArrayList<OwnedStocksVO> getOwn(List<UserStockOwned>  userStocks){
    	ArrayList<OwnedStocksVO> ownedStocksVOs=new ArrayList<>();
    	for(int i=0;i<userStocks.size();i++){
    		OwnedStocksVO ownedStocksVO=new OwnedStocksVO();
    		ownedStocksVO.setOwnedNum(userStocks.get(i).getStocknum());
    		ownedStocksVO.setStockName(userStocks.get(i).getId().getStockcode());
    		ownedStocksVO.setProfitAndLoss(0.0);
    		ownedStocksVO.setNewestPrice(0.1);
    		ownedStocksVOs.add(ownedStocksVO);
    	}
        return ownedStocksVOs;
    }
    
    private static ArrayList<DealRecordsVO> getDeal(List<UserTradeRecord> userTradeRecords){
    	ArrayList<DealRecordsVO> dealRecordsVOs=new ArrayList<>();
    	for(int i=0;i<userTradeRecords.size();i++){
    		DealRecordsVO dealRecordsVO=new DealRecordsVO();
    		dealRecordsVO.setDealNum(userTradeRecords.get(i).getTradenum());
    		dealRecordsVO.setDealDate(userTradeRecords.get(i).getDate().toLocaleString());
    		
    		switch (userTradeRecords.get(i).getTradetype()){
    		case 0:dealRecordsVO.setDealType("买入");break;
    		case 1:dealRecordsVO.setDealType("卖出");break;
    		}
    		dealRecordsVO.setStockName(null);
    		dealRecordsVO.setAveragePrice(userTradeRecords.get(i).getTradeprice());
    		dealRecordsVOs.add(dealRecordsVO);
    	}
    	return dealRecordsVOs;
    }
}
