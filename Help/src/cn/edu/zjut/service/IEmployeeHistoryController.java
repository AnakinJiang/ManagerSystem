//受雇者历史任务查询接口类
package cn.edu.zjut.service;
import java.util.List;
import cn.edu.zjut.po.Employee;

public interface IEmployeeHistoryController {
	List displayALL(Employee employee);	//显示全部历史
	List displayWeek(Employee employee);	//显示最近一周已完成的任务信息
	List displayMonth(Employee employee);	//显示最近一个月已完成的任务信息
}
