/*受雇者个人信息更新Action*/
package cn.edu.zjut.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.po.Employee;
import cn.edu.zjut.service.IEmployeeRegisterController;

public class EmployeeUpdateAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Employee employee;
	private IEmployeeRegisterController employeeRegisterController = null;
	private Map<String,Object> session;
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public IEmployeeRegisterController getEmployeeRegisterController() {
		return employeeRegisterController;
	}

	public void setEmployeeRegisterController(IEmployeeRegisterController employeeRegisterController) {
		this.employeeRegisterController = employeeRegisterController;
	}
	
	public String payPromise(){
		ActionContext ctx= ActionContext.getContext();
		session = (Map)ctx.getSession();
		Employee t_employee = (Employee)session.get("myInfo");
		double pool = employee.getPool();
		//System.out.println("pool="+pool);
		t_employee.setPool(pool);
		if(employeeRegisterController.update(t_employee)){
			return "succeed";
		}else return "failed";
	}
	public String registerUpdate() {
		if(employeeRegisterController.registerUpdate(employee))
			return "updatesuccess";
		else return "updatefailed";
	}
	
	public String update() {
		if(employeeRegisterController.update(employee))
			return "updatesuccess";
		else return "updatefailed";
	}
	
	public String uploadheader() {
		if(employeeRegisterController.register(employee))
			return "uploadsuccess";
		else return "uploadfailed";
	}
	public String check() {
		if(employeeRegisterController.check(employee.getEmployeeID()))
			return "success";
		else
			return "failed";
		
	}
}