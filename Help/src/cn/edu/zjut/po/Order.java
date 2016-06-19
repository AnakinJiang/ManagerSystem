/*�����־û��ඨ���˶����ĸ�������*/
package cn.edu.zjut.po;

import java.util.Date;
/**
 * Created by Stiles on 2015/12/21.
 */
public class Order {
    private String orderID;//������ˮ��,���ظ��������
    private Date releaseTime;//�̼� ����ʱ��
    private Date acceptTime;//�ܹ��� ����ʱ��
    private double salary;//����
    private double trueSalary;//ʵ���յ��Ĺ���
    private String remark;//��ע
    private boolean ifFinish;//�Ƿ������������ʱ������ԭ���Ϊδ��ɣ�ifFinish=false
    private Date startTime;//����ʼʱ��
    private Date endTime;//�����ֹʱ��
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
