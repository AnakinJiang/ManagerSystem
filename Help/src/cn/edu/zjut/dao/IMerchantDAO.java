/*IMerchantDAO:�̼�DAO�ӿ���*/
package cn.edu.zjut.dao;
import cn.edu.zjut.po.Merchant;

public interface IMerchantDAO {
	boolean login(Merchant merchant);//�̼ҵ�¼
	boolean findByIDNum(Merchant merchant);//�����̼����֤�����̼�
	boolean register(Merchant merchant);//����һ���̼���Ϣ
	boolean update(Merchant merchant);//�����̼���Ϣ
	boolean save(Merchant merchant);
	public Merchant find(String merchantID) ;//�����̼�ID�����̼�
}
