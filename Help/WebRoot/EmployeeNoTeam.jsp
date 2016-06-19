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
        <title></title>
        <meta name="description" content=""/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <link rel="stylesheet" href="commonCSS/bootstrap.css" type="text/css" />
		<link rel="stylesheet" href="commonCSS/app.css" type="text/css" />  
        <link rel="stylesheet" href="Employee/css/normalize.css"/>
        <link rel="stylesheet" href="Employee/css/font-awesome.css"/>
        <link rel="stylesheet" href="Employee/css/templatemo-style.css"/>
        <link rel="stylesheet" href="Employee/css/menuList.css"/>
        <link rel="stylesheet" href="Employee/css/chinaz.css"/>
</head>
<body class="">
<div class="page-section" id="about" >
	<div class="row">
		<div class="col-md-12">
			<h4 class="widget-title" style="font-size: 25px;font-weight: 600;margin-bottom:30px">我的团队</h4>
		</div>
	</div>
	<div id="no-team" style="font-family: Microsoft JhengHei;font-size:15px">
		<p >您当前没有队伍，您可以选择<a href="EmployeeCreateTeam.jsp"><font color="red">创建队伍</font></a>or
			<a href="SearchGroup.jsp"><font color="blue">加入其他队伍</font></a>
		</p>
		<p><a class="fa fa-star" style="color:#f46151;margin-top:50px;">&nbsp;&nbsp;请先仔细阅读以下内容</a></p>
	</div>

</div>
<div style="margin-top:10px;">
	<iframe id="content" src="TeamShouldKnow.jsp" height="340px" width="100%"></iframe>
</div>




<script src="Employee/js/jquery.min.js"></script>
</body>
</html>