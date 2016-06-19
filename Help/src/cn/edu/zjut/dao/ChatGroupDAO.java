package cn.edu.zjut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.zjut.po.ChatGroup;

public class ChatGroupDAO extends BaseHibernateDAO implements IChatGroupDAO{

	@Override
	public boolean create(ChatGroup chatgroup) {
		Transaction tran = null;
		Session esession = null; 
		try {
			esession = getSession();
			tran = esession.beginTransaction();
			esession.save(chatgroup);
			tran.commit();
		} catch (RuntimeException re) {
			if(tran != null) tran.rollback();
			return false;
		} finally {
			getSession().close();
		}
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	public List findbyHql(String hql){
		try {
			Query queryObject = getSession().createQuery(hql);
			List list=queryObject.list();
			return list;
		}catch (RuntimeException re) {
			System.out.println(re);
		}
		getSession().close();
		return null;
	}

}
