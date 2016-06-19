/*Employee.java
 *����ܹ��ߵĸ�����Ϣ�������˺š����롢�ǳơ����֤�š� /
 *��ʵ�������Ա���ʵ���䡢��ϵ��ʽ��סַ���ȼ���
 *���״̬��ͷ�񡢸���ǩ����Щ����*/
package cn.edu.zjut.po;

import java.io.File;

public class Employee {
	private String employeeID;//�˺ţ���ѧ��
	private String employeePassword;//����
	private String confirmPassword;//ȷ������
	private String employeeUserName;//�ǳ�
	private String employeeIDNum;//���֤��
	private String employeeName;//��ʵ����
	private boolean employeeSex;//�Ա� 0 or 1
	private int employeeAge;//��ʵ����
	private String employeePhone;//��ϵ��ʽ
	private String employeeAddress;//סַ
	private float employeeGrade;//�ȼ�
	private boolean employeeState;//���״̬0 or 1
	private String employeeIMG;//ͷ��
	private String employeeSignature;//����ǩ��
	private String employeeFace;//֤����
	private int agreement;//�Ķ�ͬ��
	private String groupID;//�������С���ID
	private Igroup group;//�������С��
	private double pool=0;//�ݴ���ƽ̨�ϵ��ʽ�
	
	//�����Ǹ����Ե�get��set����
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
