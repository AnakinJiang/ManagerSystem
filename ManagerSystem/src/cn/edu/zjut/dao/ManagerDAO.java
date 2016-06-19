package cn.edu.zjut.dao;

import java.util.List;
import java.util.Map;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.po.Employee;
import cn.edu.zjut.po.Merchant;

public class ManagerDAO extends BaseHibernateDAO implements IManagerDAO{

	@Override
	public boolean deleteEmployee(String employeeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMerchant(String merchantId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMerchant(Merchant merchant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Merchant> findAllMerchant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Merchant> findUncheckedMerchant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findUncheckedEmployee() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Merchant findMerchant(String merchantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findEmployee(String employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkMerchant(String merchantId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkEmployee(String employeeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean uncheckMerchant(String merchantId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean uncheckEmployee(String employeeId) {
		// TODO Auto-generated method stub
		return false;
	}


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
	public boolean findManger(String managerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List findByHqlTop(String hql) {
		// TODO Auto-generated method stub
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setMaxResults(6);//只取6条记录
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List findByHqlButtom(String hql) {
		// TODO Auto-generated method stub
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setMaxResults(8);//只取8条记录
			System.out.println("********************************"
					+ "*****************************"
					+ "*****************************");
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
