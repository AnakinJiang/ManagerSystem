/*受雇者注册Action*/
package cn.edu.zjut.action;
import java.io.File;

import com.opensymphony.xwork2.ActionSupport;
import com.teetaa.util.MD5;

import cn.edu.zjut.po.Employee;
import cn.edu.zjut.service.IEmployeeRegisterController;

public class EmployeeRegisterAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	private Employee employee;
	private File face;

	private IEmployeeRegisterController employeeRegisterController = null;

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

	public File getFace() {
		return face;
	}

	public void setFace(File face) {
		this.face = face;
	}

	public String register() {
		System.out.println("-----EmployeeRegisterAction-----");
		String securePassword="";
		MD5 md5=new MD5();
		try {
			//对密码进行MD5加密
			securePassword = md5.md5Encode(employee.getEmployeePassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		employee.setEmployeePassword(securePassword);
		employee.setPool(0);
	    System.out.println("人脸路径："+employee.getEmployeeFace());
		if(employeeRegisterController.register(employee)&&employeeRegisterController.uploadface(face,employee.getEmployeeID())){
			return "registersuccess";
		}
		return "registerfailed";
	}
}