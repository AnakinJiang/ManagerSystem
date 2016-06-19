package cn.edu.zjut.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.po.Employee;
import cn.edu.zjut.po.Igroup;

public class GroupDAO extends BaseHibernateDAO implements IGroupDAO,IIgroupDAO{
	private Map<String,Object> session,request;
	public List findByHQL(String hql) {//������       ����HQL����ѯ
		try {
			System.out.println("finding group instance by hql");
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setMaxResults(5);//ֻȡ5����¼
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}finally{
			getSession().close();
		}
	}
	public boolean create(Igroup igroup) {
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		Transaction tran = null;
		Session esession = null; 
		try {
			esession = getSession();
			tran = esession.beginTransaction();
			esession.save(igroup);
			tran.commit();
			System.out.println(igroup.getGroupID());
			session.put("igroup", igroup);
			
			request.put("tip", "�����ɹ�");
			System.out.println("�����ɹ�");
		} catch (RuntimeException re) {
			if(tran != null) tran.rollback();
			request.put("tip", "����ʧ�ܣ��ö������ѱ�ʹ��");
			System.out.println("����ʧ�ܣ��ö������ѱ�ʹ��");
			re.printStackTrace();
			return false;
		} catch(Exception e){
			System.out.println("ʧ��");
			e.printStackTrace();
		}finally {
			getSession().close();
		}
		return true;
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean merge(Igroup group) {//group����
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		//request=(Map) ctx.get("request");
		Transaction tran = null;
		Session esession = null;
		try {
			esession = getSession();
			tran = esession.beginTransaction();
			esession.merge(group);
			tran.commit();
			//request.put("donateTip", "���׳ɹ���");
			session.put("igroup", group);
		} catch (RuntimeException re) {
			return false;
		} finally {
			getSession().close();
		}
		return true;
	}
	
}
