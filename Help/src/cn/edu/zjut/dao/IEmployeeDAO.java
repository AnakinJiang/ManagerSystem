/*IEmployeeDAO:受雇者DAO接口类*/
package cn.edu.zjut.dao;
import java.util.List;

import cn.edu.zjut.po.Employee;

public interface IEmployeeDAO {
	boolean register(Employee employee);//受雇者注册
	boolean login(Employee employee);//受雇者登录
	boolean update(Employee employee);//受雇者信息更新
	boolean findByIDNum(Employee employee);//验证身份证号
	public List findByHQL(String hql);//根据HQL语句查询
	public List findTeams();//查询小组及其成员
	public boolean updateIgroupID();//更新所属小组
	public boolean exitTeam();
	public boolean changeSate(String ID);
}
