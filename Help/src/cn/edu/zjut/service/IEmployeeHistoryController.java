//�ܹ�����ʷ�����ѯ�ӿ���
package cn.edu.zjut.service;
import java.util.List;
import cn.edu.zjut.po.Employee;

public interface IEmployeeHistoryController {
	List displayALL(Employee employee);	//��ʾȫ����ʷ
	List displayWeek(Employee employee);	//��ʾ���һ������ɵ�������Ϣ
	List displayMonth(Employee employee);	//��ʾ���һ��������ɵ�������Ϣ
}
