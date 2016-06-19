<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="cn.edu.zjut.po.Employee"%>
<%@ page import="cn.edu.zjut.po.Merchant"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	int curPage = 1;
	int pageCount = 1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>招募信息</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="commonCSS/appNobg.css" type="text/css" />
<link rel="stylesheet" href="Employee/css/normalize.css">
<link rel="stylesheet" href="Employee/css/font-awesome.css">
<link rel="stylesheet" href="Employee/css/bootstrap.min.css">
<link rel="stylesheet" href="Employee/css/templatemo-style.css">
<link rel="stylesheet" href="Employee/css/menuList.css">
<link rel="stylesheet" href="Employee/css/chinaz.css">
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css"
	href="Employee/windowcss/default.css" />
<link rel="stylesheet" type="text/css"
	href="Employee/windowcss/component.css" />
<script src="Employee/windowjs/modernizr.custom.js"></script>
<script src="Employee/js/chinaz.js"></script>
<script src="Employee/js/vendor/modernizr-2.6.2.min.js"></script>
<script src="commonJS/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="commonJS/bootstrap.js"></script>
<script src="commonJS/app.js"></script>
<script>
	$(function() {
<%if (session.getAttribute("merchantinfo") != null) {%>
	document.getElementById("seeInfo").click();
<%}%>
	})
