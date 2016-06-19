package cn.edu.zjut.action;

import cn.edu.zjut.po.Igroup;

import com.opensymphony.xwork2.ActionSupport;

public class JoinGroupAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Igroup group;
	public Igroup getGroup() {
		return group;
	}
	public void setGroup(Igroup group) {
		this.group = group;
	}
	
}
