/*商家订单实现controller，实现了订单发布，查询未完成订单，查询已完成订单等多种方法*/
package cn.edu.zjut.service;

import cn.edu.zjut.dao.IOrderDAO;
import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.po.Order;

import com.opensymphony.xwork2.ActionContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by stiles on 15/12/22.
 */
public class MerchantOrderController implements IMerchantOrderController {
    private IOrderDAO orderDAO;
    
    public void setOrderDAO(IOrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public boolean release(Order order, int num) {//发布订单
    	Merchant merchant;
        ActionContext ctx= ActionContext.getContext();
        Map<String, Object> session = (Map) ctx.getSession();
        Map<String, Object> request = (Map) ctx.get("request");

        merchant = (Merchant)session.get("merchant");
        order.setMerchant(merchant);
        order.setReleaseTime(new Date());
        order.setIfFinish(false);
        long  time=orderDAO.findtwoOrder();
        session.put("time", time);
        for (int i = 0; i < num; i++) {
            orderDAO.save(order);
        }
        return true;
    }

    @Override
    public List findFinished(Merchant merchant) {
        return orderDAO.findFinished(merchant);
    }

    @Override
    public List findUnfinished(Merchant merchant) {
        return orderDAO.findUnfinished(merchant);
    }

	@Override
	public List findPayed(Merchant merchant) {
		return orderDAO.findPayed(merchant);
	}

	@Override
	public List findUnpayed(Merchant merchant) {
		return orderDAO.findUnpayed(merchant);
	}
}
