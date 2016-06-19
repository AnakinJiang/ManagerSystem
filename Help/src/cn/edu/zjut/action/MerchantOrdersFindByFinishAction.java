/*商家查询已完成和未完成订单action*/
package cn.edu.zjut.action;

import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.service.IMerchantOrderController;
import cn.edu.zjut.service.MerchantOrderController;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;

import java.util.List;
import java.util.Map;

/**
 * Created by stiles on 16/1/1.
 */
public class MerchantOrdersFindByFinishAction extends ActionSupport {
    private IMerchantOrderController orderController;

    public void setOrderController(MerchantOrderController orderController) {
        this.orderController = orderController;
    }

    public String findUnfinishedOrder(){
        Map session = ServletActionContext.getContext().getSession();
        Merchant merchant = (Merchant)session.get("merchant");
        if (merchant == null) {
            return "error";
        }
        List list = orderController.findUnfinished(merchant);
        session.put("list", list);
        return "success";
    }

    public String findFinishedOrder() {
        Map session = ActionContext.getContext().getSession();
        Merchant merchant = (Merchant)session.get("merchant");
        if (merchant == null) {
            return "error";
        }
        List list = orderController.findFinished(merchant);
        session.put("list", list);
        return "success";
    }
}
