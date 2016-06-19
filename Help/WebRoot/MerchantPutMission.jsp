<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="cn.edu.zjut.po.Merchant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>招募信息</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="Merchant/css/normalize.css">
<link rel="stylesheet" href="Merchant/css/font-awesome.css">
<link rel="stylesheet" href="Merchant/css/bootstrap.min.css">
<link rel="stylesheet" href="Merchant/css/templatemo-style.css">
<link rel="stylesheet" href="Merchant/css/menuList.css">
<link rel="stylesheet" href="Merchant/css/chinaz.css">
<script type="text/javascript" src="Merchant/js/jquery.js"></script>
<script src="Merchant/js/jquery-latest.min.js" type="text/javascript"></script>
<script src="Merchant/js/chinaz.js"></script>
<script src="Merchant/js/vendor/modernizr-2.6.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="Merchant/css/default1.css" />
<link rel="stylesheet" type="text/css" href="Merchant/css/component1.css" />
<script src="Merchant/js/modernizr.custom.js"></script>
<script type="text/javascript">
function check(){
 var name=document.getElementById("merchant.merchantState").value;

  if(name=="false")
  {
  document.getElementById("clickMe").click(); 
   return false;
   }

}
</script>
</head>
<body>
	<div class="md-modal md-effect-17" id="modal-17">
			<div class="md-content">
				<h3>友情提示</h3>
				<div>
					<p>很遗憾，您的账号还未通过审核，不能发布招募</p>
					<button class="md-close">关闭!</button>
				</div>
			</div>
		</div>
	<div class="row">
		<div class="col-md-12">
			<h4 class="widget-title" style="font-size: 25px;font-weight: 600;">发布招募</h4>
		</div>
	</div>
	<div class="row">
		<form action="merchantReleaseOrder" method="post" name="form1"
			id="form1" class="contact-form" onclick="return check()">
			<!-- 查看、更新个人信息 -->
			<s:hidden name="merchant.merchantID"
				value="%{#session.merchant.merchantID}" />
	
			<!-- 账号 -->
			<s:hidden name="merchant.merchantPassword"
				value="%{#session.merchant.merchantPassword}" />
			<!-- 密码 -->
			<s:hidden name="merchant.merchantSex"
				value="%{#session.merchant.merchantSex}" />
			<!-- 性别 -->
			<s:hidden name="merchant.merchantGrade"
				value="%{#session.merchant.merchantGrade}" />
			<!-- 等级 -->
			<s:hidden name="merchant.merchantState" id="merchant.merchantState"
				value="%{#session.merchant.merchantState}" />
			<!-- 审核状态 -->
			<s:hidden name="merchant.merchantIMG"
				value="%{#session.merchant.merchantIMG}" />
			<!-- 头像 -->
			<s:property value="#request.updateTip" />
			<fieldset class="col-md-4 col-sm-6" style="display:none">
				<p>我的昵称：</p>
				<input type="text" name="merchant.merchantUsername"
					value="<s:property value="#session.merchant.merchantUsername"/>"
					readonly />
			</fieldset>
			<fieldset class="col-md-4 col-sm-6">
				<p>店面地址：</p>
				<input type="text" name="merchant.shopAddress"
					value="<s:property value="#session.merchant.shopAddress"/>"
					readonly />
			</fieldset>
			
			<fieldset class="col-md-4 col-sm-6" style="display:none">
				<p>用户名：</p>
				<input type="text" name="merchant.merchantID"
					value="<s:property value="#session.merchant.merchantID"/>" readonly />
			</fieldset>
			
			<fieldset class="col-md-4 col-sm-6">
				<p>酬金：</p>
				<input type="text" name="order.trueSalary" value=0 style="display:none">
				<input type="text" name="order.salary" >
				<s:property value="#session.order.salary" />
			</fieldset>
			
			<fieldset class="col-md-4 col-sm-6">
				<p>任务开始时间：</p>
				<input type="datetime-local" name="startTimeString">
				<s:property value="#session.startTimeString" />
			</fieldset>
			
			<fieldset class="col-md-4 col-sm-6">
				<p>任务结束时间：</p>
				<input type="datetime-local" name="endTimeString">
				<s:property value="#session.endTimeString" />
			</fieldset>
			
			<fieldset class="col-md-4 col-sm-6">
				<p>招募人数：</p>
				<input type="text" name="number">
				<s:property value="#session.number" />
			</fieldset>
			<div class="tip"><s:fielderror/></div>
			<fieldset class="col-md-12 col-sm-12">
				<p>备注：</p>
				<textarea name="order.remark" cols="30" rows="6"><s:property
						value="#session.order.remark" /></textarea>
			</fieldset>
			
			<fieldset class="col-md-12 col-sm-12">
				<input type="submit" class="button big default" value="发布招募" id="btn4" />
			</fieldset>
		</form>
		
	</div>
	<div style="display:none">
      <button id="clickMe" class="md-trigger md-setperspective" data-modal="modal-17">发布招募</button>
</div>
	<!-- classie.js by @desandro: https://github.com/desandro/classie -->
	<script src="Merchant/js/classie.js"></script>
	<script src="Merchant/js/modalEffects.js"></script>

	<!-- for the blur effect -->
	<!-- by @derSchepp https://github.com/Schepp/CSS-Filters-Polyfill -->
	<script>
		// this is important for IEs
		var polyfilter_scriptpath = '/js/';
	</script>
	<script src="Merchant/js/cssParser.js"></script>
	<script src="Merchant/js/css-filters-polyfill.js"></script>
</body>
</html>