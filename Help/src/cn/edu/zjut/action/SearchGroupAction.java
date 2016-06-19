package cn.edu.zjut.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.po.Igroup;
import cn.edu.zjut.service.ISearchGroupController;

public class SearchGroupAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session,request;
	private Igroup group;
	private ISearchGroupController searchGroupController;
	public Igroup getGroup() {
		return group;
	}
	public void setGroup(Igroup group) {
		this.group = group;
	}
	public ISearchGroupController getSearchGroupController() {
		return searchGroupController;
	}
	public void setSearchGroupController(ISearchGroupController searchGroupController) {
		this.searchGroupController = searchGroupController;
	}
	
	public String search(){
		System.out.println("execute--search--actionmethod");
		if(searchGroupController.search(group)){
			return "searchsuccess";
		}
		else{
			return "searchfailed";
		}
	}
	
	public String join(){
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		if(searchGroupController.join(group)){
			request.put("jointip", "成功加入小组！");
			return "joinsuccess";
		}
		else{
			request.put("jointip", "加入小组失败！");
			return "joinfailed";
		}
	}
	
}
