package cn.edu.zjut.service;


import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.EmployeeDAO;
import cn.edu.zjut.dao.GroupDAO;
import cn.edu.zjut.po.Employee;
import cn.edu.zjut.po.Igroup;

public class EmployeeTeamController implements IEmployeeTeamController {
	private EmployeeDAO employeeDAO;
	private GroupDAO groupDAO;
	
	private Map<String, Object> session;
	public List findTeam() {
		// TODO Auto-generated method stub
		System.out.println("execute --findTeams()-- method.");
		return employeeDAO.findTeams();
	}
	
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	public GroupDAO getGroupDAO() {
		return groupDAO;
	}
	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}
	
	
	@Override
	public boolean donate(Igroup group){
		return groupDAO.merge(group);
	}
	
	@Override
	public boolean updateIgroupID() {
		// TODO Auto-generated method stub
		System.out.println("开始更新");
		return employeeDAO.updateIgroupID();
		
	}

	public boolean exitTeam() {
		// TODO Auto-generated method stub
		
		return employeeDAO.exitTeam();
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	

}
