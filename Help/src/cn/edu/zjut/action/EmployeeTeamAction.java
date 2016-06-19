package cn.edu.zjut.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



import cn.edu.zjut.po.Employee;
import cn.edu.zjut.po.Igroup;
import cn.edu.zjut.service.EmployeeTeamController;

public class EmployeeTeamAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Employee employee;
	private Igroup igroup;
	private EmployeeTeamController employeeTeamsController;
	private List teamMemberList;
	private Map<String,Object> session;
	
	public String findTeam(){
		teamMemberList=employeeTeamsController.findTeam();
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		session.put("teamMemberList", teamMemberList);
		String groupid="";
		if(teamMemberList!=null && teamMemberList.size()>0){
			groupid = ((Employee) teamMemberList.get(0)).getGroup().getGroupID();
		}
		if(groupid!=null &&groupid!=""){
			session.put("groupID", groupid);
		    return "teamfound";
		}
		else return "teamnotfound";
	}
	
	public String donate(){//¾èÏ×
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		double money = igroup.getTmpMoney();
		//System.out.println(money);
		Igroup group= (Igroup)session.get("myGroup");
		double newMoneyPool = money+group.getMoneyPool();
		group.setMoneyPool(newMoneyPool);
		
		if(newMoneyPool<=group.getPoolFull() && employeeTeamsController.donate(group)){
			return "succeed";
		}
		else return "failed";
	}
	
	public String employeeExitTeam(){
		if(employeeTeamsController.exitTeam())
			return "success";
		return "failed";
	}
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public EmployeeTeamController getEmployeeTeamController() {
		return employeeTeamsController;
	}


	public void setEmployeeTeamController(EmployeeTeamController employeeTeamsController) {
		this.employeeTeamsController = employeeTeamsController;
	}


	public List getTeamMemberList() {
		return teamMemberList;
	}


	public void setTeamMemberList(List teamMemberList) {
		this.teamMemberList = teamMemberList;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Igroup getIgroup() {
		return igroup;
	}

	public void setIgroup(Igroup igroup) {
		this.igroup = igroup;
	}
	
	
}
