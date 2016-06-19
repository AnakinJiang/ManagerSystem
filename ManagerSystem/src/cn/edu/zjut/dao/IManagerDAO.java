package cn.edu.zjut.dao;

import java.util.List;

import cn.edu.zjut.po.Employee;
import cn.edu.zjut.po.Merchant;

public interface IManagerDAO {
	
	List findByHql(String hql);
	List findByHqlTop(String hql);
	List findByHqlButtom(String hql);
	boolean deleteEmployee(String employeeId);
	boolean deleteMerchant(String merchantId);
	boolean updateEmployee(Employee employee);
	boolean updateMerchant(Merchant merchant);
	List<Merchant> findAllMerchant();
	List<Employee> findAllEmployee();
	List<Merchant> findUncheckedMerchant();
	List<Employee> findUncheckedEmployee();
	boolean findManger(String managerId);
	Merchant findMerchant(String merchantId);
	Employee findEmployee(String employeeId);
	boolean checkMerchant(String merchantId);
	boolean checkEmployee(String employeeId);
	boolean uncheckMerchant(String merchantId);
	boolean uncheckEmployee(String employeeId);
}
