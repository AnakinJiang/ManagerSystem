/*IEmployee.java
 *�ӿ��࣬����login��register�ĳ��󷽷�*/
package cn.edu.zjut.service;
import java.io.File;

import cn.edu.zjut.po.Employee;

public interface IEmployeeLoginController {
	boolean login(Employee employee);//�ܹ��ߵ�¼
	boolean face(File face);
}
