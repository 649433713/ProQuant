package DAO.daoImpl;
// default package
// Generated 2017-5-25 12:54:40 by Hibernate Tools 4.0.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DAO.dao.InfoDataDao;
import PO.InfoData;

/**
 * Home object for domain model class InfoData.
 * @see .InfoData
 * @author Hibernate Tools
 */
@Repository("InfoDataDao")
public class InfoDataHome implements InfoDataDao {

	private static final Log log = LogFactory.getLog(InfoDataHome.class);


	@Autowired
	private SessionFactory sessionFactory;


	/**
		 (non-Javadoc)
	 * @see DAO.dao.InfoDataDao#persist(PO.InfoData)
	 */
	@Override
	public void persist(InfoData transientInstance) {
		log.debug("persisting InfoData instance");
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
	 * @see DAO.dao.InfoDataDao#attachDirty(PO.InfoData)
	 */
	@Override
	public void attachDirty(InfoData instance) {
		log.debug("attaching dirty InfoData instance");
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
	 * @see DAO.dao.InfoDataDao#attachClean(PO.InfoData)
	 */
	@Override
	public void attachClean(InfoData instance) {
		log.debug("attaching clean InfoData instance");
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
	 * @see DAO.dao.InfoDataDao#delete(PO.InfoData)
	 */
	@Override
	public void delete(InfoData persistentInstance) {
		log.debug("deleting InfoData instance");
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
	 * @see DAO.dao.InfoDataDao#merge(PO.InfoData)
	 */
	@Override
	public InfoData merge(InfoData detachedInstance) {
		log.debug("merging InfoData instance");
		try {
			InfoData result = (InfoData) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/**
		 (non-Javadoc)
	 * @see DAO.dao.InfoDataDao#findById(long)
	 */
	@Override
	public InfoData findById(long id) {
		log.debug("getting InfoData instance with id: " + id);
		try {
			InfoData instance = (InfoData) sessionFactory.getCurrentSession().get("InfoData", id);
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
	 * @see DAO.dao.InfoDataDao#findByExample(PO.InfoData)
	 */
	@Override
	public List findByExample(InfoData instance) {
		log.debug("finding InfoData instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("InfoData").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
