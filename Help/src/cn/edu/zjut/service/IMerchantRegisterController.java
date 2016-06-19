/*商家注册抽象controller，定了商家注册，上传营业执照，卫生许可证，更新等抽象类*/
package cn.edu.zjut.service;

import cn.edu.zjut.po.Merchant;

import java.io.File;

/**
 * Created by Stiles on 2015/12/12.
 */
public interface IMerchantRegisterController {
    boolean register(Merchant merchant);//注册接口
    boolean uploadBusinessLicence(Merchant merchant);//营业执照上传接口
    boolean uploadSecurityLicence(Merchant merchant);//卫生许可上传接口
	boolean update(Merchant merchant);
}
