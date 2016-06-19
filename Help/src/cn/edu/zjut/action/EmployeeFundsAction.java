/*�ܹ����ʲ����㼰���ݿ��ӻ�Action*/
package cn.edu.zjut.action;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.po.Employee;
import cn.edu.zjut.service.IEmployeeFundsController;

public class EmployeeFundsAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Employee employee;
	
	@SuppressWarnings("unused")
	private IEmployeeFundsController employeeFundsController;
	
	public void setEmployeeFundsController(
			IEmployeeFundsController employeeFundsController) {
		this.employeeFundsController = employeeFundsController;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String calculateMyFunds(){//�����ҵ��ʲ�
		if(employeeFundsController.calculateMyFunds(employee)){
			return "succeed";
		}
		else return "failed";	
	}
}
