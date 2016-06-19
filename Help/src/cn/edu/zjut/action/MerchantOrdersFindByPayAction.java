/*商家查询已支付和未支付订action*/
package cn.edu.zjut.action;

import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.service.MerchantOrderController;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;

import java.util.List;
import java.util.Map;

/**
 * Created by stiles on 16/1/1.
 */
public class MerchantOrdersFindByPayAction extends ActionSupport {
    private MerchantOrderController orderController;

    public void setOrderController(MerchantOrderController orderController) {
        this.orderController = orderController;
    }

    
    public String findUnpayedOrder(){
        Map session = ServletActionContext.getContext().getSession();
        Merchant merchant = (Merchant)session.get("merchant");
        if (merchant == null) {
            return ERROR;
        }
        List list = orderController.findUnpayed(merchant);
        session.put("list", list);
        return SUCCESS;
    }

    public String findPayedOrder() {
        Map session = ActionContext.getContext().getSession();
        Merchant merchant = (Merchant)session.get("merchant");
        if (merchant == null) {
            return ERROR;
        }
        List list = orderController.findPayed(merchant);
        session.put("list", list);
        return SUCCESS;
    }
}
