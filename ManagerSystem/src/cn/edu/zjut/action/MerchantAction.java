package cn.edu.zjut.action;

import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.service.IMerchantController;

public class MerchantAction {

	private Merchant  merchant;
	private IMerchantController merchantController;

		
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public IMerchantController getMerchantController() {
		return merchantController;
	}
	public void setMerchantController(IMerchantController merchantController) {
		this.merchantController = merchantController;
	}
		
		public String delete() {
			System.out.println("-----deleteAction-----");
			if (merchantController.delete(merchant)) {
				return "success";
			} else {
				return "fail";
			}
		}

		public String pass() {
			System.out.println("-----passAction-----");
			if (merchantController.pass(merchant)) {
				return "success";
			} else {
				return "fail";
			}
		}
		

	}


