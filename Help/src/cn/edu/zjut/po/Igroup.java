package cn.edu.zjut.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Igroup {

	private String groupID;//组号
	private String groupName;//组名
	private String groupDescribe;//小组描述
	private Date createTime;//小组创建时间
	private double moneyPool;//共享池资金余量
	private double poolFull=500;//共享池资金容量
	private double rate;//倍率
	private double tmpMoney;
	
	//以下是各属性的get和set方法
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
