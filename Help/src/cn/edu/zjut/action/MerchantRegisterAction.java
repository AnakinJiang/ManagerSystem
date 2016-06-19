/*商家注册action*/
package cn.edu.zjut.action;
import com.opensymphony.xwork2.ActionSupport;
import com.teetaa.util.MD5;

import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.service.IMerchantRegisterController;

public class MerchantRegisterAction extends ActionSupport{

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

	public String register() {
		String securePassword="";
		MD5 md5=new MD5();
		try {
			//对密码进行MD5加密
			securePassword = md5.md5Encode(merchant.getMerchantPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		merchant.setMerchantPassword(securePassword);
		if(merchantRegisterController.register(merchant) &&
				merchantRegisterController.uploadSecurityLicence(merchant) &&
				merchantRegisterController.uploadBusinessLicence(merchant)){
			return "regSUCCESS";
		}
		return "regFAILED";
	}
}