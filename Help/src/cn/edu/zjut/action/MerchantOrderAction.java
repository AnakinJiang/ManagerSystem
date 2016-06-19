/*商家发布订单action，包含日期的格式转换*/
package cn.edu.zjut.action;
import cn.edu.zjut.po.Order;
import cn.edu.zjut.service.MerchantOrderController;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by stiles on 15/12/22.
 */
public class MerchantOrderAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private MerchantOrderController orderReleaseController;
    private String startTimeString;
    private String endTimeString;
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private Order order;

    public String getStartTimeString() {
        return startTimeString;
    }

    public void setStartTimeString(String startTimeString) {
        this.startTimeString = startTimeString;
    }

    public String getEndTimeString() {
        return endTimeString;
    }

    public void setEndTimeString(String endTimeString) {
        this.endTimeString = endTimeString;
    }
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setOrderReleaseController(MerchantOrderController orderReleaseController) {
        this.orderReleaseController = orderReleaseController;
    }

    private String timeConvert(String in) {
        String out;
        out = in.replace('-', '/');
        out = out.replace('T', ' ');
        return out;
    }

    public String releaseOrder() {
        startTimeString = timeConvert(startTimeString);
        endTimeString = timeConvert(endTimeString);
        order.setReleaseTime(new Date());
        order.setStartTime(new Date(startTimeString));
        order.setEndTime(new Date(endTimeString));
        order.setIfFinish(false);

        if (orderReleaseController.release(order, number)){
            return "success";
        }

        return "error";
    }
}
