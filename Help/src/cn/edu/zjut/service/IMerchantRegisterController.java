/*�̼�ע�����controller�������̼�ע�ᣬ�ϴ�Ӫҵִ�գ��������֤�����µȳ�����*/
package cn.edu.zjut.service;

import cn.edu.zjut.po.Merchant;

import java.io.File;

/**
 * Created by Stiles on 2015/12/12.
 */
public interface IMerchantRegisterController {
    boolean register(Merchant merchant);//ע��ӿ�
    boolean uploadBusinessLicence(Merchant merchant);//Ӫҵִ���ϴ��ӿ�
    boolean uploadSecurityLicence(Merchant merchant);//��������ϴ��ӿ�
	boolean update(Merchant merchant);
}
