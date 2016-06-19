//�ܹ�����ʷ����Service
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
	
	public List displayALL(Employee employee){//��ʾȫ����ʷ
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		employee=(Employee)session.get("employee");
		Date currentTime=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(currentTime);
		System.out.println(today);	//ϵͳ��ǰʱ�� 
		String hql1="select o.merchant.shopName,o.merchant.shopAddress,o.startTime,o.endTime,o.salary,o.merchant.merchantID"
					+" from Order as o where o.employee.employeeID='"
					+employee.getEmployeeID()+"'"
					+" and o.endTime<'"+today+"'"
					+" and o.ifFinish='1'";	//��ѯ������ǰ����������Ϣ
		session.put("orderHistory", employeeDAO.findByHQL(hql1));
		return employeeDAO.findByHQL(hql1);
	}
	
	public List displayWeek(Employee employee){//��ʾ���һ������ɵ�������Ϣ
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
		System.out.println(today);	//ϵͳ��ǰʱ�� 
		date.set(Calendar.DATE, date.get(Calendar.DATE) - 6);
		try {
			oldTime = formatter.parse(formatter.format(date.getTime()));
			oldDay = formatter.format(oldTime);
			System.out.println(oldDay);	//ϵͳ��ǰʱ�� 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String hql1="select o.merchant.shopName,o.merchant.shopAddress,o.startTime,o.endTime,o.salary,o.merchant.merchantID"
					+" from Order as o where o.employee.employeeID='"
					+employee.getEmployeeID()+"'"
					+" and o.endTime<'"+today+"'"
					+" and o.endTime>='"+oldDay+"'"
					+" and o.ifFinish='1'";	//��ѯ������ǰ����������Ϣ
		session.put("orderHistory", employeeDAO.findByHQL(hql1));
		return employeeDAO.findByHQL(hql1);
	}
	
	public List displayMonth(Employee employee){//��ʾ���30������ɵ�������Ϣ
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
		System.out.println(today);	//ϵͳ��ǰʱ�� 
		date.set(Calendar.DATE, date.get(Calendar.DATE) - 29);
		try {
			oldTime = formatter.parse(formatter.format(date.getTime()));
			oldDay = formatter.format(oldTime);
			System.out.println(oldDay);	//ϵͳ��ǰʱ�� 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String hql1="select o.merchant.shopName,o.merchant.shopAddress,o.startTime,o.endTime,o.salary,o.merchant.merchantID"
					+" from Order as o where o.employee.employeeID='"
					+employee.getEmployeeID()+"'"
					+" and o.endTime<'"+today+"'"
					+" and o.endTime>='"+oldDay+"'"
					+" and o.ifFinish='1'";	//��ѯ���30������������Ϣ
		session.put("orderHistory", employeeDAO.findByHQL(hql1));
		return employeeDAO.findByHQL(hql1);
	}
}
