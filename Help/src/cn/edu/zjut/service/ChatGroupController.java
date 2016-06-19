package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.dao.IChatGroupDAO;
import cn.edu.zjut.po.ChatGroup;

public class ChatGroupController implements IChatGroupController{
	private IChatGroupDAO chatGroupDAO;
	@Override
	public String create(String senderID, String receiverID) {
		ChatGroup sr=new ChatGroup(senderID,receiverID);
		String hql1="from ChatGroup as g where groupID='"+senderID+receiverID+"'";
		String hql2="from ChatGroup as g where groupID='"+receiverID+senderID+"'";
		List list1=chatGroupDAO.findbyHql(hql1);
		List list2=chatGroupDAO.findbyHql(hql2);
		if(list1.size()==1) return senderID+receiverID;
		else if(list2.size()==1) return receiverID+senderID;
		else {
		    if(chatGroupDAO.create(sr))
			    return senderID+receiverID;
		}
		return "";
	}
	@Override
	public List findAll(String senderID) {
		String hql="from ChatGroup as c where c.memberID='"+senderID+"'";
		return chatGroupDAO.findbyHql(hql);
	}
	public IChatGroupDAO getChatGroupDAO() {
		return chatGroupDAO;
	}
	public void setChatGroupDAO(IChatGroupDAO chatGroupDAO) {
		this.chatGroupDAO = chatGroupDAO;
	}

}
