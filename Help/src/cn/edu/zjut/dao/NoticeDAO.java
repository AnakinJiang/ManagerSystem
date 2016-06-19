package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.zjut.po.Notice;

public class NoticeDAO extends BaseHibernateDAO implements INoticeDAO {

	private Log log = LogFactory.getLog(NoticeDAO.class);
	public void save(Notice transientInstance) {
		log.debug("saving Notice instance");
		//getSession().save(transientInstance);
		Session session = null;
		Transaction tx=null;
		try {
			session = getSession();
			tx=session.beginTransaction();
			session.save(transientInstance);
			tx.commit();
			System.out.println("����ɹ�");
		} catch (Exception re) {
			re.printStackTrace();
		} finally {
			session.close();	
		}
	}
	
	public List findByHql(String hql) {//����
		log.debug("finding Notice instance by hql");
		try {
			System.out.println("finding Notice instance by hql");
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setMaxResults(15);//ֻȡ15����¼
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
		}
	}
    
	public void update(Notice transientInstance) { //��������
		log.debug("update Notice instance");
		//getSession().update(transientInstance);
		Session session = null;
		Transaction tx=null;
		try {
			session = getSession();
			tx=session.beginTransaction();
			session.update(transientInstance);
			tx.commit();
			System.out.println("�޸ĳɹ�");
		} catch (Exception re) {
			re.printStackTrace();
		} finally {
			session.close();	
		}
	}
    public void delete(Notice transientInstance) { //ɾ������
    	log.debug("delete Notice instance");
    	//getSession().delete(transientInstance);
    	Session session = null;
		Transaction tx=null;
		try {
			session = getSession();
			tx=session.beginTransaction();
			session.delete(transientInstance);
			tx.commit();
			System.out.println("ɾ���ɹ�");
		} catch (Exception re) {
			re.printStackTrace();
		} finally {
			session.close();	
		}
    }
}
