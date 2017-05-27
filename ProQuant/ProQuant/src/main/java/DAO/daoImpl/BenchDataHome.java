// default package
// Generated 2017-5-25 12:54:40 by Hibernate Tools 4.0.1.Final
package DAO.daoImpl;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import DAO.dao.BenchDataDao;
import PO.BenchData;
import PO.BenchDataId;

/**
 * Home object for domain model class BenchData.
 * @see .BenchData
 * @author Hibernate Tools
 */
@Repository("BenchDataDao")
public class BenchDataHome implements BenchDataDao {

	private static final Log log = LogFactory.getLog(BenchDataHome.class);


	@Autowired
	private SessionFactory sessionFactory;


	/**
		 (non-Javadoc)
	 * @see DAO.dao.BenchDataDao#persist(PO.BenchData)
	 */
	@Transactional
	public void persist(BenchData transientInstance) {
		log.debug("persisting BenchData instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/**
		 (non-Javadoc)
	 * @see DAO.dao.BenchDataDao#attachDirty(PO.BenchData)
	 */
	@Transactional
	public void attachDirty(BenchData instance) {
		log.debug("attaching dirty BenchData instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/**
		 (non-Javadoc)
	 * @see DAO.dao.BenchDataDao#attachClean(PO.BenchData)
	 */
	@Transactional
	public void attachClean(BenchData instance) {
		log.debug("attaching clean BenchData instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/**
		 (non-Javadoc)
	 * @see DAO.dao.BenchDataDao#delete(PO.BenchData)
	 */
	@Transactional
	public void delete(BenchData persistentInstance) {
		log.debug("deleting BenchData instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/**
		 (non-Javadoc)
	 * @see DAO.dao.BenchDataDao#merge(PO.BenchData)
	 */
	@Transactional
	public BenchData merge(BenchData detachedInstance) {
		log.debug("merging BenchData instance");
		try {
			BenchData result = (BenchData) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/**
		 (non-Javadoc)
	 * @see DAO.dao.BenchDataDao#findById(PO.BenchDataId)
	 */
	@Transactional
	public BenchData findById(BenchDataId id) {
		log.debug("getting BenchData instance with id: " + id);
		try {
			BenchData instance = (BenchData) sessionFactory.getCurrentSession().get("BenchData", id);
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

	/**
		 (non-Javadoc)
	 * @see DAO.dao.BenchDataDao#findByExample(PO.BenchData)
	 */
	@Transactional
	public List findByExample(BenchData instance) {
		log.debug("finding BenchData instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("BenchData").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
