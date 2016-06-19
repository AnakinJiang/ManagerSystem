package cn.edu.zjut.service;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.IManagerDAO;
import cn.edu.zjut.po.Manager;

public class ManagerController implements IManagerController {
	private Map<String, Object> session;
	private IManagerDAO managerDAO;

	public IManagerDAO getManagerDAO() {
		return managerDAO;
	}

	public void setManagerDAO(IManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}

	@Override
	public boolean login(Manager manager) {
		// TODO Auto-generated method stub
		System.out.println("-----LoginController-----");
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		String id = manager.getManagerId();
		String password = manager.getManagerPassword();
		String hql = "from Manager as manager where managerId='" + id + "' and managerPassword='" + password + "'";
		List list = managerDAO.findByHql(hql);
		if (list.isEmpty()) {
			System.out.println("登录失败！");
			return false;
		} else {
			System.out.println(list.size());
			System.out.println("登录成功！");
			session.put("manager", list.get(0));
			String hql1 = "from Merchant order by merchantGrade desc";
			List listTop = managerDAO.findByHqlTop(hql1);
			session.put("merchantsTop", listTop);
			String hql2 = "from Merchant order by merchantGrade asc";
			List listButtom = managerDAO.findByHqlButtom(hql2);
			session.put("merchantsButtom", listButtom);
			return true;
		}
	}

	@Override
	public boolean findAllMerchant() {
		// TODO Auto-generated method stub
		System.out.println("-----findAllMerchant-----");
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		String hql = "from Merchant as merchant";
		List list = managerDAO.findByHql(hql);
		System.out.println(list.size());
		System.out.println("返回所有商家成功！");
		session.put("merchants", list);
		return true;
		
	}

	@Override
	public void findPassMerchant() {
		// TODO Auto-generated method stub
		System.out.println("-----findPassMerchant-----");
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		String hql = "from Merchant as merchant where merchantState=true";
		List list = managerDAO.findByHql(hql);
		System.out.println(list.size());
		System.out.println("返回通过审核商家成功！");
		session.put("merchants", list);	
	}

	@Override
	public void findUnPassMerchant() {
		// TODO Auto-generated method stub
		System.out.println("-----findUnPassMerchant-----");
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		String hql = "from Merchant as merchant where merchantState=false";
		List list = managerDAO.findByHql(hql);
		System.out.println(list.size());
		System.out.println("返回未通过审核商家成功！");
		session.put("merchants", list);	
	}


}
