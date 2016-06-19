package cn.edu.zjut.action;

import java.sql.Timestamp;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.po.Igroup;
import cn.edu.zjut.service.EmployeeCreateTeamController;
import cn.edu.zjut.service.EmployeeTeamController;

public class EmployeeCreateTeamAction extends ActionSupport {
	private Igroup igroup;
	private EmployeeCreateTeamController employeeCreateTeamController;
	private EmployeeTeamController employeeTeamController;
	public String employeeCreateTeam(){
		Timestamp now = new Timestamp(System.currentTimeMillis());   
		igroup.setCreateTime(now);
		if(employeeCreateTeamController.create(igroup)){
			if(employeeTeamController.updateIgroupID()){
			return "success";
			}else{
				return "failed";
			}
		}else{
			return "failed";
		}
	}

	public Igroup getIgroup() {
		return igroup;
	}

	public void setIgroup(Igroup igroup) {
		this.igroup = igroup;
	}

	public EmployeeCreateTeamController getEmployeeCreateTeamController() {
		return employeeCreateTeamController;
	}

	public void setEmployeeCreateTeamController(EmployeeCreateTeamController employeeCreateTeamController) {
		this.employeeCreateTeamController = employeeCreateTeamController;
	}

	public EmployeeTeamController getEmployeeTeamController() {
		return employeeTeamController;
	}

	public void setEmployeeTeamController(EmployeeTeamController employeeTeamController) {
		this.employeeTeamController = employeeTeamController;
	}
	
}
