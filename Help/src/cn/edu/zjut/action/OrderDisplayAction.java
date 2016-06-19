/*�ܹ���ģ�飺��ļ��Ϣ��ʾAction*/
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
	
	public String bydefault(){//Ĭ��
		setOrderinfos(orderDisplayController.bydefault());
		return "success";
	}
	public String bysalary(){//н��
		setOrderinfos(orderDisplayController.bysalary());
		return "success";
	}
	public String byrank(){//����
		setOrderinfos(orderDisplayController.byrank());
		return "success";
	}
	public String byneed(){//����
		setOrderinfos(orderDisplayController.byneed());
		return "success";
	}
	
	public String checkmerchant(){//�鿴��ϸ����
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