/*受雇者DAO，包含增删改查的基本操作以及衍生的其他对数据库的操作*/
package cn.edu.zjut.dao;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.po.Employee;
import cn.edu.zjut.po.Igroup;
import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.po.Order;//临时测试用

public class EmployeeDAO extends BaseHibernateDAO implements IEmployeeDAO{
	private Map<String, Object> request, session;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean register(Employee employee) {//注册
		System.out.println("-----EmployeeRegisterDao-----");
		Transaction tran = null;
		Session esession = null; 
		try {
			esession = getSession();
			tran = esession.beginTransaction();
			esession.save(employee);
			tran.commit();
		} catch (RuntimeException re) {
			if(tran != null) tran.rollback();
			return false;
		} finally {
			getSession().close();
		}
		return true;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean update(Employee employee) {//受雇者信息更新
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		Transaction tran = null;
		Session esession = null;
		try {
			esession = getSession();
			tran = esession.beginTransaction();
			esession.update(employee);
			tran.commit();
			request.put("updateTip", "信息修改成功！");
			session.put("employee", employee);
		} catch (RuntimeException re) {
			return false;
		} finally {
			getSession().close();
		}
		return true;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean login(Employee employee) {//登录
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		String employeeID = employee.getEmployeeID();
		String employeePassword = employee.getEmployeePassword();
		String hql = "from Employee as emp where employeeID='" + employeeID
				+ "' and employeePassword='" + employeePassword + "'";
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			List list=queryObject.list();
			if (list.isEmpty()){
				request.put("tip", "用户名或密码错误，请核对！");
				return false;
			}
			else{
				employee=(Employee)list.get(0);
				session.put("employee", employee);
				request.put("tip", "登录成功！");
				
			}
		}catch (RuntimeException re) {
			System.out.println(re);
			return false;
		}
		getSession().close();
		return true;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean findByIDNum(Employee employee){//验证身份证号是否被使用
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		String employeeIDNum = employee.getEmployeeIDNum();
		String hql = "from Employee as emp where employeeIDNum='" + employeeIDNum+ "'";
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			List list=queryObject.list();
			if (!list.isEmpty()){
				request.put("tip", "注册失败，该身份证号已被使用");
				return false;
			}
		}catch (RuntimeException re) {
			System.out.println(re);
			request.put("tip", "注册失败，服务器发生异常");
			return false;
		}
		getSession().close();
		return true;
	}

	@SuppressWarnings("finally")
	public List findByHQL(String hql){//根据HQL语句查询
		Query queryObject=null;
		try {
			String queryString = hql;
			queryObject = getSession().createQuery(queryString);
			
		} catch (RuntimeException re) {
			throw re;
		} finally{
			getSession().close();
			return queryObject.list();
		}
	}
	
	public void save(Order order) {
		try {
			getSession().save(order);
		} catch (RuntimeException re) {
			throw re;
		} finally{
			getSession().close();
		}
	}
	
	

	@Override
	public List findTeams() {
		// TODO Auto-generated method stub
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		Employee employee=(Employee) session.get("employee");
		String employeeID=employee.getEmployeeID();
		List list=null;
		if(employee.getGroup()==null){
			return null;
		}else{
			try{
				Igroup igroup=employee.getGroup();
				session.put("igroup",igroup);
				String hqll="from Employee as emp where emp.group='"+igroup.getGroupID()+"'";
				Query queryObject = getSession().createQuery(hqll);
				list=queryObject.list();
				if(list.isEmpty())
					System.out.println("kong");
				getSession().close();
				return list;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				getSession().close();
			}
			return null;
		}
	}

	public boolean updateIgroupID(){
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		Employee employee=(Employee) session.get("employee");
		Igroup igroup=(Igroup) session.get("igroup");
		employee.setGroup(igroup);
		Session esession = getSession();
		Transaction tran = esession.beginTransaction();
		try{
			esession.update(employee);
			tran.commit();
			System.out.println("更新group成功");
			session.put("employee", employee);
		}catch(Exception e){
			System.out.println("更新group失败");
			e.printStackTrace();
			return false;
		}finally{
			esession.close();
		}
		return true;
	}

	@Override
	public boolean exitTeam() {
		// TODO Auto-generated method stub
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		Employee employee=(Employee) session.get("employee");
		Igroup igroup=(Igroup) session.get("igroup");
		Session esession = getSession();
		Transaction tran = esession.beginTransaction();
		try{
			employee.setGroup(null);
			esession.update(employee);
			String hql="from Employee where group='"+igroup.getGroupID()+"'";
			Query query=esession.createQuery(hql);
			List list=query.list();
			if(list.isEmpty()){
				
				String hqll="delete Igroup as g where g.groupID='"+igroup.getGroupID()+"'";
				query=esession.createQuery(hqll);
				query.executeUpdate();
				
			}
			tran.commit();
			session.remove("igroup");
			System.out.println(igroup);
			session.put("employee", employee);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			esession.close();
		}
		return true;
	}
	public boolean changeSate(String ID){
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
	
		String hql = "from Employee as emp where employeeID='" + ID+ "'";
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			List list=queryObject.list();
			if (!list.isEmpty()){
				Employee employee=(Employee)list.get(0);
				employee.setEmployeeState(true);
				if(update(employee)){
					System.out.println("审核通过！");
					return true;
				}
			}
		}catch (RuntimeException re) {
			System.out.println(re);
			request.put("tip", "注册失败，服务器发生异常");
			System.out.println("审核未通过！");
			return false;
		}
		getSession().close();
		return true;
		
	}
}
