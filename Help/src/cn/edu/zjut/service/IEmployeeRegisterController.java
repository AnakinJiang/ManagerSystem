//�ܹ���ע��ӿ���
package cn.edu.zjut.service;

import java.io.File;

import cn.edu.zjut.po.Employee;

public interface IEmployeeRegisterController {
	public boolean register(Employee employee);//ע��
	public boolean registerUpdate(Employee employee);//��Ϣ����
	public boolean update(Employee employee);
	public boolean uploadface(File photo,String employeeID);
	public boolean check(String employeeID);
}
