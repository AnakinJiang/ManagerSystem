<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="cn.edu.zjut.po.Merchant"%>
<%@ page import="cn.edu.zjut.po.Order"%>

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
	<div class="page-section" id="about">
		<div class="row">
			<div class="col-md-12">
				<h4 class="widget-title" style="font-size: 25px;font-weight: 600;">发布历史</h4>
			</div>
		</div>
		<div id='cssmenu'>
			<ul>
				<li><a href='findFinishedOrder' name="pform">已完成的招募</a></li>
				<li><a href='findUnfinishedOrder'>未完成的招募</a></li>
			</ul>
		</div>
      <p>不好意思，您没有</p><s:property value="#session.tip" />
      <p>请重新查看是否</p>
      <% 
      System.out.println(1);
       %>
	</div>
</body>
</html>