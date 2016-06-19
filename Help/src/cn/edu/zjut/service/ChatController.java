package cn.edu.zjut.service;

import java.util.List;
import cn.edu.zjut.dao.IChatDAO;
import cn.edu.zjut.po.TeamMessage;

public class ChatController implements IChatController{
	private IChatDAO chatDAO;
	public IChatDAO getChatDAO() {
		return chatDAO;
	}

	public void setChatDAO(IChatDAO chatDAO) {
		this.chatDAO = chatDAO;
	}

	@Override
	public boolean sendMessage(TeamMessage teamMessage) {
		chatDAO.sendMessage(teamMessage);
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List receiveMessage(String groupID) {
		List messageList=chatDAO.receiveMessage(groupID);
		//System.out.println(messageList.toString());
		return messageList;
	}
	
}