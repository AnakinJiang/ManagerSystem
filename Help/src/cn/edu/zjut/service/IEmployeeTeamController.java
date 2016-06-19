package cn.edu.zjut.service;

import java.util.List;
import cn.edu.zjut.po.Igroup;


public interface IEmployeeTeamController {
	public List findTeam();
	public boolean  updateIgroupID();
	public boolean exitTeam();
	public boolean donate(Igroup group);
}
