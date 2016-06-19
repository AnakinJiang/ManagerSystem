package cn.edu.zjut.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.po.Notice;
import cn.edu.zjut.service.INoticeController;

public class NoticeAction extends ActionSupport{

	private Notice notice;
	private INoticeController noticeService = null;
	private Map<String, Object> request;
	// servlet API
	private HttpServletRequest request1 = ServletActionContext.getRequest();
	
	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public INoticeController getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(INoticeController noticeService) {
		this.noticeService = noticeService;
	}

	public String find(){
		ActionContext ctx= ActionContext.getContext();
		request=(Map) ctx.get("request");
		noticeService.find();
		System.out.println("find end");
		//这个居然这么难
		request.put("note", request.get("not"));//request接力,不知道怎么滴,service的request拿不到值
		//下面这个方法暂时不要
		//request1.setAttribute("note", request.get("not"));
		return "success";
	}
	
	public String insert() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println("Notice: " + notice.getContent());
		String endTime = df.format(date);  
		try {
			Date date2 =df.parse(endTime);
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(date2);
			int endTimeyear = cal2.get(Calendar.YEAR);//获取年;
			int endTimemouth = cal2.get(Calendar.MONTH)+1;//获取月;
			int endTimeday = cal2.get(Calendar.DATE);//获取日;
			notice.setYearr(endTimeyear);
			notice.setMonthh(endTimemouth);
			notice.setDatee(endTimeday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		noticeService.insert(notice);
		return "success";
	}
	
	public String delete() {
		System.out.println("-----deleteAction-----");
		noticeService.delete(notice);
		return "success";
		
	}
}
