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
	public List findByHQL(String hql) {//查找组       根据HQL语句查询
		try {
			System.out.println("finding group instance by hql");
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setMaxResults(5);//只取5条记录
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
			
			request.put("tip", "创建成功");
			System.out.println("创建成功");
		} catch (RuntimeException re) {
			if(tran != null) tran.rollback();
			request.put("tip", "创建失败，该队伍名已被使用");
			System.out.println("创建失败，该队伍名已被使用");
			re.printStackTrace();
			return false;
		} catch(Exception e){
			System.out.println("失败");
			e.printStackTrace();
		}finally {
			getSession().close();
		}
		return true;
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean merge(Igroup group) {//group更新
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
			//request.put("donateTip", "捐献成功！");
			session.put("igroup", group);
		} catch (RuntimeException re) {
			return false;
		} finally {
			getSession().close();
		}
		return true;
	}
	
}
