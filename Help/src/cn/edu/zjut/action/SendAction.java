package cn.edu.zjut.action;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import cn.edu.zjut.po.Employee;
import cn.edu.zjut.po.TeamMessage;
import cn.edu.zjut.service.IChatController;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SendAction extends ActionSupport{
	private Map<String, Object> session;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private IChatController chatController=null;
	private String content;
	private TeamMessage teamMessage;
	private String groupID;

	public void index(){
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		teamMessage=new TeamMessage();
		
		try {
			content = java.net.URLDecoder.decode(content,"UTF-8");
			System.out.println("content="+content);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		teamMessage.setMessageContent(content);
		Date date=new Date();
		teamMessage.setMessageTime(date);
		String sender=((Employee)session.get("employee")).getEmployeeUserName();
		String senderIMG = ((Employee)session.get("employee")).getEmployeeIMG();
		teamMessage.setMessageSender(sender);
		teamMessage.setSenderIMG(senderIMG);
		System.out.println("senderIMG="+senderIMG);
		teamMessage.setChatTeamID(groupID);
		try{
			chatController.sendMessage(teamMessage);
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

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public TeamMessage getTeamMessage() {
		return teamMessage;
	}
	public void setTeamMessage(TeamMessage teamMessage) {
		this.teamMessage = teamMessage;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupid) {
		groupID = groupid;
	}
}
