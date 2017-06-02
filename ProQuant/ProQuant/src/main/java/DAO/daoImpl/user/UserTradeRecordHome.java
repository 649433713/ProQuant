package DAO.daoImpl.user;
// Generated 2017-6-2 16:54:51 by Hibernate Tools 5.2.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import PO.user.UserTradeRecord;

/**
 * Home object for domain model class UserTradeRecord.
 * @see PO.user.UserTradeRecord
 * @author Hibernate Tools
 */
public class UserTradeRecordHome {

	private static final Log log = LogFactory.getLog(UserTradeRecordHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(UserTradeRecord transientInstance) {
		log.debug("persisting UserTradeRecord instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(UserTradeRecord instance) {
		log.debug("attaching dirty UserTradeRecord instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserTradeRecord instance) {
		log.debug("attaching clean UserTradeRecord instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(UserTradeRecord persistentInstance) {
		log.debug("deleting UserTradeRecord instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserTradeRecord merge(UserTradeRecord detachedInstance) {
		log.debug("merging UserTradeRecord instance");
		try {
			UserTradeRecord result = (UserTradeRecord) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserTradeRecord findById(java.lang.String id) {
		log.debug("getting UserTradeRecord instance with id: " + id);
		try {
			UserTradeRecord instance = (UserTradeRecord) sessionFactory.getCurrentSession()
					.get("DAO.daoImpl.user.UserTradeRecord", id);
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

	public List findByExample(UserTradeRecord instance) {
		log.debug("finding UserTradeRecord instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("DAO.daoImpl.user.UserTradeRecord")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
