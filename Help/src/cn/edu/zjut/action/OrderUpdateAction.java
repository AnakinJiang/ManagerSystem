/*ÊÜ¹ÍÕß×¢²á¸¨ÖúAction*/
package cn.edu.zjut.action;

import java.text.DecimalFormat;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.po.*;
import cn.edu.zjut.service.IOrderUpdateController;

public class OrderUpdateAction {
	/**
	 * 
	 */
	private IOrderUpdateController orderUpdateController;
	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	private Employee employee;
	private Order order;
	private String releaseTime;

	public IOrderUpdateController getOrderUpdateController() {
		return orderUpdateController;
	}

	public void setOrderUpdateController(IOrderUpdateController orderUpdateController) {
		this.orderUpdateController = orderUpdateController;
	}

	@SuppressWarnings("rawtypes")
	public String accept(){//½ÓÊÜÕÐÄ¼
		Map session=ActionContext.getContext().getSession();
		employee=(Employee)session.get("employee");
		System.out.println("InAction:"+order.getReleaseTime());
		if(employee!=null && employee.isEmployeeState()){  //¼ì²éÈ¨ÏÞ
			if(orderUpdateController.accept(order,employee,releaseTime)){
				System.out.println(order.getStartTime());
				return "success";
			}
			return "failed";
		}
		else return "noright";  //Ã»ÓÐÈ¨ÏÞ
	}
	
	@SuppressWarnings({ "rawtypes" })
	public String submit(){//Íê³ÉÈÎÎñ
		Map session=ActionContext.getContext().getSession();
		order=(Order) session.get("order");
		System.out.println(order.getOrderID());
		if(orderUpdateController.submit(order)){
			return "success";
		}
		else return "failed";
	}
	
	@SuppressWarnings({ "rawtypes" })
	public String merchantPay(){//Ö§¸¶¶©µ¥
		Map session=ActionContext.getContext().getSession();
		order=(Order) session.get("order");
		
//		System.out.println("OrderID="+order.getOrderID());
//		System.out.println("isIfPay="+order.isIfPay());
//		System.out.println("EmployeeName="+order.getEmployee().getEmployeeName());

		double rate = orderUpdateController.findRate(order);
		double trueSalary = rate*order.getSalary();
		DecimalFormat df = new DecimalFormat("#.0");  
        System.out.println(df.format(trueSalary));
        double new_trueSalary = Double.parseDouble(df.format(trueSalary).toString());
        System.out.println("double---------->"+Double.parseDouble(df.format(trueSalary).toString()));
		if(new_trueSalary>0){
			order.setTrueSalary(new_trueSalary);
			if(orderUpdateController.pay(order)){
				return "success";
			}
		}
		return "failed";
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
