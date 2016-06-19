/*商家订单抽象controller，定义了订单发布，查询未完成订单，查询已完成订单等多种抽象方法*/
package cn.edu.zjut.service;

import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.po.Order;

import java.util.List;

/**
 * Created by stiles on 15/12/22.
 */
public interface IMerchantOrderController {
    boolean release(Order order, int num);//鍙戝竷璁㈠崟鎺ュ彛
    List findUnfinished(Merchant merchant);//鏌ユ壘鏈畬鎴愯鍗曠殑鎺ュ彛
    List findFinished(Merchant merchant);//鏌ユ壘瀹屾垚鐨勮鍗�    
    List findPayed(Merchant merchant);//鏌ユ壘鏀粯鐨勮鍗�   
    List findUnpayed(Merchant merchant);//鏌ユ壘鏈敮浠樿鍗曠殑鎺ュ彛
}
