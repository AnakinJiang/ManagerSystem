package cn.edu.zjut.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.IOrderDAO;
import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.po.Order;

public class OrderDisplayController implements IOrderDisplayController{
	private IOrderDAO orderDAO;
	private Map<String, Object> session;
	public OrderDisplayController(){}
	
	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List bydefault(){//默认排序
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		Date todaytime=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(todaytime);
		System.out.println(today);
		String hql="select count(o.orderID),o.releaseTime,o.startTime,o.salary,"
				+ "o.merchant.merchantGrade,o.merchant.shopName,o.merchant.merchantID"
				+ " from Order o where o.employee is null and o.endTime>'"+today+"'"
				+ " group by o.merchant.merchantID,o.releaseTime";
		session.put("orderinfos",orderDAO.findByHql(hql));
		return orderDAO.findByHql(hql);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List bysalary(){//薪资排序
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		Date todaytime=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(todaytime);
		System.out.println(today);
		String hql="select count(o.orderID),o.releaseTime,o.startTime,o.salary,"
				+ "o.merchant.merchantGrade,o.merchant.shopName,o.merchant.merchantID"
				+ " from Order o where o.employee is null and o.endTime>'"+today+"'"
				+ " group by o.merchant.merchantID,o.releaseTime "
				+ "order by o.salary DESC";
		session.put("orderinfos",orderDAO.findByHql(hql));
		return orderDAO.findByHql(hql);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List byrank(){//好评排序
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		Date todaytime=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(todaytime);
		System.out.println(today);
		String hql="select count(o.orderID),o.releaseTime,o.startTime,o.salary,"
				+ "o.merchant.merchantGrade,o.merchant.shopName,o.merchant.merchantID"
				+ " from Order o where o.employee is null and o.endTime>'"+today+"'"
				+ " group by o.merchant.merchantID,o.releaseTime "
				+ " order by o.merchant.merchantGrade DESC";
		session.put("orderinfos",orderDAO.findByHql(hql));
		return orderDAO.findByHql(hql);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List byneed(){//人数排序
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		Date todaytime=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(todaytime);
		System.out.println(today);
		String hql="select count(o.orderID),o.releaseTime,o.startTime,o.salary,"
				+ "o.merchant.merchantGrade,o.merchant.shopName,o.merchant.merchantID"
				+ " from Order o where o.employee is null and o.endTime>'"+today+"'"
				+ " group by o.merchant.merchantID,o.releaseTime "
				+ "order by count(o.orderID) DESC";
		session.put("orderinfos",orderDAO.findByHql(hql));
		return orderDAO.findByHql(hql);
	}

	@SuppressWarnings("rawtypes")
	public Merchant checkmerchant(Merchant merchant) { //查看详细资料
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		String merchantID=merchant.getMerchantID();
		String hql="from Order o where o.merchant.merchantID='"+merchantID+"'";
		List result=orderDAO.findByHql(hql);
		merchant=((Order)result.get(0)).getMerchant();
		session.put("merchantinfo",merchant);
		return merchant;
	}
}
