package cn.edu.zjut.action;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.po.Employee;
import cn.edu.zjut.service.IChatGroupController;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChatGroupAction extends ActionSupport{
	private Map<String, Object> session;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String receiverID;
    private String senderID;
    private IChatGroupController chatGroupController;

	@SuppressWarnings("unchecked")
	public String create(){
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		Employee sender=new Employee();
		if(session.get("employee")!=null){
			sender=(Employee)(session.get("employee"));
			senderID=sender.getEmployeeID();
			String groupID=chatGroupController.create(senderID,receiverID);
			if(groupID=="") return "failed";
			session.put("groupID", groupID);
			return "success";
		}
		return "failed";
	}
	
	public void index() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		Employee sender=new Employee();
		try{
			sender=(Employee)(session.get("employee"));
			senderID=sender.getEmployeeID();
			List groupList=chatGroupController.findAll(senderID);
			JSONArray json=JSONArray.fromObject(groupList);
			response.getWriter().write(json.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public String getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}

	public String getSenderID() {
		return senderID;
	}

	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	public IChatGroupController getChatGroupController() {
		return chatGroupController;
	}

	public void setChatGroupController(IChatGroupController chatgroupcontroller) {
		this.chatGroupController = chatgroupcontroller;
	}
}