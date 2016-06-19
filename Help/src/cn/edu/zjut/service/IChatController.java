package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.po.TeamMessage;

public interface IChatController {
    public boolean sendMessage(TeamMessage teamMessage);
    @SuppressWarnings("rawtypes")
	public List receiveMessage(String groupID);
}
