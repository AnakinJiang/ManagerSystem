package cn.edu.zjut.service;

import java.util.Map;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.IEmployeeDAO;
import cn.edu.zjut.dao.IGroupDAO;
import cn.edu.zjut.po.Employee;
import cn.edu.zjut.po.Igroup;

public class SearchGroupController implements ISearchGroupController{
	private Map<String, Object> session;
	private IGroupDAO GroupDAO = null;
	private IEmployeeDAO EmployeeDAO = null;

	public IGroupDAO getGroupDAO() {
		return GroupDAO;
	}
	public void setGroupDAO(IGroupDAO groupDAO) {
		GroupDAO = groupDAO;
	}
	public IEmployeeDAO getEmployeeDAO() {
		return EmployeeDAO;
	}
	public void setEmployeeDAO(IEmployeeDAO employeeDAO) {
		EmployeeDAO = employeeDAO;
	}
	//该方法已经不用了
	public boolean search(Igroup group){
		System.out.println("execute-search--servicemothod");
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		//Igroup写成IGroup会发生找不到实体类的错误(not mapping)
		String HQL="select g.groupName "+" from Igroup as g where g.groupName like '"+group.getGroupName()+"%'";//模糊查找组名
		List l = GroupDAO.findByHQL(HQL);
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i));
		}
		if(GroupDAO.findByHQL(HQL).isEmpty()){
			return false;
		}
		else {
			session.put("groups", GroupDAO.findByHQL(HQL));
			return true;
		}
		
	}
	
    public boolean join(Igroup group){
    	System.out.println("execute-search--servicemothod");
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		//Igroup写成IGroup会发生找不到实体类的错误(not mapping)
		String HQL="select g "+" from Igroup as g where g.groupName = '"+group.getGroupName()+"'";//查找组的具体对象
		List grouplist = GroupDAO.findByHQL(HQL);
		for(int i=0;i<grouplist.size();i++){
			Igroup ig = (Igroup)grouplist.get(i);
			System.out.println(ig.getGroupID());
		}
		if(grouplist.isEmpty()){
			return false;
		}
		else {
			//session.put("groups", GroupDAO.findByHQL(HQL));
			Employee employee = (Employee) session.get("employee");
			employee.setGroup((Igroup)grouplist.get(0));
			if(EmployeeDAO.update(employee)){
				return true;
			}
			return false;
		}
	}
}
