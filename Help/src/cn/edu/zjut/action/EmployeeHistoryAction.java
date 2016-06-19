/*受雇者历史任务查询Action*/
package cn.edu.zjut.action;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.po.Employee;
import cn.edu.zjut.service.IEmployeeHistoryController;

public class EmployeeHistoryAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Employee employee;
	@SuppressWarnings("rawtypes")
	private List orderHistory;
	private IEmployeeHistoryController employeeHistoryController;

	public void setEmployeeHistoryController(
			IEmployeeHistoryController employeeHistoryController) {
		this.employeeHistoryController = employeeHistoryController;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String findAll(){//查询历史全部任务
		try{
			setOrderHistory(employeeHistoryController.displayALL(employee));	
		}catch(Exception e){return "failed";}	
		return "succeed";	
	}
	
	public String findWeek(){//查询历史最近一周任务
		try{
			setOrderHistory(employeeHistoryController.displayWeek(employee));	
		}catch(Exception e){return "failed";}	
		return "succeed";	
	}
	
	public String findMonth(){//查询最近30天的历史任务
		try{
			setOrderHistory(employeeHistoryController.displayMonth(employee));	
		}catch(Exception e){return "failed";}	
		return "succeed";
	}

	@SuppressWarnings("rawtypes")
	public List getOrderHistory() {
		return orderHistory;
	}

	@SuppressWarnings("rawtypes")
	public void setOrderHistory(List orderHistory) {
		this.orderHistory = orderHistory;
	}
}
