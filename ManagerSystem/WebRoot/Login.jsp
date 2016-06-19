<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<head>
<meta charset="utf-8" />
<title>管理员登录</title>
<link rel="icon" href="guidePage/img/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="guidePage/css/differentbootstrap/site.css">
<link rel="stylesheet"
	href="guidePage/css/differentbootstrap/bootstrap.min.css">
</head>

<body style="background-image:url(images/m4.jpg);background-size: cover;">


	<div class="container body-content">
		<div class="row">
			<div class="col-md-6 col-md-offset-3 well">
				<form action="managerLogin" method="post" class="form-horizontal">
					<fieldset>
						<legend>管理员登录</legend>
						<div class="form-group">
							<label for="account" class="col-lg-2 control-label">ID</label>
							<div class="col-lg-10">
								<input type="text" class="form-control" id="account" name="manager.managerId"
									placeholder="输入ID" required>
							</div>
							<label for="account" class="col-lg-2 control-label">PASSWORD</label>
							<div class="col-lg-10">
								<input type="password" class="form-control" id="account" name="manager.managerPassword"
									placeholder="输入密码" required>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-10 col-lg-offset-2">
								<button type="submit" class="btn btn-primary">登录</button>
								&nbsp;&nbsp;&nbsp;&nbsp;点此<a href="#">注册</a>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
			<div class="col-xs-12 text-center"></div>
		</div>
	</div>
    <br/>
    <br/>
    <br/>
	<div id="footerDiv" class="container">
		<hr />
		<footer>
			<div class="text-left col-xs-12">
				<p>Copyright &copy; 2016 Clouds Help项目开发小组</p>
				<br>
			</div>
		</footer>
	</div>


</body>