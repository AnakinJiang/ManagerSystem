/*MerchantLoginController.java
 *实现登录的登录功能*/
package cn.edu.zjut.service;
import cn.edu.zjut.dao.IMerchantDAO;
import cn.edu.zjut.po.Merchant;

public class MerchantLoginController implements IMerchantLoginController{
	private IMerchantDAO merchantDAO;
	public IMerchantDAO getMerchantDAO() {
		return merchantDAO;
	}
	public void setMerchantDAO(IMerchantDAO merchantDAO) {
		this.merchantDAO = merchantDAO;
	}
	public MerchantLoginController(){//构造方法
		//System.out.println("create MerchantLoginController.");
	}
	public boolean login(Merchant merchant) {//商家登录，成功返回true，失败返回false
		System.out.println("execute --login()-- method.");
		if(merchantDAO.login(merchant)){//查找数据库是否有该商家的信息
			return true;
		}
		else{
			return false;
		}
	}

}
