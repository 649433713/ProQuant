package DAO.daoImpl;
// Generated 2017-5-28 13:18:58 by Hibernate Tools 5.2.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import PO.StockData;
import PO.StockDataId;

/**
 * Home object for domain model class StockData.
 * @see DAO.StockData
 * @author Hibernate Tools
 */
@Repository("StockDataDao")
public class StockDataHome {

	private static final Log log = LogFactory.getLog(StockDataHome.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public void persist(StockData transientInstance) {
		log.debug("persisting StockData instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	@Transactional
	public void attachDirty(StockData instance) {
		log.debug("attaching dirty StockData instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	@Transactional
	public void attachClean(StockData instance) {
		log.debug("attaching clean StockData instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	@Transactional
	public void delete(StockData persistentInstance) {
		log.debug("deleting StockData instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	@Transactional
	public StockData merge(StockData detachedInstance) {
		log.debug("merging StockData instance");
		try {
			StockData result = (StockData) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	@Transactional
	public StockData findById(StockDataId id) {
		log.debug("getting StockData instance with id: " + id);
		try {
			StockData instance = (StockData) sessionFactory.getCurrentSession().get("DAO.StockData", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	@Transactional
	public List findByExample(StockData instance) {
		log.debug("finding StockData instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("DAO.StockData")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
