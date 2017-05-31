package data;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.dao.BenchDataDao;
import PO.BenchData;
import dataservice.BenchDataService;
import model.StockPlate;


/**
 * @author 凡
 *
 */
@Service("BenchDataService")
public class BenchDataServiceImpl implements BenchDataService{
	
	@Autowired
	private BenchDataDao benchDataDao;


	@Override
	public Map<Date, BenchData> getStocksByDateAndPlate(StockPlate plate, Date start, Date end) {
		Map<Date, BenchData> result = benchDataDao.queryByHql(StockPlate.codeOf(plate), start, end);
	
		return result;
	}

  
}
