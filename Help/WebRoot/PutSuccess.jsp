<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="cn.edu.zjut.po.Order"%>
<!DOCTYPE html>
<html>
<head>
<title>发布招募成功</title>
<script src="Merchant/js/skel.min.js"></script> <script
	src="Merchant/js/init.js"></script>

<link rel="stylesheet" href="Merchant/css/skel.css" type="text/css">
<link rel="stylesheet" href="Merchant/css/style.css" type="text/css">
<link rel="stylesheet" href="Merchant/css/style-wide.css" type="text/css">
<link rel="stylesheet" href="Merchant/css/font-awesome.min.css"
	type="text/css">

</head>
<body >
	 <div class="row">
		<div class="col-md-12">
			<h4 class="widget-title" style="font-size: 25px;font-weight: 600;">发布招募</h4>
		</div>
	</div> 
	<div>
		<div id="bg"></div>
		<div id="overlay"></div> 
		<div id="main">
			<div id="header">
				<h1>发布招募成功</h1>
				<p>
					预计还需
					<s:property value="#session.time" />
					秒，将会有人接单
				</p>
				<nav>
					<a href="MerchantPutMission.jsp" class="fa">继续发布招募</a>
				</nav>
			</div>
		</div>
	</div><br>
	<!-- 	<div class=
<div class="inputsec">
   <p>发布招募成功</p>
   <ul>
   <s:property value="#session.time"/>
   <li class="clr"><label class="db fl">&nbsp;</label><input
						type="submit" class="db fl next" value="下一步" /></li>
	</ul></div> -->
</body>
</html>