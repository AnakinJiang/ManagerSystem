package cn.edu.zjut.service;

import cn.edu.zjut.po.Employee;
import cn.edu.zjut.po.Order;

public interface IOrderUpdateController {
	boolean accept(Order order, Employee employee,String releaseTime);
	boolean submit(Order order);
	boolean pay(Order order);
	double findRate(Order order);
}