</script>
</head>
<body style="font-family: Microsoft JhengHei">
	<div class="page-section" id="about">
		<div class="row">
			<div class="col-md-12">
				<h4 class="widget-title" style="font-size: 25px; font-weight: 600;">招募信息</h4>
			</div>
		</div>
		<div id='cssmenu'>
			<ul>
				<li><a href='OrderByDefault'>默认排序</a></li>
				<li><a href='OrderBySalary'>薪&nbsp;酬&nbsp;&nbsp;<i
						class="fa fa-long-arrow-down"></i></a></li>
				<li><a href='OrderByRank'>好&nbsp;评&nbsp;&nbsp;<i
						class="fa fa-long-arrow-down"></i></a></li>
				<li><a href='OrderByNeed'>招募人数&nbsp;&nbsp;<i
						class="fa fa-long-arrow-down"></i></a></li>
			</ul>
		</div>
		<div>
			<s:property value="#request.tip" />
		</div>

		<div class="row projects-holder">
			<%
				List list = (List) session.getAttribute("orderinfos");
				int size = list.size();
				if (list != null && size != 0) {
					try {
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
						do {
							if (count >= PAGESIZE)
								break;
							Object[] object = (Object[]) list.get(start);
							Date dd=(Date)object[1];
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String releaseTime=sdf.format(dd);
							System.out.println("JSP"+releaseTime);
							start++;
							count++;
			%>
			<div class="col-md-4 col-sm-6">
				<div class="project-item">
					<img src="Employee/img/1.jpg" alt="">
					<div class="project-hover">
						<div class="inside">
							<s:form action="CheckDetail" method="post" target="_balnk">
								<input type="hidden" name="merchant.merchantID"
									value="<%=object[6]%>" />
								<input type="submit" class="checkButton" value="点我查看店铺详细资料" />
							</s:form>
							<s:form action="AcceptOrder" method="post" target="_blank">
								<p>
									招 募 人 数：<%=object[0]%>
								<p>
									招募发布时间：<%=object[1]%>
								<p>
									工作开始时间：<%=object[2]%>
								<p>
									招 募 薪 资：<%=object[3]%>
								<p>
									商 家 等 级：<%=object[4]%>
								<p>
									商 家 店 名：<%=object[5]%>
								<p>
									联 系 方 式：<%=object[6]%>
									<input type="hidden" name="order.merchant.merchantID"
										value="<%=object[6]%>" /> <input type="hidden"
										name="releaseTime" value="<%=releaseTime%>" />
								<p>
									<input type="button" class="button" data-toggle="modal"
										data-target="#" value="接受招募" onClick="warning()" /> <input
										type="submit" id="submitButton" style="display: none"
										class="button" value="接受招募" />
									<!-- 打开模态框 -->
									<input type="button" style="display: none" id="open"
										data-toggle="modal" data-target="#<%=start%>" />
								</p>
							</s:form>
						</div>
					</div>
				</div>
			</div>
			<script>
				function warning() {
			<%Employee employee = (Employee) session.getAttribute("employee");%>
				
			<%if (employee.getPool() <= 0.2) {//资金不足%>
				var elementID =<%=start%>;
					//alert(elementID);
					document.getElementById("open").click();
			<%} else {%>
				document.getElementById("submitButton").click();
			<%}%>
				}
			</script>
			<!-- 模态框 -->
			<div class="modal fade" id="<%=start%>" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true"
				style="margin-top: 125px">
				<div class="modal-dialog">
					<form class="form-horizontal" action="payPromise" method="post">
						<%
							session.setAttribute("myInfo", employee);
						%>
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<label class="modal-title" style="color: #373737;">保证金抵押</label>
								<h6 class="modal-title"
									style="color: #f46151; font-size: 14px; font-weight: 500px">
									平台上的保证金不足，不能接受招募<br> 请先存放一定金额的保证金到平台上
								</h6>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<label class="col-sm-2 control-label" style="color: #373737">金额</label>
									<div class="col-sm-6">
										<input type="text" name="employee.pool" class="form-control" />
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="submit" class="btn btn-primary"
									style="background-color: #f46151; border-color: #f46151">确认存放</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</form>
				</div>
			</div>
			<!-- /.modal-dialog -->

			<%
				} while (start < list.size());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			%>
			<p>
		</div>
	</div>
	<div class="dividePage">
		<a href="findMission.jsp?curPage=1">首页</a> <a
			href="findMission.jsp?curPage=<%=curPage - 1%>">上一页</a> <a
			href="findMission.jsp?curPage=<%=curPage + 1%>">下一页</a> <a
			href="findMission.jsp?curPage=<%=pageCount%>">尾页</a> 第<%=curPage%>页/共<%=pageCount%>页
	</div>

	<div class="md-modal md-effect-17" id="modal-17">
		<div class="md-content">
			<h3>店铺信息</h3>
			<%
				Merchant m = (Merchant) session.getAttribute("merchantinfo");
				if (m != null) {
					String BusinessLicence = "Merchant/MerchantIMG/" + m.getMerchantID() + "/MerchantBusinesslicence.jpg";
					String SecurityLicence = "Merchant/MerchantIMG/" + m.getMerchantID() + "/MerchantSecurityLicence.jpg";
			%>
			<div>
				<ul>
					<li><strong>店名:</strong><%=m.getShopName()%></li>
					<li><strong>联系方式:</strong><%=m.getMerchantID()%></li>
					<li><strong>商家宣言:</strong><%=m.getMerchantSignature()%></li>
					<li><strong>营业执照</strong> <a> <img
							src=<%=BusinessLicence%> alt="images/p1.jpg"
							style="height: 110px; width: 200px;">
					</a></li>
					<li><strong>卫生许可:</strong> <a> <img
							src=<%=SecurityLicence%> alt="images/p1.jpg"
							style="height: 110px; width: 200px;">
					</a></li>
				</ul>
				<button class="md-close">关闭</button>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<div class="container" style="display: none">
		<div class="main clearfix">
			<div class="column">
				<button class="md-trigger md-setperspective" id="seeInfo"
					data-modal="modal-17" style="display: none">店铺详细资料</button>
			</div>
		</div>
	</div>
	<!-- /container -->
	<div class="md-overlay"></div>
	<!-- the overlay element -->

	<script src="Employee/windowjs/classie.js"></script>
	<script src="Employee/windowjs/modalEffects.js"></script>

	<script>
		// this is important for IEs
		var polyfilter_scriptpath = '/js/';
	</script>
	<script src="Employee/windowjs/cssParser.js"></script>
	<script src="Employee/windowjs/css-filters-polyfill.js"></script>




</body>
</html>