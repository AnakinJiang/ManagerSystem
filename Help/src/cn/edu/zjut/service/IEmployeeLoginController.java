/*IEmployee.java
 *接口类，含有login、register的抽象方法*/
package cn.edu.zjut.service;
import java.io.File;

import cn.edu.zjut.po.Employee;

public interface IEmployeeLoginController {
	boolean login(Employee employee);//受雇者登录
	boolean face(File face);
}
