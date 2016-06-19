package cn.edu.zjut.action;
import java.io.*;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.service.IChatController;

import com.opensymphony.xwork2.ActionSupport;

public class ReceiveAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private IChatController chatController=null;
	@SuppressWarnings("rawtypes")
	private List messageList;
	private int teamID;
	private String groupID;
	
	public void index() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		//System.out.println("receiving stage1...");
		try{
			messageList=chatController.receiveMessage(groupID);
			JSONArray json=JSONArray.fromObject(messageList);
			//System.out.println("receiving stage2...");
			response.getWriter().write(json.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public IChatController getChatController() {
		return chatController;
	}
	public void setChatController(IChatController chatController) {
		this.chatController = chatController;
	}

	@SuppressWarnings("rawtypes")
	public List getMessageList() {
		return messageList;
	}

	@SuppressWarnings("rawtypes")
	public void setMessageList(List messageList) {
		this.messageList = messageList;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
}
