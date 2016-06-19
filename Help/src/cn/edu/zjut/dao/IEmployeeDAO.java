/*IEmployeeDAO:�ܹ���DAO�ӿ���*/
package cn.edu.zjut.dao;
import java.util.List;

import cn.edu.zjut.po.Employee;

public interface IEmployeeDAO {
	boolean register(Employee employee);//�ܹ���ע��
	boolean login(Employee employee);//�ܹ��ߵ�¼
	boolean update(Employee employee);//�ܹ�����Ϣ����
	boolean findByIDNum(Employee employee);//��֤���֤��
	public List findByHQL(String hql);//����HQL����ѯ
	public List findTeams();//��ѯС�鼰���Ա
	public boolean updateIgroupID();//��������С��
	public boolean exitTeam();
	public boolean changeSate(String ID);
}
