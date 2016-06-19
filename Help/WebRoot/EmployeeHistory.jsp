<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="cn.edu.zjut.po.Employee"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%	int curPage = 1;
	int pageCount=1;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
        <meta charset="utf-8"/>
        <title>招募信息</title>
        <meta name="description" content=""/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        
        <link rel="stylesheet" href="Employee/css/normalize.css"/>
        <link rel="stylesheet" href="Employee/css/font-awesome.css"/>
        <link rel="stylesheet" href="Employee/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="Employee/css/templatemo-style.css"/>
        <link rel="stylesheet" href="Employee/css/menuList.css"/>
        <link rel="stylesheet" href="Employee/css/chinaz.css"/>
  		<script src="Employee/js/jquery-latest.min.js" type="text/javascript"></script>
		<script src="Employee/js/chinaz.js"></script>
        <script src="Employee/js/vendor/modernizr-2.6.2.min.js"></script>
</head>
<body>
<div class="page-section" id="about" >
	<div class="row">
		<div class="col-md-12">
			<h4 class="widget-title" style="font-size: 25px;font-weight: 600;">历史任务</h4>
		</div>
	</div>
	<div id='cssmenu'>
	<ul>
		<li><a href='findWeek'>近一周的任务</a></li>
		<li><a href='findMonth'>近三十天的任务</a></li>
		<li><a href='findAll'>历史全部任务</a></li>
	</ul>
	</div>		
	<div class="row projects-holder">
	<%
	List list = (List) session.getAttribute("orderHistory");
	int size = list.size();
	if (list != null && size!=0) {
		try{
			//List list = (List) session.getAttribute("orderHistory");
			//int size = list.size();
			System.out.println("list.size="+size);
			System.out.println(list.get(0));
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
		do{
			if(count>=PAGESIZE)break;
			Object[] object = (Object[])list.get(start);
			System.out.println(object[0]);
			System.out.println(object[1]);
			System.out.println(object[2]);
			System.out.println(object[3]);
			System.out.println(object[4]);
			System.out.println(object[5]);
			start++;
			count++;			
	%>
	<%if(size!=0){%>
	<div class="col-md-4 col-sm-6">
		<div class="project-item">
			<img src="Employee/img/6.jpg" alt="" />
			<div class="project-hover">
				<div class="inside">
					<p>店名：<%=object[0]%></p>
					<p>地址：<%=object[1]%></p>
					<p>工作开始时间：<%=object[2]%></p>
					<p>工作截止时间（最晚）：<%=object[3]%></p>
					<p>工作报酬：<%=object[4]%></p>
					<p>联系方式：<%=object[5]%></p>
				</div>
			</div>
		</div>
	</div>
	<%} %>
	<%  
        }while(start<list.size());    
    }
    catch(Exception e){e.printStackTrace();}  
    }
	%>
	</div>
</div>
<div class="dividePage">
	<a href="EmployeeHistory.jsp?curPage=1">首页</a>
	<a href="EmployeeHistory.jsp?curPage=<%=curPage-1%>">上一页</a>
	<a href="EmployeeHistory.jsp?curPage=<%=curPage+1%>">下一页</a>
	<a href="EmployeeHistory.jsp?curPage=<%=pageCount%>">尾页</a> 
				第<%=curPage%>页/共<%=pageCount%>页
</div>
<script src="Employee/js/jquery.min.js"></script>
</body>
</html>