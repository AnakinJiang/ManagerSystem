/*������*/
package cn.edu.zjut.po;

public class ChatGroup {
	private String listID;  //���ݿ�ID
	private String groupID; //������ID
	private String memberID; //��ԱID
	
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
