package cn.edu.zjut.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.INoticeDAO;
import cn.edu.zjut.po.Notice;

public class NoticeController implements INoticeController{

	private INoticeDAO noticeDAO = null;
	private Map<String, Object> request, session;

	public NoticeController() {
		System.out.println("create NoticeService.");
	}

	public void insert(Notice transientInstance) {
		
		System.out.println("execute --insert()-- method.");
		
		noticeDAO.save(transientInstance);
		
	}
	
    public void delete(Notice transientInstance) {
		
		System.out.println("execute --delete()-- method.");
		
		noticeDAO.delete(transientInstance);
		
	}
	
	public void find() {
		System.out.println("execute --find()-- method.");
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		//1.5小时，总算出来啦
        String hql = "from Notice order by number asc";
		
        request.put("not", noticeDAO.findByHql(hql));
	}

	public INoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

	public void setNoticeDAO(INoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
}
