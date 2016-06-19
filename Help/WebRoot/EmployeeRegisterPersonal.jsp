<!-- 注册个人信息，包括头像，个性签名 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String picUrl =(String)(session.getAttribute("Picurl"));
  System.out.println("picUrl"+picUrl); 
  String  step = (String)(session.getAttribute("step"));
  System.out.println(step);
  String defaultPic ="Employee/image/man.GIF";
  if("2".equals(step))
  {
	  defaultPic = picUrl;
  }
  if("3".equals(step))
    defaultPic = picUrl;
  if("1".equals(step))
  {
	  defaultPic="Employee/image/man.GIF";
  }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<title></title>
<link href="Employee/css/mainIMG.css" type="text/css" rel="Stylesheet" />
<script type="text/javascript" src="Employee/js/jquery1.2.6.pack.js"></script>
<script type="text/javascript" src="Employee/js/ui.core.packed.js"></script>
<script type="text/javascript" src="Employee/js/ui.draggable.packed.js"></script>
<script type="text/javascript" src="Employee/js/CutPic.js"></script>
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
&nbsp;&nbsp;<img src="Employee/img/02.jpg"/>
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
							<td id="Min"><img alt="缩小" src="Employee/image/_c.gif"
								onmouseover="this.src='Employee/image/_c.gif';"
								onmouseout="this.src='Employee/image/_h.gif';" id="moresmall"
								class="smallbig" /></td>
							<td>
								<div id="bar">
									<div class="child"></div>
								</div>
							</td>
							<td id="Max"><img alt="放大" src="Employee/image/c.gif"
								onmouseover="this.src='Employee/image/c.gif';"
								onmouseout="this.src='Employee/image/h.gif';" id="morebig"
								class="smallbig" /></td>
						</tr>
					</table>
					</li>
					</ul>
				</div>
				<form action="ZoomImage" method="post">
				    <div class="uploaddiv">
					    <input type="hidden" name="photo.picurl" value="<%=picUrl%>" />
						<input type="text" name="photo.idnum" value="${sessionScope.employee.employeeID}" />
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
		<form name="form1" method="post" action="UploadIMG" id="form1"
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
						<div class="uploaddiv"><input type="text" name="photo.idnum" value="${sessionScope.employee.employeeID}" /></div>
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
      if(null==picUrl||"".equals(picUrl)|| "1".equals(step))
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
	
	
	<form action="EmployeeRegisterUpdate" method="post">
		<ul>
			<li class="clr"><label class="fl mr2">账号：</label><input type="text" name="employee.employeeID"  class="txt-m fl " value="${sessionScope.employee.employeeID}" /></li>
			<li style="display:none"><input type="hidden" name="employee.employeeAge" class="txt-m fl " value="${sessionScope.employee.employeeAge}" /></li>
			<li class="clr"><label class="fl mr2">用户名：</label><input type="text" name="employee.employeeUserName" class="txt-m fl " value="${sessionScope.employee.employeeUserName}" /></li>
			<li class="clr"><label class="fl mr2">个性签名：</label><input type="text" name="employee.employeeSignature" class="txt-m fl " value="${sessionScope.employee.employeeSignature}"/></li>
			<li class="clr"><label class="db fl">&nbsp;</label><input type="submit" class="db fl next" value="下一步" /></li>
			<li style="display:none"><input type="hidden"  name="employee.employeePassword" value="${sessionScope.employee.employeePassword}" /></li>
			<li style="display:none"><input type="hidden" name="employee.employeeIDNum" value="${sessionScope.employee.employeeIDNum}" /></li>
			<li style="display:none"><input type="hidden" name="employee.employeeName" value="${sessionScope.employee.employeeName}" /></li>
			<li style="display:none"><input type="hidden" name="employee.employeeSex" value="${sessionScope.employee.employeeSex}" /></li>
			<li style="display:none"><input type="hidden" name="employee.employeePhone" value="${sessionScope.employee.employeePhone}" /></li>
			<li style="display:none"><input type="hidden" name="employee.shopAddress" value="${sessionScope.employee.employeeAddress}" /></li>
			<li style="display:none"><input type="hidden" name="employee.employeeIMG" value="${sessionScope.employee.employeeIMG}" /></li>
			<li style="display:none"><input type="hidden" name="employee.employeeState" value="${sessionScope.employee.employeeState}"/></li>
			<li style="display:none"><input type="hidden" name="employee.employeeGrade" value="${sessionScope.employee.employeeGrade}"/></li>
			<li style="display:none"><input type="hidden" name="employee.employeeFace" value="${sessionScope.employee.employeeFace}"/></li>
			<li style="display:none"><input type="hidden" name="employee.employeeAddress" value="${sessionScope.employee.employeeAddress}"/></li>
			<!-- <li class="clr"><a href="EmployeeRegisterSuccess.jsp">跳过</a></li> -->
			
		</ul>
	</form>
	</div>
</body>
</html>