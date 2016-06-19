<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="cn.edu.zjut.po.Employee"%>
<!DOCTYPE html>
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>我的主页</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" href="Employee/css/normalize.css" />
<link rel="stylesheet" href="Employee/css/font-awesome.css" />
<link rel="stylesheet" href="Employee/css/bootstrap.min.css" />
<link rel="stylesheet" href="Employee/css/templatemo-style.css" />
<link rel="stylesheet" href="Employee/css/menuList.css" />
<link rel="stylesheet" href="Employee/css/chinaz.css" />
<script src="Employee/js/jquery-latest.min.js" type="text/javascript"></script>
<script src="Employee/js/chinaz.js"></script>
<script src="Employee/js/vendor/modernizr-2.6.2.min.js"></script>
<script>
	function showDiv(name) {//只显示特定block的内容
		if ("about" == name) {
			document.getElementById(name).style.display = "block";
			document.getElementById("historyMission").style.display = "none";
			document.getElementById("contact").style.display = "none";
			document.getElementById("fund").style.display = "none";
			document.getElementById("team").style.display = "none";
		}
		if ("historyMission" == name) {
			document.getElementById(name).style.display = "block";
			document.getElementById("about").style.display = "none";
			document.getElementById("contact").style.display = "none";
			document.getElementById("fund").style.display = "none";
			document.getElementById("team").style.display = "none";
		}
		if ("contact" == name) {
			document.getElementById(name).style.display = "block";
			document.getElementById("about").style.display = "none";
			document.getElementById("historyMission").style.display = "none";
			document.getElementById("fund").style.display = "none";
			document.getElementById("team").style.display = "none";
		}
		if ("fund" == name) {
			document.getElementById(name).style.display = "block";
			document.getElementById("about").style.display = "none";
			document.getElementById("historyMission").style.display = "none";
			document.getElementById("contact").style.display = "none";
			document.getElementById("team").style.display = "none";
		}
		if ("team" == name) {
			document.getElementById(name).style.display = "block";
			document.getElementById("about").style.display = "none";
			document.getElementById("historyMission").style.display = "none";
			document.getElementById("contact").style.display = "none";
			document.getElementById("fund").style.display = "none";
		}
	}

	function reinitIframe(name) {//iframe自适应高度
		var iframe = document.getElementById(name);
		try {
			var bHeight = iframe.contentWindow.document.body.scrollHeight;
			var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
			var height = Math.max(bHeight, dHeight);
			iframe.height = height;
			console.log(height);
		} catch (ex) {
			//alert(ex.message);//显示报错内容
			window.clearInterval(timer);
		}
	}
	var timer = setInterval(reinitIframe, 1000);
	
	
