/*MerchantLoginController.java
 *ʵ�ֵ�¼�ĵ�¼����*/
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
	public MerchantLoginController(){//���췽��
		//System.out.println("create MerchantLoginController.");
	}
	public boolean login(Merchant merchant) {//�̼ҵ�¼���ɹ�����true��ʧ�ܷ���false
		System.out.println("execute --login()-- method.");
		if(merchantDAO.login(merchant)){//�������ݿ��Ƿ��и��̼ҵ���Ϣ
			return true;
		}
		else{
			return false;
		}
	}

}
