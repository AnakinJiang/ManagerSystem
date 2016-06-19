//受雇者资产计算Service
package cn.edu.zjut.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.IEmployeeDAO;
import cn.edu.zjut.po.Employee;

public class EmployeeFundsController implements IEmployeeFundsController{
	private Map<String, Object> session;
	private IEmployeeDAO employeeDAO;
	
	public EmployeeFundsController(){}//构造方法
	
	public IEmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public boolean calculateMyFunds(Employee employee){
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		employee=(Employee)session.get("employee");
		double salary=0;
		Date currentTime=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(currentTime);
		Calendar date = Calendar.getInstance();
		date.setTime(currentTime);
		String oldDay="";
		Date oldTime=null;
		List salaryList = new ArrayList();
		for(int i=1;i<=10;i++){
			date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
			try {
				oldTime = formatter.parse(formatter.format(date.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			oldDay = formatter.format(oldTime).substring(0, 10);
			String hql1="select sum(trueSalary),order.endTime from Order as order where order.employee.employeeID='"
					+employee.getEmployeeID()+"'"
					+" and order.ifFinish='1' and order.ifPay='1' "
					+" and date(endTime)='"+oldDay+"'";	//查询前i天获得的报酬
			List tmpSalaryList=employeeDAO.findByHQL(hql1);
			if(!tmpSalaryList.isEmpty()){
				Object[] object=(Object[])tmpSalaryList.get(0);
				if(object[0]==null && object[1]==null){	//该天没工资
					object[0]=0;
					object[1]=oldDay;
				}else{
					object[1]=oldDay;
				}
				salaryList.add(object);
			}
		}
		session.put("salaryList", salaryList);
		//查询总资产
		String hql2="select sum(trueSalary) from Order as order where order.employee.employeeID='"+employee.getEmployeeID()+"'"
				+"and order.ifFinish='1' "
				+ "and order.ifPay='1'";
		List salaryList2=employeeDAO.findByHQL(hql2);
		if(!salaryList2.isEmpty()){
			if(salaryList2.get(0)!=null){
				salary=(Double)salaryList2.get(0);
			}
			else{
				salary=0;
			}
			session.put("salarySum", salary);//总资产
			return true;
		}else{
			return false;//找不到
		}
	}
}
