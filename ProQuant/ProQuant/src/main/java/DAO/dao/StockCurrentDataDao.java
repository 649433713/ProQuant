package DAO.dao;

import java.util.List;
import java.util.Map;

import PO.StockCurrentData;
import PO.StockCurrentDataId;

public interface StockCurrentDataDao {

	void persist(StockCurrentData transientInstance);

	void attachDirty(StockCurrentData instance);

	void attachClean(StockCurrentData instance);

	void delete(StockCurrentData persistentInstance);

	StockCurrentData merge(StockCurrentData detachedInstance);

	StockCurrentData findById(StockCurrentDataId id);

	List findByExample(StockCurrentData instance);

	StockCurrentData queryByHql(String code);
}