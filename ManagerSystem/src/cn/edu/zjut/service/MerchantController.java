package cn.edu.zjut.service;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.IManagerDAO;
import cn.edu.zjut.dao.IMerchantDAO;
import cn.edu.zjut.po.Merchant;

public class MerchantController implements IMerchantController{
	private Map<String, Object> session;
	private IMerchantDAO merchantDAO;
	public IMerchantDAO getMerchantDAO() {
		return merchantDAO;
	}
	public void setMerchantDAO(IMerchantDAO merchantDAO) {
		this.merchantDAO = merchantDAO;
	}
	/*@Override
	public boolean findMerchant(String merchantID) {
		// TODO Auto-generated method stub
				System.out.println("-----findMerchantController-----");
				ActionContext ctx= ActionContext.getContext();
				session=(Map) ctx.getSession();
				String hql = "from Merchant as merhcant where merchantID='"+merchantID+"'";
				System.out.println(merchantID);
				List list = merchantDAO.findByHql(hql);
				System.out.println(list.size());
				System.out.println("返回商家信息成功！");
				session.put("merchant", list.get(0));
				return true;
				
	}*/
	@Override
	public boolean delete(Merchant merchant) {
		// TODO Auto-generated method stub
		System.out.println("-----MerchantDeleteController-----");
		merchantDAO.delete(merchant);
		return true;
	}
	@Override
	public boolean pass(Merchant merchant) {
		// TODO Auto-generated method stub
		System.out.println("-----MerchantPassController-----");
		merchant.setMerchantState(true);
		merchantDAO.update(merchant);
		return true;
	}

}
