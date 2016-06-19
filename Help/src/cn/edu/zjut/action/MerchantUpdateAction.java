/*商家个人信息更新action*/
package cn.edu.zjut.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.service.IMerchantRegisterController;

public class MerchantUpdateAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Merchant merchant;
	private IMerchantRegisterController merchantRegisterController = null;
	
	public Merchant getMerchant() {
		return merchant;
	}
	
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public IMerchantRegisterController getMerchantRegisterController() {
		return merchantRegisterController;
	}

	public void setMerchantRegisterController(IMerchantRegisterController merchantRegisterController) {
		this.merchantRegisterController = merchantRegisterController;
	}
	
	public String updated() {
		if(merchantRegisterController.update(merchant))
			return "updatesuccess";
		else return "updatefailed";
	}
	
	public String update() {
		if(merchantRegisterController.update(merchant))
			return "updatesuccess";
		else return "updatefailed";
	}
	
	public String uploadheader() {
		if(merchantRegisterController.register(merchant))
			return "uploadsuccess";
		else return "uploadfailed";
	}
}