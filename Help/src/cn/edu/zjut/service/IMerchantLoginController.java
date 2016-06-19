/*IMerchant.java
 *接口类，含有login、register的抽象方法*/
package cn.edu.zjut.service;
import cn.edu.zjut.po.Merchant;

public interface IMerchantLoginController {
	boolean login(Merchant merchant);//商家登录
}
