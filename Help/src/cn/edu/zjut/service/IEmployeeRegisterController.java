//受雇者注册接口类
package cn.edu.zjut.service;

import java.io.File;

import cn.edu.zjut.po.Employee;

public interface IEmployeeRegisterController {
	public boolean register(Employee employee);//注册
	public boolean registerUpdate(Employee employee);//信息更新
	public boolean update(Employee employee);
	public boolean uploadface(File photo,String employeeID);
	public boolean check(String employeeID);
}
