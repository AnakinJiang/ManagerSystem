package cn.edu.zjut.service;

import cn.edu.zjut.po.Merchant;

public interface IMerchantController {
	boolean delete(Merchant merchant);
	boolean pass(Merchant merchant);

}
