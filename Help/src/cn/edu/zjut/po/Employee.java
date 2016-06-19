/*Employee.java
 *存放受雇者的个人信息，包括账号、密码、昵称、身份证号、 /
 *真实姓名、性别、真实年龄、联系方式、住址、等级、
 *审核状态、头像、个性签名这些属性*/
package cn.edu.zjut.po;

import java.io.File;

public class Employee {
	private String employeeID;//账号，即学号
	private String employeePassword;//密码
	private String confirmPassword;//确认密码
	private String employeeUserName;//昵称
	private String employeeIDNum;//身份证号
	private String employeeName;//真实姓名
	private boolean employeeSex;//性别 0 or 1
	private int employeeAge;//真实年龄
	private String employeePhone;//联系方式
	private String employeeAddress;//住址
	private float employeeGrade;//等级
	private boolean employeeState;//审核状态0 or 1
	private String employeeIMG;//头像
	private String employeeSignature;//个性签名
	private String employeeFace;//证件照
	private int agreement;//阅读同意
	private String groupID;//所加入的小组的ID
	private Igroup group;//所加入的小组
	private double pool=0;//暂存在平台上的资金
	
	//以下是各属性的get和set方法
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public String getEmployeeUserName() {
		return employeeUserName;
	}
	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}
	public String getEmployeeIDNum() {
		return employeeIDNum;
	}
	public void setEmployeeIDNum(String employeeIDNum) {
		this.employeeIDNum = employeeIDNum;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public boolean isEmployeeSex() {
		return employeeSex;
	}
	public void setEmployeeSex(boolean employeeSex) {
		this.employeeSex = employeeSex;
	}
	public int getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public float getEmployeeGrade() {
		return employeeGrade;
	}
	public void setEmployeeGrade(float employeeGrade) {
		this.employeeGrade = employeeGrade;
	}
	public boolean isEmployeeState() {
		return employeeState;
	}
	public void setEmployeeState(boolean employeeState) {
		this.employeeState = employeeState;
	}
	public String getEmployeeIMG() {
		return employeeIMG;
	}
	public void setEmployeeIMG(String employeeIMG) {
		this.employeeIMG = employeeIMG;
	}
	public String getEmployeeSignature() {
		return employeeSignature;
	}
	public void setEmployeeSignature(String employeeSignature) {
		this.employeeSignature = employeeSignature;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public int getAgreement() {
		return agreement;
	}
	public void setAgreement(int agreement) {
		this.agreement = agreement;
	}
	public Igroup getGroup() {
		return group;
	}
	public void setGroup(Igroup group) {
		this.group = group;
	}
	public String getGroupID() {
		return groupID;
	}
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
	public double getPool() {
		return pool;
	}
	public void setPool(double pool) {
		this.pool = pool;
	}
	public String getEmployeeFace() {
		return employeeFace;
	}
	public void setEmployeeFace(String employeeFace) {
		this.employeeFace = employeeFace;
	}
}
