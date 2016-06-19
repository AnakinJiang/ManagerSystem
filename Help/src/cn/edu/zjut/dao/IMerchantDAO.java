/*IMerchantDAO:商家DAO接口类*/
package cn.edu.zjut.dao;
import cn.edu.zjut.po.Merchant;

public interface IMerchantDAO {
	boolean login(Merchant merchant);//商家登录
	boolean findByIDNum(Merchant merchant);//根据商家身份证查找商家
	boolean register(Merchant merchant);//储存一个商家信息
	boolean update(Merchant merchant);//更新商家信息
	boolean save(Merchant merchant);
	public Merchant find(String merchantID) ;//根据商家ID查找商家
}
