package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.po.Order;

public interface IOrderDisplayController {

	List<Order> bydefault();
	
	List<Order> byneed();
	
	List<Order> byrank();
	
	List<Order> bysalary();

	Merchant checkmerchant(Merchant merchant);

}
