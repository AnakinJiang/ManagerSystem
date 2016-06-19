package cn.edu.zjut.dao;

import java.util.List;

import cn.edu.zjut.po.ChatGroup;

public interface IChatGroupDAO {

	boolean create(ChatGroup chatgroup);
	List findbyHql(String hql);

}