</script>
</head>
<body>
	<div class="responsive-header visible-xs visible-sm">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="top-section">
						<div class="profile-image">
							<img src='<s:property value="#session.employee.employeeIMG"/>'
								alt="Volton" />
							<%
								//！！用户头像的存放路径还得修改！！
							%>
						</div>
						<div class="profile-content">
							<h3 class="profile-title">
								<s:property value="#session.employee.employeeUserName" />
							</h3>
							<p style="font-family:SimHei;color:white">
								等级：
								<%
								Employee employee = (Employee) session.getAttribute("employee");
								float grade = employee.getEmployeeGrade();
								int i;
								for (i = 1; i < grade; i++) {
							%>
								<i class="fa fa-star"></i>
								<%
									}
								%>
								<%
									if (i - grade > 0.5 && i - grade < 1) {
								%>
								<i class="fa fa-star-o"></i>
								<%
									}
								%>
								<%
									if (i - grade < 0.5 && i - grade > 0) {
								%>
								<i class="fa fa-star-half-empty"></i>
								<%
									}
								%>
								<%
									if (i - grade == 0) {
								%>
								<i class="fa fa-star"></i>
								<%
									}
								%>
							</p>
							<p class="profile-description">
								<s:property value="#session.employee.employeeSignature" />
							</p>
						</div>
					</div>
				</div>
			</div>
			<a href="#" class="toggle-menu"><i class="fa fa-bars"></i></a>
			<div class="main-navigation responsive-menu">
				<ul class="navigation">
					<li><a href="#about" onclick="showDiv('about')"><i
							class="fa fa-th-large"></i>招募信息</a></li>
					<li><a href="#projects" onclick="showDiv('historyMission')"><i
							class="fa fa-history"></i>历史任务</a></li>
					<li><a href="#fund" onclick="showDiv('fund')"><i
							class="fa fa-yen"></i>我的资产</a></li>
					<li><a href="#team" onclick="showDiv('team')"><i
							class="fa fa-flag"></i>我的团队</a></li>
					<li><a href="#contact" onclick="showDiv('contact')"><i
							class="fa fa-cog"></i>个人信息</a></li>	
				</ul>
			</div>
		</div>
	</div>

	<!-- SIDEBAR -->
	<div class="sidebar-menu hidden-xs hidden-sm">
		<div class="top-section">
			<div class="profile-image">
				<img src='<s:property value="#session.employee.employeeIMG"/>'
					alt="Volton" />
				<%
					//！！用户头像的存放路径还得修改！！
				%>
			</div>
			<h3 class="profile-title">
				<s:property value="#session.employee.employeeUserName" />
			</h3>
			<p style="font-family:SimHei;color:white">
				等级：
				<%
				for (i = 1; i < grade; i++) {
			%>
				<i class="fa fa-star"></i>
				<%
					}
				%>
				<%
					if (i - grade > 0.5 && i - grade < 1) {
				%>
				<i class="fa fa-star-o"></i>
				<%
					}
				%>
				<%
					if (i - grade < 0.5 && i - grade > 0) {
				%>
				<i class="fa fa-star-half-empty"></i>
				<%
					}
				%>
				<%
					if (i - grade == 0) {
				%>
				<i class="fa fa-star"></i>
				<%
					}
				%>
			</p>
			<p class="profile-description">
				<s:property value="#session.employee.employeeSignature" />
			</p>
		</div>
		<!-- top-section -->
		<div class="main-navigation">
			<ul class="navigation">
				<li><a href="#about" onclick="showDiv('about')"><i
						class="fa fa-th-large"></i>招募信息</a></li>
				<li><a href="#projects" onclick="showDiv('historyMission')"><i
						class="fa fa-history"></i>历史任务</a></li>
				<li><a href="#fund" onclick="showDiv('fund')"><i
						class="fa fa-yen"></i>我的资产</a></li>
				<li><a href="#team" onclick="showDiv('team')"><i
						class="fa fa-flag"></i>我的团队</a></li>
				<li><a href="#contact" onclick="showDiv('contact')"><i
						class="fa fa-cog"></i>个人信息</a></li>
			</ul>
		</div>
		<!-- .main-navigation -->
		<div class="social-icons">
			<ul>
				<li><a href="#"><i class="fa fa-qq"></i></a></li>
				<li><a href="#"><i class="fa fa-wechat"></i></a></li>
			</ul>
		</div>
		<!-- .social-icons -->
	</div>
	<!-- .sidebar-menu -->

	<div class="copyrights">2016 Clouds Help项目开发小组</div>

	<!-- MAIN CONTENT -->
	<div class="main-content">
		<div class="fluid-container">
			<div class="content-wrapper">

				<!-- 招募信息 -->
				<div id="about">
					<iframe id="findMission" name="findMission" src="OrderByDefault"
						frameborder="0" scrolling="no"
						onload="reinitIframe('findMission')" width=100% height="600px"></iframe>
				</div>

				<!-- 历史订单 -->
				<div id="historyMission" style="display:none">
					<iframe id="history" name="history" src="findWeek" frameborder="0"
						scrolling="no" width=100% height="1100px"></iframe>
				</div>
				<!-- 个人信息 -->
				<div class="page-section" id="contact" style="display:none">
					<div class="row">
						<div class="col-md-12">
							<h4 class="widget-title"
								style="font-family:Microsoft JhengHei;font-size: 25px;font-weight: 600;">个人信息</h4>
						</div>
					</div>
					<div class="row">
						<form action="EmployeeUpdated" method="post" class="contact-form">
							<!-- 查看、更新个人信息 -->
							<s:hidden name="employee.employeeID"
								value="%{#session.employee.employeeID}" />
							<!-- 账号 -->
							<s:hidden name="employee.employeePassword"
								value="%{#session.employee.employeePassword}" />
							<!-- 密码 -->
							<s:hidden name="employee.employeeSex"
								value="%{#session.employee.employeeSex}" />
							<!-- 性别 -->
							<s:hidden name="employee.employeeGrade"
								value="%{#session.employee.employeeGrade}" />
							<!-- 等级 -->
							<s:hidden name="employee.employeeState"
								value="%{#session.employee.employeeState}" />
							<!-- 审核状态 -->
							<s:hidden name="employee.employeeIMG"
								value="%{#session.employee.employeeIMG}" />
							<!-- 头像 -->
							<s:property value="#request.updateTip" />
							<fieldset class="col-md-4 col-sm-6">
								<p>昵称：</p>
								<input type="text" name="employee.employeeUserName"
									value="<s:property value="#session.employee.employeeUserName"/>" />
							</fieldset>
							<fieldset class="col-md-4 col-sm-6">
								<p>真实姓名：</p>
								<input type="text" name="employee.employeeName"
									value="<s:property value="#session.employee.employeeName"/>"
									readonly />
							</fieldset>
							<fieldset class="col-md-4 col-sm-6">
								<p>身份证号：</p>
								<input type="text" name="employee.employeeIDNum"
									value="<s:property value="#session.employee.employeeIDNum"/>"
									readonly />
							</fieldset>
							<fieldset class="col-md-4 col-sm-6">
								<p>性别：</p>
								<s:if test="#session.employee.employeeSex==false">
									<input type="text" value="女" readonly />
								</s:if>
								<s:else>
									<input type="text" value="男" readonly />
								</s:else>
							</fieldset>
							<fieldset class="col-md-4 col-sm-6">
								<p>年龄：</p>
								<input type="text" name="employee.employeeAge"
									value="<s:property value="#session.employee.employeeAge"/>"
									readonly />
							</fieldset>
							<fieldset class="col-md-4 col-sm-6">
								<p>联系方式：</p>
								<input type="text" name="employee.employeePhone"
									value="<s:property value="#session.employee.employeePhone"/>" />
							</fieldset>
							<fieldset class="col-md-4 col-sm-6">
								<p>住址：</p>
								<input type="text" name="employee.employeeAddress"
									value="<s:property value="#session.employee.employeeAddress"/>" />
							</fieldset>
							<fieldset class="col-md-12 col-sm-12">
								<p>个性签名：</p>
								<textarea name="employee.employeeSignature" cols="30" rows="6"><s:property
										value="#session.employee.employeeSignature" /></textarea>
							</fieldset>
							<fieldset class="col-md-12 col-sm-12">
								<input type="submit" class="button big default" value="提交修改" />
							</fieldset>
						</form>
					</div>
					<!-- .contact-form -->
				</div>

				<!-- 我的资产 -->
				<div id="fund" style="display:none">
					<iframe id="fund" src="EmployeeFunds.jsp" height="800px"
						width="100%"></iframe>
				</div>

				
				<!-- 我的团队 -->
				<div id="team" style="display:none">
					<iframe id="team" src="findTeam" height="890px" width="100%"></iframe>
				</div>	
				
				<div class="row" id="footer">
					<hr></hr>
					<div class="col-md-12 text-center">
						<p class="copyright-text">Copyright &copy; 2016 Clouds
							Help项目开发小组</p>
					</div>
				</div>


			</div>
		</div>
	</div>

	<script src="Employee/js/vendor/jquery-1.10.2.min.js"></script>
	<script src="Employee/js/min/plugins.min.js"></script>
	<script src="Employee/js/min/main.min.js"></script>

</body>
</html>