<!-- 注册主页面，用框架包含注册子页面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta charset="utf-8">
<title>注册页面</title>
<link rel="stylesheet" href="Employee/css/EmployeeRegisterStyle1.css"  type="text/css">
<script type="text/javascript">
document.createElement("section");
document.createElement("article");
document.createElement("footer");
document.createElement("header");
document.createElement("hgroup");
document.createElement("nav");
document.createElement("menu");
</script>
</head>
<body>
<header>
	<div class="w12 header">
	<a class="db logo fl"><!-- <img src="Employee/img/logo.jpg" width="327" height="94"  alt=""/> --></a>
	<div class="fr logofr"><a href="index.jsp">返回首页</a> |<a>客服中心</a><br>
	 如注册遇到问题请拨打：<strong style="font-size:14px;">123456</strong></div>
	</div>
</header>
<div class="head_border"></div>
<section class="w12 login">
<em class="fr">已经是会员，请&nbsp;&nbsp;<a class="db logbtn fr" href="EmployeeLogin.jsp">前往登录</a> </em>
</section>
<section class="main w12">
	<div class="title"><a class="title1 db fl">受雇者</a><a class="title2 db fl">商家</a></div>
	<div class="fr tit2"><span class="arr"></span></div>
	<div><iframe id="content" src="EmployeeRegisterBasic.jsp" height="840px" width="100%" frameborder="0"  ></iframe></div>
</section>
</body>
</html>