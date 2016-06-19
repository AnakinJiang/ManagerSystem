package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.dao.IOrderDAO;
import cn.edu.zjut.po.Employee;
import cn.edu.zjut.po.Order;

public class OrderUpdateController implements IOrderUpdateController{
	private IOrderDAO orderDAO = null;

	public OrderUpdateController(){
	}
	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public synchronized boolean accept(Order order,Employee employee,String releaseTime){//½ÓÊÜÕÐÄ¼
		System.out.println("Controller:"+order.getReleaseTime());
		return orderDAO.accept(order,employee,releaseTime);
	}
	public boolean submit(Order order) { //Ìá½»ÈÎÎñ
		order.setIfFinish(true);
		if(orderDAO.update(order)) return true;
		return false;
	}
	public boolean pay(Order order) { //Ö§¸¶ÈÎÎñ¹¤×Ê
		order.setIfPay(true);
		order.setIfFinish(true);
		if(orderDAO.merge(order)) return true;
		return false;
	}
	
	public double findRate(Order order){//²éÑ¯±¶ÂÊ
		String hql="select i.rate from Employee as e , Order as o , Igroup as i "
				+ "where e.employeeID=o.employee.employeeID "
				+ "and i.groupID=e.group.groupID "
				+ "and o.employee.employeeID="+"'"+order.getEmployee().getEmployeeID()+"'";
		List list = orderDAO.findByHql(hql);
		if(list!=null && list.size()>0){
			double rate = (Double)list.get(0);
			return rate;
		}
		return 1;
	}
}
