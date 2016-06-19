package cn.edu.zjut.service;

import cn.edu.zjut.po.Manager;

public interface IManagerController {
	boolean login(Manager manager);
	boolean findAllMerchant();
	void findPassMerchant();
	void findUnPassMerchant();
	/*boolean findMerchat();*/
}
