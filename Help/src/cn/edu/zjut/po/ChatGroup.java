/*聊天组*/
package cn.edu.zjut.po;

public class ChatGroup {
	private String listID;  //数据库ID
	private String groupID; //聊天组ID
	private String memberID; //成员ID
	
	public ChatGroup(String senderID,String receiverID){
		this.groupID=senderID+receiverID;
		this.memberID=senderID;
	}
	public String getListID() {
		return listID;
	}
	public void setListID(String listID) {
		this.listID = listID;
	}
	public String getGroupID() {
		return groupID;
	}
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
}
