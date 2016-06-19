package cn.edu.zjut.action;

import cn.edu.zjut.po.Manager;
import cn.edu.zjut.service.IManagerController;

public class ManagerAction {

	private Manager manager;
	private IManagerController managerController;

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public IManagerController getManagerController() {
		return managerController;
	}

	public void setManagerController(IManagerController managerController) {
		this.managerController = managerController;
	}

	public String login() {
		System.out.println("-----LoginAction-----");
		if (managerController.login(manager)) {
			return "success";
		} else
			return "fail";

	}

	public String findAllMerchant() {
		System.out.println("-----findAllMerchantAction-----");
		if (managerController.findAllMerchant()) {
			return "success";
		} else {
			return "fail";
		}
	}

	public String findPassMerchant() {
		System.out.println("-----findPassMerchantAction-----");
		managerController.findPassMerchant();
			return "success";
	}
	
	public String findUnPassMerchant() {
		System.out.println("-----findUnPassMerchantAction-----");
		managerController.findUnPassMerchant();
			return "success";
	}
	

}
