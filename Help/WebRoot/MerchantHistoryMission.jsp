<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="cn.edu.zjut.po.Merchant"%>
<%@ page import="cn.edu.zjut.po.Order"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%
int curPage = 1;
int pageCount=1;
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>历史发布</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" href="Merchant/css/normalize.css" />
<link rel="stylesheet" href="Merchant/css/font-awesome.css" />
<link rel="stylesheet" href="Merchant/css/bootstrap.min.css" />
<link rel="stylesheet" href="Merchant/css/templatemo-style.css" />
<link rel="stylesheet" href="Merchant/css/menuList.css" />
<link rel="stylesheet" href="Merchant/css/chinaz.css" />
<script src="Merchant/js/jquery-latest.min.js" type="text/javascript"></script>
<script src="Merchant/js/chinaz.js"></script>
<script src="Merchant/js/vendor/modernizrEmployeein.js"></script>
</head>
<body>
	
		<div class="row">
			<div class="col-md-12">
				<h4 class="widget-title" style="font-size: 25px;font-weight: 600;">发布历史</h4>
			</div>
		</div>
		<div id='cssmenu'>
			<ul>
				<li><a href='findFinishedOrder'>已完成的招募</a></li>
				<li><a href='findUnfinishedOrder'>未完成的招募</a></li>
			</ul>
		</div>

		<div class="row projects-holder">
			<%
				if (session.getAttribute("list") != null) {
				try{
					List list1 = (List) session.getAttribute("list");
					int size = list1.size();
					int PAGESIZE = 9;
					
					pageCount = (size%PAGESIZE==0)?(size/PAGESIZE):(size/PAGESIZE+1);
		          String tmp = request.getParameter("curPage");
		if(tmp==null){
			tmp="1";
		}
		curPage = Integer.parseInt(tmp);
		if(curPage>=pageCount) curPage = pageCount;
		if(curPage<=0) curPage =1;
	
		int start=(curPage-1)*PAGESIZE;
		
		int count = 0;
		if(start>=0)
		{
		while(start<list1.size())
		{
			if(count>=PAGESIZE)break;
			Order order = (Order)list1.get(start);
			String orderID=order.getOrderID();
			Date releaseTime=order.getReleaseTime();
			Date acceptTime=order.getAcceptTime();
			double salary=order.getSalary();
			String remark=order.getRemark();
			Date startTime=order.getStartTime();
			Date endTime=order.getEndTime();
			boolean ifFinish=order.isIfFinish();
			start++;	
			count++;
			%>
			<div class="col-md-4 col-sm-6">
				<div class="project-item">
					<img src="Merchant/img/1.jpg" alt="" />
					<div class="project-hover">
						<div class="inside">
							<p>
								订单序列号：
								<%=orderID%>
							</p>
							<p>
								订单发布时间：
								<%=releaseTime%>
							</p>
							<p>
								订单接收时间：
								<%=acceptTime%>
							</p>
							<p>
								订单报酬：
								<%=salary%>
							</p>
							<p>
								订单备注：
								<%=remark%>
							</p>
							<p>
								任务开始时间：
								<%=startTime%>
							</p>
							<p>
								任务结束时间：
								<%=endTime%>
							</p>
							<p>
								是否完成：
								<%=ifFinish%>
							</p>
						</div>
					</div>
				</div>
			</div>
			<%  
        }  
        }
    }  
    catch(Exception e){  
    e.printStackTrace();
          
    }  
    }
%>


		</div>
<div class="dividePage">

			<a href="MerchantHistoryMission.jsp?curPage=1">首页</a> <a
				href="MerchantHistoryMission.jsp?curPage=<%=curPage-1%>">上一页</a> <a
				href="MerchantHistoryMission.jsp?curPage=<%=curPage+1%>">下一页</a> <a
				href="MerchantHistoryMission.jsp?curPage=<%=pageCount%>">尾页</a> 
				第<%=curPage%>页/共<%=pageCount%>页
</div>
</body>
</html>