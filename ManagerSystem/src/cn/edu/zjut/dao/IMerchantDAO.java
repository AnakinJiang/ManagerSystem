package cn.edu.zjut.dao;

import java.util.List;

import cn.edu.zjut.po.Merchant;

public interface IMerchantDAO {
	List findByHql(String hql);
	void delete(Merchant merchant);
	void update(Merchant merchant);
}
