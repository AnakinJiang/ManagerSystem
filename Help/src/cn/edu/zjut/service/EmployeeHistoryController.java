//受雇者历史任务Service
package cn.edu.zjut.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.IEmployeeDAO;
import cn.edu.zjut.po.Employee;

public class EmployeeHistoryController implements IEmployeeHistoryController{
	private Map<String, Object> session;
	private IEmployeeDAO employeeDAO;
	
	public IEmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	public List displayALL(Employee employee){//显示全部历史
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		employee=(Employee)session.get("employee");
		Date currentTime=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(currentTime);
		System.out.println(today);	//系统当前时间 
		String hql1="select o.merchant.shopName,o.merchant.shopAddress,o.startTime,o.endTime,o.salary,o.merchant.merchantID"
					+" from Order as o where o.employee.employeeID='"
					+employee.getEmployeeID()+"'"
					+" and o.endTime<'"+today+"'"
					+" and o.ifFinish='1'";	//查询今天以前完成任务的信息
		session.put("orderHistory", employeeDAO.findByHQL(hql1));
		return employeeDAO.findByHQL(hql1);
	}
	
	public List displayWeek(Employee employee){//显示最近一周已完成的任务信息
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		employee=(Employee)session.get("employee");
		Date currentTime=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(currentTime);
		
		Calendar date = Calendar.getInstance();
		date.setTime(currentTime);
		String oldDay="";
		Date oldTime=null;
		System.out.println(today);	//系统当前时间 
		date.set(Calendar.DATE, date.get(Calendar.DATE) - 6);
		try {
			oldTime = formatter.parse(formatter.format(date.getTime()));
			oldDay = formatter.format(oldTime);
			System.out.println(oldDay);	//系统当前时间 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String hql1="select o.merchant.shopName,o.merchant.shopAddress,o.startTime,o.endTime,o.salary,o.merchant.merchantID"
					+" from Order as o where o.employee.employeeID='"
					+employee.getEmployeeID()+"'"
					+" and o.endTime<'"+today+"'"
					+" and o.endTime>='"+oldDay+"'"
					+" and o.ifFinish='1'";	//查询本周以前完成任务的信息
		session.put("orderHistory", employeeDAO.findByHQL(hql1));
		return employeeDAO.findByHQL(hql1);
	}
	
	public List displayMonth(Employee employee){//显示最近30天已完成的任务信息
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		employee=(Employee)session.get("employee");
		Date currentTime=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(currentTime);
		
		Calendar date = Calendar.getInstance();
		date.setTime(currentTime);
		String oldDay="";
		Date oldTime=null;
		System.out.println(today);	//系统当前时间 
		date.set(Calendar.DATE, date.get(Calendar.DATE) - 29);
		try {
			oldTime = formatter.parse(formatter.format(date.getTime()));
			oldDay = formatter.format(oldTime);
			System.out.println(oldDay);	//系统当前时间 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String hql1="select o.merchant.shopName,o.merchant.shopAddress,o.startTime,o.endTime,o.salary,o.merchant.merchantID"
					+" from Order as o where o.employee.employeeID='"
					+employee.getEmployeeID()+"'"
					+" and o.endTime<'"+today+"'"
					+" and o.endTime>='"+oldDay+"'"
					+" and o.ifFinish='1'";	//查询最近30天完成任务的信息
		session.put("orderHistory", employeeDAO.findByHQL(hql1));
		return employeeDAO.findByHQL(hql1);
	}
}
