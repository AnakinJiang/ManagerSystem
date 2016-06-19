/*商家登录action*/
package cn.edu.zjut.action;
import com.opensymphony.xwork2.ActionSupport;
import com.teetaa.util.MD5;

import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.service.IMerchantLoginController;

public class MerchantLoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Merchant merchant;
	private IMerchantLoginController MerchantLoginController;
	
	public Merchant getMerchant() {
		return merchant;
	}
	
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	
	public void setMerchantLoginController(
			IMerchantLoginController MerchantRegisterController) {
		this.MerchantLoginController = MerchantRegisterController;
	}
	
	public String login(){
		String securePassword="";
		MD5 md5=new MD5();
		try {
			//对密码进行MD5加密
			securePassword = md5.md5Encode(merchant.getMerchantPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		merchant.setMerchantPassword(securePassword);
		if(MerchantLoginController.login(merchant)){
			return "loginsuccess";
		}
		else{
			return "loginfailed";
		}
	}
	
}
