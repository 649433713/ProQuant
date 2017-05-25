package DAO.dao;

import java.util.List;

import PO.StockData;
import PO.StockDataId;

public interface StockDataDao {

	void persist(StockData transientInstance);

	void attachDirty(StockData instance);

	void attachClean(StockData instance);

	void delete(StockData persistentInstance);

	StockData merge(StockData detachedInstance);

	StockData findById(StockDataId id);

	List findByExample(StockData instance);

}