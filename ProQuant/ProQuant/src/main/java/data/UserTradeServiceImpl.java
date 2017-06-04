package data;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.dao.StockCurrentDataDao;
import DAO.dao.UserAccountDao;
import DAO.dao.UserStockOwnedDao;
import DAO.dao.UserTradeRecordDao;
import PO.user.UserAccount;
import PO.user.UserStockOwned;
import PO.user.UserStockOwnedId;
import PO.user.UserTradeRecord;
import dataservice.UserTradeService;
import model.UserTradeSignal;

@Transactional
@Service("UserTradeService")
public class UserTradeServiceImpl implements UserTradeService{
	@Autowired
	private UserAccountDao accountDao;
	@Autowired
	private UserStockOwnedDao stockOwnedDao;
	@Autowired
	private UserTradeRecordDao tradeRecordDao;
	@Autowired
	private StockCurrentDataDao currentDataDao;
	
	@Override
	public UserAccount getUserAccount(String username) {
		List<UserStockOwned> userStockOwneds = getUserStockOwned(username);
		UserAccount userAccount = accountDao.findById(username);
		double storagePrincipal = 0;
		for (UserStockOwned userStockOwned : userStockOwneds) {
			int num = userStockOwned.getStocknum();
			String code = userStockOwned.getId().getStockcode();
			double price = currentDataDao.queryByHql(code).getTrade()*num;
			storagePrincipal+=price;
		}
		userAccount.setStoragePrincipal(storagePrincipal);
		userAccount.setProfit(storagePrincipal+userAccount.getAvailablePrincipal()-userAccount.getHistoryPrincipal());
		userAccount.setTodayProfit(storagePrincipal+userAccount.getAvailablePrincipal()-userAccount.getYesterdayPrincipal());
		
		accountDao.merge(userAccount);
		return userAccount;
	}

	@Override
	public List<UserStockOwned> getUserStockOwned(String username) {
		
		return stockOwnedDao.getUserStockOwned(username);
	}

	@Override
	public List<UserTradeRecord> getUserTradeRecord(String username) {
		
		return tradeRecordDao.getUserTradeRecord(username);
	}

	@Override
	public UserTradeSignal buy(String username, String code, int num) {
		UserAccount userAccount = accountDao.findById(username);
		double price = currentDataDao.queryByHql(code).getTrade();
		double turnover = price*num;
		if (userAccount.getAvailablePrincipal()<turnover) {
			return UserTradeSignal.Insufficient;
		}
		UserStockOwned userStockOwned = stockOwnedDao.findById(new UserStockOwnedId(username, code));
		if (userStockOwned!=null) {
			userStockOwned.setStocknum(userStockOwned.getStocknum()+num);
			
		}
		else{
			userStockOwned = new UserStockOwned(new UserStockOwnedId(username, code),num);
			
		}
		userAccount.setAvailablePrincipal(userAccount.getAvailablePrincipal()-turnover);
		UserTradeRecord userTradeRecord = new UserTradeRecord(0, username, code, num, (byte) 0, price, new Date());
		
		try {
			stockOwnedDao.merge(userStockOwned);
			accountDao.merge(userAccount);
			tradeRecordDao.persist(userTradeRecord);
			 
		} catch (Exception e) {
			// TODO: handle exception
			return UserTradeSignal.error;
		}
		
		return UserTradeSignal.Success;
	}

	@Override
	public UserTradeSignal sell(String username, String code, int num) {
		UserAccount userAccount = accountDao.findById(username);
		double price = currentDataDao.queryByHql(code).getTrade();
		double turnover = price*num;
		UserStockOwned userStockOwned = stockOwnedDao.findById(new UserStockOwnedId(username, code));
		int stockNum = userStockOwned.getStocknum();
		if (stockNum<num) {
			return UserTradeSignal.Insufficient;
		}
		else if (stockNum==num) {
			stockOwnedDao.delete(userStockOwned);
		}else {
			userStockOwned.setStocknum(stockNum-num);
			stockOwnedDao.merge(userStockOwned);
		}
		
		userAccount.setAvailablePrincipal(userAccount.getAvailablePrincipal()+turnover);
		UserTradeRecord userTradeRecord = new UserTradeRecord(0, username, code, num, (byte) 1, price, new Date());
		
		try {
			accountDao.merge(userAccount);
			tradeRecordDao.persist(userTradeRecord);
			 
		} catch (Exception e) {
			// TODO: handle exception
			return UserTradeSignal.error;
		}
		
		return UserTradeSignal.Success;
	}

}
