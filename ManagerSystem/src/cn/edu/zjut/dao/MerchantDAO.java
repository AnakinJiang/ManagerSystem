package cn.edu.zjut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.zjut.po.Merchant;

public class MerchantDAO extends BaseHibernateDAO implements IMerchantDAO  {

	@Override
	public List findByHql(String hql) {
		Session session = null;
		
		List list = null;
		try {
			session = getSession();
			Query queryObject=session.createQuery(hql);
			list=queryObject.list();
		} catch (Exception re) {
			re.printStackTrace();
		} finally {
			session.close();	
		}
		return list;
	}

	@Override
	public void delete(Merchant merchant) {
		Session session = null;
		Transaction tx=null;
		try {
			session = getSession();
			tx=session.beginTransaction();
			session.delete(merchant);
			tx.commit();
			System.out.println("刪除成功！");
		} catch (Exception re) {
			re.printStackTrace();
		} finally {
			session.close();	
		}
		
	}

	@Override
	public void update(Merchant merchant) {
		// TODO Auto-generated method stub
		Transaction tran = null;
		Session esession = null;
		try {
			esession = getSession();
			tran = esession.beginTransaction();
			esession.update(merchant);
			tran.commit();
			System.out.println("更新成功！");
		} catch (RuntimeException re) {
			re.printStackTrace();
		} finally {
			getSession().close();
		}
		
	}
	

}
