<!-- 注册个人信息，包括头像，个性签名 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
  String picUrl =(String)(session.getAttribute("Picurl"));
  System.out.println(picUrl); 
  String  step = (String)(session.getAttribute("step"));
  System.out.println(step);
  String defaultPic ="Merchant/image/man.GIF";
  if("3".equals(step))
    defaultPic = picUrl;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<title></title>
<link href="Merchant/css/mainIMG.css" type="text/css" rel="Stylesheet" />
<script type="text/javascript" src="Merchant/js/jquery1.2.6.pack.js"></script>
<script type="text/javascript" src="Merchant/js/ui.core.packed.js"></script>
<script type="text/javascript" src="Merchant/js/ui.draggable.packed.js"></script>
<script type="text/javascript" src="Merchant/js/CutPic.js"></script>
<script type="text/javascript">
        function Step1() {
            $("#Step2Container").hide();           
        }
        function Step2() {
            $("#CurruntPicContainer").hide();
        }
        function Step3() {
            $("#Step2Container").hide();          
       }
    </script>
</head>
<body>
&nbsp;&nbsp;<img src="Merchant/img/02.jpg"/>
	<div>
		<div class="left">
			<!--当前照片-->
			<div id="CurruntPicContainer">
				<div class="title">
					<b>当前照片</b>
				</div>
				<div class="photocontainer">
					<img id="imgphoto" src="<%=defaultPic%>" style="border-width:0px;" />
				</div>
			</div>
			<!--Step 2-->
			<div id="Step2Container">
				<div class="title">
					<b> 裁切头像照片</b>
				</div>
				<div class="uploadtooltip">您可以拖动照片以裁剪满意的头像</div>
				<div id="Canvas" class="uploaddiv">

					<div id="ImageDragContainer">
						<img id="ImageDrag" class="imagePhoto" src="<%=picUrl %>"
							style="border-width:0px;" />
					</div>
					<div id="IconContainer">
						<img id="ImageIcon" class="imagePhoto" src="<%=picUrl%>"
							style="border-width:0px;" />
					</div>
				</div>
				<div class="inputsec">
					<ul>
					<li class="clr"><label class="db fl">&nbsp;</label>
					<table>
						<tr>
							<td id="Min"><img alt="缩小" src="Merchant/image/_c.gif"
								onmouseover="this.src='Merchant/image/_c.gif';"
								onmouseout="this.src='Merchant/image/_h.gif';" id="moresmall"
								class="smallbig" /></td>
							<td>
								<div id="bar">
									<div class="child"></div>
								</div>
							</td>
							<td id="Max"><img alt="放大" src="Merchant/image/c.gif"
								onmouseover="this.src='Merchant/image/c.gif';"
								onmouseout="this.src='Merchant/image/h.gif';" id="morebig"
								class="smallbig" /></td>
						</tr>
					</table>
					</li>
					</ul>
				</div>
				<form action="merchantZoomImage" method="post">
				    <div class="uploaddiv">
					    <input type="hidden" name="photo.picurl" value="<%=picUrl%>" />
						<input type="text" name="photo.idnum" value="${sessionScope.merchant.merchantID}" />
                        <input type="submit" name="btn_Image" value="保存头像" id="btn_Image" />
					</div>
					<div style="display:none">
						<input name="photo.imageWidth" type="hidden" value="1" id="txt_width" /><br /> 
						<input name="photo.imageHeight" type="hidden" value="1" id="txt_height" /><br />
                        <input name="photo.cutTop" type="hidden" value="82" id="txt_top" /><br />
						<input name="photo.cutLeft" type="hidden" value="73" id="txt_left" /><br />
						<input name="photo.dropWidth" type="hidden" value="120" id="txt_DropWidth" /><br /> 
						<input name="photo.dropHeight" type="hidden" value="120" id="txt_DropHeight" /><br />
                        <input name="photo.imageZoom" type="hidden" id="txt_Zoom" />
					</div>
				</form>
			</div>

		</div>
		</div>
		<div>
		<form name="form1" method="post" action="merchantUploadIMG" id="form1"
			enctype="multipart/form-data">
			<div class="right">
				<!--Step 1-->
				<div id="Step1Container">
				<div class="inputsec">
					<div class="title">
						<b>更换照片</b>
					</div>
					<div id="uploadcontainer">
						<div class="uploadtooltip">请选择新的照片文件，文件需小于2.5MB</div>
						<div class="uploaddiv"><input type="file" name="photo.origin" id="origin" title="选择照片" /></div>
						<div class="uploaddiv"><input type="text" name="photo.idnum" value="${sessionScope.merchant.merchantID}" /></div>
						<ul>
						<li class="clr"><label class="db fl">&nbsp;</label><input type="submit" class="db fl next" value="上传" /></li>
						</ul>
					</div>
</div>
				</div>
			</div>
		</form>
	</div>
	<% 
      if(null==picUrl||"".equals(picUrl))
      {%>
	<script type='text/javascript'>Step1();</script>
	<%}else if(!"".equals(picUrl)&& "2".equals(step)){
      %>
	<script type='text/javascript'>Step2();</script>
	<%}else if(!"".equals(picUrl)&& "3".equals(step)){
      %>
	<script type='text/javascript'>Step3();</script>
	<%}%>
	<div class="inputsec">
	
	
	<form action="MerchantRegisterUpdate" method="post">
		<ul>
			<li class="clr"><label class="fl mr2">账号：</label><input type="text" name="merchant.merchantID"  class="txt-m fl " value="${sessionScope.merchant.merchantID}" /></li>
			<li style="display:none"><input type="hidden" name="merchant.merchantAge" class="txt-m fl " value="${sessionScope.merchant.merchantAge}" /></li>
			<li class="clr"><label class="fl mr2">用户名：</label><input type="text" name="merchant.merchantUsername" class="txt-m fl " value="${sessionScope.merchant.merchantUsername}" /></li>
			<li class="clr"><label class="fl mr2">个性签名：</label><input type="text" name="merchant.merchantSignature" class="txt-m fl " value="${sessionScope.merchant.merchantSignature}"/></li>
			<li class="clr"><label class="db fl">&nbsp;</label><input type="submit" class="db fl next" value="下一步" /></li>
			<li style="display:none"><input type="hidden"  name="merchant.merchantPassword" value="${sessionScope.merchant.merchantPassword}" /></li>
			<li style="display:none"><input type="hidden" name="merchant.merchantIDNum" value="${sessionScope.merchant.merchantIDNum}" /></li>
			<li style="display:none"><input type="hidden" name="merchant.merchantName" value="${sessionScope.merchant.merchantName}" /></li>
			<li style="display:none"><input type="hidden" name="merchant.merchantSex" value="${sessionScope.merchant.merchantSex}" /></li>
			<li style="display:none"><input type="hidden" name="merchant.shopName" value="${sessionScope.merchant.shopName}" /></li>
			<li style="display:none"><input type="hidden" name="merchant.shopAddress" value="${sessionScope.merchant.shopAddress}" /></li>
			<li style="display:none"><input type="hidden" name="merchant.merchantIMG" value="${sessionScope.merchant.merchantIMG}" /></li>
			<li style="display:none"><input type="hidden" name="merchant.merchantState" value="${sessionScope.merchant.merchantState}"/></li>
			<li style="display:none"><input type="hidden" name="merchant.merchantGrade" value="${sessionScope.merchant.merchantGrade}"/></li>		
		</ul>
	</form>
	</div>
</body>
</html>