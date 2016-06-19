//受雇者资产计算接口类
package cn.edu.zjut.service;
import cn.edu.zjut.po.Employee;
import cn.edu.zjut.po.Order;

public interface IEmployeeFundsController {
	boolean calculateMyFunds(Employee employee);//计算我的资产
}
