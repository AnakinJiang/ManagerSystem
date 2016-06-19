<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>管理员登录页面</title>
</head>

<body>

		<form  action="managerLogin" method="post">
			<input type="text"  name="manager.managerId">
			<input type="password"   name="manager.managerPassword">
			<input type="submit" value="登录" >
	    </form>
</body>
</html>