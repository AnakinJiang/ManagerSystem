<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.List"%>
<%@ page import="cn.edu.zjut.po.Merchant"%>
<%@ page import="cn.edu.zjut.po.Manager"%>
<%@ page import="org.apache.struts2.ServletActionContext"%>
<!DOCTYPE HTML>
<html>
<head>
<title>管理员主页面</title>
</head>
<%
	int curPage = 1;
	int pageCount = 1;
	Manager manager = (Manager) session.getAttribute("manager");
	String managerId=manager.getManagerId();
%>
<body>
	<h1>管理员主界面</h1>
	<p>管理员：<%=managerId%></p>
	<table border="1">
		<tr>
		<td><p>商家姓名</p>
		</td>
		<td>商家状态
		</td>
		<td>商家详细
		</td>
		</tr>
		<%
			try {
				List list1 = (List) session.getAttribute("merchants");
				int size = list1.size();
				int PAGESIZE = 9;

				pageCount = (size % PAGESIZE == 0) ? (size / PAGESIZE) : (size / PAGESIZE + 1);
				String tmp = request.getParameter("curPage");
				if (tmp == null) {
					tmp = "1";
				}
				curPage = Integer.parseInt(tmp);
				if (curPage >= pageCount)
					curPage = pageCount;
				if (curPage <= 0)
					curPage = 1;

				int start = (curPage - 1) * PAGESIZE;

				int count = 0;
				if (start >= 0) {
					while (start < list1.size()) {
						if (count >= PAGESIZE)
							break;
						Merchant merchant = (Merchant) list1.get(start);
						String name = merchant.getMerchantName();
						String IdNumber = merchant.getMerchantIDNum();
						String MerchantBusinesslicence = ServletActionContext.getServletContext().getRealPath("/")
								+ "Merchant/MerchantIMG/" + merchant.getMerchantID() + "/"
								+ "MerchantBusinesslicence.jpg";
						String MerchantSecurityLicence = ServletActionContext.getServletContext().getRealPath("/")
								+ "Merchant/MerchantIMG/" + merchant.getMerchantID() + "/"
								+ "MerchantSecurityLicence.jpg";
						Boolean state = merchant.getMerchantState();
						start++;
						count++;
		%>
		<tr>
			<form action="detail" method="post">
			<div style="display:none">
			
			<input type="hidden" name="merchant.merchantID" value=<%=merchant.getMerchantID()%>>
			<input type="hidden" name="merchant.merchantState" value=<%=state %>>
			</div>
				<td><%=name%></td>

				<%
					if (state) {
				%>
				<td>
					<p>已通过审核</p>
				</td>
				<%
					} else {
				%>
				<td>
					<p>未通过审核</p>
				</td>
				<%
					}
				%>
				<td><input type="submit" value="查看详细信息"></td>
			</form>
		</tr>
		<%
			}
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		%>
	</table>
</body>
</html>