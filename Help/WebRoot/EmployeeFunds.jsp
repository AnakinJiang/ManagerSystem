  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
  <head>
        <meta charset="utf-8">
        <title>我的资产</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="Employee/css/normalize.css">
        <link rel="stylesheet" href="Employee/css/font-awesome.css">
        <link rel="stylesheet" href="Employee/css/bootstrap.min.css">
        <link rel="stylesheet" href="Employee/css/templatemo-style.css">
        <link rel="stylesheet" href="Employee/css/menuList.css">
        <link rel="stylesheet" href="Employee/css/chinaz.css">
        <link rel="stylesheet" href="Employee/css/lineStyle.css" media="screen" type="text/css" /><!-- draw charts -->
  		<script src="Employee/js/jquery-latest.min.js" type="text/javascript"></script>
		<script src="Employee/js/chinaz.js"></script>
		<script>
		$(function(){
			<%if(session.getAttribute("salarySum")==null){%>
				window.location.href='calculateMyFunds';
			<%}%>
    	})
    	
  		function showDiv(name){//只显示特定block的内容
      		if("eye"==name){
    			document.getElementById(name).style.display="none";
    			document.getElementById("eye-slash").style.display="inline";
   			}
   			if("eye-slash"==name){
   				document.getElementById(name).style.display="none";
    			document.getElementById("eye").style.display="inline";
   			}
  		}
  		</script>
</head>
<body>
<s:iterator value="#session.salaryList" id="Object" status="i">
	<input type="text" id="<s:property value="#i.index"/>" value='<s:property value="#Object[0].toString()"/>' style="display:none">
	<input type="text" id="<s:property value="#i.(index+10)"/>" value='<s:property value="#Object[1].toString()"/>' style="display:none">
</s:iterator>
<div class="page-section" id="about">
	<div class="row">
		<div class="col-md-12">
			<h4 class="widget-title" style="font-size: 25px;font-weight: 600;margin-bottom:30px">我的资产</h4>
		</div>
	</div>
	<!-- 显示or隐藏 收入 -->
	<div id="eye">
		<ul>
		<li style="font-family:Microsoft JhengHei;font-size: 20px;font-weight: 500;">
		总收入：<s:property value="#session.salarySum"/><a  href="#" onclick="showDiv('eye')"><i class="fa fa-eye" style="color:#6c6c6c;margin-left:12px"></i></a>
		</li>
		</ul>
	</div>
	<div id="eye-slash" style="display:none;">
		<ul>
		<li style="font-family:Microsoft JhengHei;font-size: 20px;font-weight: 500">
		总收入：*******<a href="#" onclick="showDiv('eye-slash')"><i class="fa fa-eye-slash" style="color:#6c6c6c;margin-left:12px"></i></a>
		</li>
		</ul>
	</div>
	<div id='cssmenu' style="margin-top:15px">
	<ul>
		<li><a href="calculateMyFunds"><i class="fa fa-hand-o-right" style="margin-right:10px"></i>生成近10天的收入趋势图</a></li>
	</ul>
	</div>
	
</div>
<!-- My Funds Chart -->
<div class="charts--container">
	<div id="lineChart">
		<svg id="lineChartSVG" class="lineChart--svg"></svg>
	</div>
</div>
<script src='Employee/js/d3.v3.min.js'></script>
<script src="Employee/js/lineStyle.js"></script>
</body>
</html>