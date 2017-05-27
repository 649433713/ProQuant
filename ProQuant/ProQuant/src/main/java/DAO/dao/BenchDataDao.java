package DAO.dao;

import java.util.List;

import PO.BenchData;
import PO.BenchDataId;

public interface BenchDataDao {

	void persist(BenchData transientInstance);

	void attachDirty(BenchData instance);

	void attachClean(BenchData instance);

	void delete(BenchData persistentInstance);

	BenchData merge(BenchData detachedInstance);

	BenchData findById(BenchDataId id);

	List findByExample(BenchData instance);

}