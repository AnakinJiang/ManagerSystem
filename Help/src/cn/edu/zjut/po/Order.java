/*订单持久化类定义了订单的各类属性*/
package cn.edu.zjut.po;

import java.util.Date;
/**
 * Created by Stiles on 2015/12/21.
 */
public class Order {
    private String orderID;//订单流水号,不重复的随机数
    private Date releaseTime;//商家 发布时间
    private Date acceptTime;//受雇者 接受时间
    private double salary;//报酬
    private double trueSalary;//实际收到的工资
    private String remark;//备注
    private boolean ifFinish;//是否完成任务，若超时或其他原因皆为未完成，ifFinish=false
    private Date startTime;//任务开始时间
    private Date endTime;//任务截止时间
    private Merchant merchant;
    private Employee employee;
    private boolean ifPay;

    public Order() {}

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isIfFinish() {
        return ifFinish;
    }

    public void setIfFinish(boolean ifFinish) {
        this.ifFinish = ifFinish;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public boolean isIfPay() {
        return ifPay;
    }

    public void setIfPay(boolean ifPay) {
        this.ifPay = ifPay;
    }

	public double getTrueSalary() {
		return trueSalary;
	}

	public void setTrueSalary(double trueSalary) {
		this.trueSalary = trueSalary;
	}
}
