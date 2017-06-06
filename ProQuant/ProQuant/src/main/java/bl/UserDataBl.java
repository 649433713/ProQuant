package bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import PO.StockCurrentData;
import PO.user.UserAccount;
import PO.user.UserStockOwned;
import PO.user.UserTradeRecord;
import VO.UserVO.AccountPageTotalVO;
import VO.UserVO.StrategyRecordVO;
import VO.UserVO.UserOptionalStocksListVO;
import bl.helper.User.UserPoToVo;
import blservice.userDataBlService.UserDataService;
import dataservice.StockDataService;
import dataservice.UserStockPoolService;
import dataservice.UserTradeService;
import model.ResultMessage;

public class UserDataBl implements UserDataService{

	@Autowired
	UserStockPoolService userStockPoolservice;
	@Autowired
	UserTradeService userTradeService;
	@Autowired
	StockDataService stockDataService;
	@Override
	public AccountPageTotalVO getUserAccountData(String userName) {
		UserAccount userAccount=userTradeService.getUserAccount(userName);
		List<UserStockOwned>  userStocks=userTradeService.getUserStockOwned(userName);
		List<UserTradeRecord> userTradeRecords=userTradeService.getUserTradeRecord(userName);
		
		return null;
	}

	@Override
	public ArrayList<UserOptionalStocksListVO> getUserOptionalStocks(String userName) {
		List<String> stockLists=userStockPoolservice.getUserStockPool(userName);
		ArrayList<UserOptionalStocksListVO> userOptionalStocksListVOs=new ArrayList<>();
		for(int i=0;i<stockLists.size();i++){
			StockCurrentData stockCurrentData=stockDataService.getStockCurrentData(stockLists.get(i));
			UserOptionalStocksListVO vo=UserPoToVo.stockCurrentPOToUserOptionalStocksListVO(stockCurrentData);
		    userOptionalStocksListVOs.add(vo);
		}
		return userOptionalStocksListVOs;
	}

	@Override
	public ResultMessage modifyUserOptionalStocks(ArrayList<String> newOptionalStocksList,String userName) {
		if(userStockPoolservice.modifyPool(newOptionalStocksList, userName)){
			return ResultMessage.success;
		}
		return ResultMessage.failed;
	}

	@Override
	public ArrayList<StrategyRecordVO> getStrategyRecordVO(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyStrategyRecord(ArrayList<String> strategyIndexList,String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
