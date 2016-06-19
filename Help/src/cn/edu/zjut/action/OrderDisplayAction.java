/*受雇者模块：招募信息显示Action*/
package cn.edu.zjut.action;

import java.util.List;

import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.service.IOrderDisplayController;

public class OrderDisplayAction {
	private IOrderDisplayController orderDisplayController=null;
	@SuppressWarnings("rawtypes")
	private List orderinfos;
	private Merchant merchant;

	public IOrderDisplayController getOrderDisplayController() {
		return orderDisplayController;
	}

	public void setOrderDisplayController(IOrderDisplayController orderDisplayController) {
		this.orderDisplayController = orderDisplayController;
	}
	
	@SuppressWarnings("rawtypes")
	public List getOrderinfos() {
		return orderinfos;
	}

	@SuppressWarnings("rawtypes")
	public void setOrderinfos(List orderinfos) {
		this.orderinfos = orderinfos;
	}
	
	public String bydefault(){//默认
		setOrderinfos(orderDisplayController.bydefault());
		return "success";
	}
	public String bysalary(){//薪资
		setOrderinfos(orderDisplayController.bysalary());
		return "success";
	}
	public String byrank(){//好评
		setOrderinfos(orderDisplayController.byrank());
		return "success";
	}
	public String byneed(){//人数
		setOrderinfos(orderDisplayController.byneed());
		return "success";
	}
	
	public String checkmerchant(){//查看详细资料
		setMerchant(orderDisplayController.checkmerchant(merchant));
		return "success";
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
}