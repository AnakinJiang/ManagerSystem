package cn.edu.zjut.action;

import java.io.File;

import cn.edu.zjut.service.IEmployeeLoginController;

public class EmployeeFaceLoginAction {
	private File face;
	private IEmployeeLoginController employeeLoginController;
	public File getFace() {
		return face;
	}
	public void setFace(File face) {
		this.face = face;
	}
	public IEmployeeLoginController getEmployeeLoginController() {
		return employeeLoginController;
	}

	public void setEmployeeLoginController(IEmployeeLoginController employeeLoginController) {
		this.employeeLoginController = employeeLoginController;
	}

	public String face() {
		System.out.println(1);
		System.out.println(face.exists());
		
		if (employeeLoginController.face(face)) {
			return "loginsuccess";
		} else {
			return "loginfailed";
		}
	}

}
