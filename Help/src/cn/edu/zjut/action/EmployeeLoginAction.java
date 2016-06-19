/*受雇者登录Action*/
package cn.edu.zjut.action;
import com.opensymphony.xwork2.ActionSupport;
import com.teetaa.util.MD5;

import cn.edu.zjut.po.Employee;
import cn.edu.zjut.service.IEmployeeLoginController;


public class EmployeeLoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Employee employee;
	private IEmployeeLoginController employeeLoginController;
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void setEmployeeLoginController(
			IEmployeeLoginController employeeRegisterController) {
		this.employeeLoginController = employeeRegisterController;
	}
	
	public String login(){
		String securePassword="";
		MD5 md5=new MD5();
		try {
			//对密码进行MD5加密
			securePassword = md5.md5Encode(employee.getEmployeePassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		employee.setEmployeePassword(securePassword);
		if(employeeLoginController.login(employee)){
			return "loginsuccess";
		}
		else{
			return "loginfailed";
		}
	}
	
}
