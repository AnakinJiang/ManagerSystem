<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="cn.edu.zjut.po.Merchant"%>
<!DOCTYPE HTML>
<html>
<head>
<title>商家详细信息页面</title>
</head>

<%
Merchant merchant=	(Merchant) session.getAttribute("merchant");
System.out.println(merchant.getShopName());
String MerchantBusinesslicence="..\\Help\\Merchant\\MerchantIMG\\"+merchant.getMerchantID()+"\\MerchantBusinesslicence.jpg";
String MerchantSecurityLicence="..\\Help\\Merchant\\MerchantIMG\\"+merchant.getMerchantID()+"\\MerchantSecurityLicence.jpg";
System.out.println(MerchantBusinesslicence);
System.out.println(MerchantSecurityLicence);
%>
<body>

		<table border="1">
				<tr>
		<td>商家昵称</td><td><%=merchant.getMerchantUsername() %></td>
		</tr>
		<tr>
		<td>商家姓名</td><td><%=merchant.getMerchantName() %></td>
		</tr>
				<tr>
		<td>商家身份证</td><td><%=merchant.getMerchantIDNum() %></td>
		</tr>
				<tr>
		<td>商家营业执照</td><td><img id="imgphoto" src=<%=MerchantBusinesslicence%> /></td>
		</tr>
				<tr>
		<td>商家卫生许可</td><td><img id="imgphoto" src=<%=MerchantSecurityLicence%> /></td>
		</tr>
				<tr>
		<td>商家店名</td><td><%=merchant.getShopName() %></td>
		</tr>
				<tr>
		<td>商家地址</td><td><%=merchant.getShopAddress() %></td>
		</tr>
		
		<tr><td>
		<form action="delete" method="post">
		<div style="display:none">
			<input type="hidden" name="merchant.merchantID" value=<%=merchant.getMerchantID()%>>
            <input type="hidden" name="merchant.merchantPassword" value=<%=merchant.getMerchantPassword()%>>
			<input type="hidden" name="merchant.merchantIDNum" value=<%=merchant.getMerchantIDNum()%>>
			<input type="hidden" name="merchant.merchantName" value=<%=merchant.getMerchantName()%>>
			<input type="hidden" name="merchant.merchantAge" value=<%=merchant.getMerchantAge()%>>
			<input type="hidden" name="merchant.shopName" value=<%=merchant.getShopName()%>>
			<input type="hidden" name="merchant.shopAddress" value=<%=merchant.getShopAddress()%>>
			<input type="hidden" name="merchant.merchantGrade" value=<%=merchant.getMerchantGrade()%>>
			<input type="hidden" name="merchant.merchantSex" value=<%=merchant.getMerchantSex()%>>
			<input type="hidden" name="merchant.merchantIMG" value=<%=merchant.getMerchantIMG()%>>
			<input type="hidden" name="merchant.merchantState" value=<%=merchant.getMerchantState()%>>
			<input type="hidden" name="merchant.merchantSignature" value=<%=merchant.getMerchantSignature()%>>
							
			</div>
			<input type="submit" value="删除商家" >
		</form>
		</td>
		<td>
		<form action="pass" method="post">
		<div style="display:none">
			<input type="hidden" name="merchantID" value=<%=merchant.getMerchantID()%>>			
			</div>
			<input type="submit" value="通过审核" >
		</form>
		</td>
		</tr>
		</table>
</body>
</html>