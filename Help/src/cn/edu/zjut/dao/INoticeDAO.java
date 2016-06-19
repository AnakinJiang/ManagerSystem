package cn.edu.zjut.dao;

import java.util.List;

import org.hibernate.Session;

import cn.edu.zjut.po.Notice;

public interface INoticeDAO {

	void save(Notice transientInstance);
	void delete(Notice transientInstance);
	List findByHql(String hql);
	void update(Notice stu);
	public Session getSession();
}
