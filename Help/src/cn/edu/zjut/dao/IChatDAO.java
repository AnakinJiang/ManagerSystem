package cn.edu.zjut.dao;

import java.util.List;

import cn.edu.zjut.po.TeamMessage;

public interface IChatDAO {
	public boolean sendMessage(TeamMessage teamMessage);
	@SuppressWarnings("rawtypes")
	public List receiveMessage(String groupID);
}
