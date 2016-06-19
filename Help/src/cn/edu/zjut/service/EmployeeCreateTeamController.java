package cn.edu.zjut.service;

import cn.edu.zjut.dao.GroupDAO;
import cn.edu.zjut.po.Igroup;

public class EmployeeCreateTeamController implements IEmployeeCreateTeamController {
	private GroupDAO igroupDAO;
	
	public boolean create(Igroup igroup) {
		// TODO Auto-generated method stub
		if(igroupDAO.create(igroup)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public GroupDAO getIgroupDAO() {
		return igroupDAO;
	}
	public void setIgroupDAO(GroupDAO igroupDAO) {
		this.igroupDAO = igroupDAO;
	}

}
