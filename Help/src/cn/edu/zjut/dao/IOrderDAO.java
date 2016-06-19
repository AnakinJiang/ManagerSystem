/*订单DAO接口类，定义类接受订单，查询订单，更新订单等方法*/
package cn.edu.zjut.dao;
import java.util.List;

import cn.edu.zjut.po.Employee;
import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.po.Order;

public interface IOrderDAO {
	boolean accept(Order order, Employee employee,String releaseTime);
	@SuppressWarnings("rawtypes")
	List findByHql(String hql);
	boolean update(Order order);
	boolean merge(Order order);
	boolean save(Order order);
	List findALL();
    List findUnfinished(Merchant merchant);//查询未完成的任务
    List findFinished(Merchant merchant);//查询已完成的任务
    long findtwoOrder();
    List findPayed(Merchant merchant);//查询已付款的招募  
    List findUnpayed(Merchant merchant);//查询未付款的招募  
}
