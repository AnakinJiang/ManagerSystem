package cn.edu.zjut.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Igroup {

	private String groupID;//���
	private String groupName;//����
	private String groupDescribe;//С������
	private Date createTime;//С�鴴��ʱ��
	private double moneyPool;//������ʽ�����
	private double poolFull=500;//������ʽ�����
	private double rate;//����
	private double tmpMoney;
	
	//�����Ǹ����Ե�get��set����
	public String getGroupID() {
		return groupID;
	}
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDescribe() {
		return groupDescribe;
	}
	public void setGroupDescribe(String groupDescribe) {
		this.groupDescribe = groupDescribe;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public double getMoneyPool() {
		return moneyPool;
	}
	public void setMoneyPool(double moneyPool) {
		this.moneyPool = moneyPool;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getPoolFull() {
		return poolFull;
	}
	public void setPoolFull(double poolFull) {
		this.poolFull = poolFull;
	}
	public double getTmpMoney() {
		return tmpMoney;
	}
	public void setTmpMoney(double tmpMoney) {
		this.tmpMoney = tmpMoney;
	}
}
