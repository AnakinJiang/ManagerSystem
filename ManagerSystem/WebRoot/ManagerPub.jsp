<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page import="java.util.List"%>
<%@ page import="cn.edu.zjut.po.Merchant"%>
<%@ page import="cn.edu.zjut.po.Manager"%>
<%@ page import="org.apache.struts2.ServletActionContext"%>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
<meta charset="utf-8" />
<title>所有商家</title>
<meta name="description"
	content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="js/jPlayer/jplayer.flat.css"
	type="text/css" />
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="css/animate.css" type="text/css" />
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="css/simple-line-icons.css" type="text/css" />
<link rel="stylesheet" href="css/font.css" type="text/css" />
<link rel="stylesheet" href="css/app.css" type="text/css" />
<link rel="icon" href="guidePage/img/favicon.ico">
<!--[if lt IE 9]>
    <script src="js/ie/html5shiv.js"></script>
    <script src="js/ie/respond.min.js"></script>
    <script src="js/ie/excanvas.js"></script>
  <![endif]-->
</head>
<body class="">
	<section class="vbox">
		<header
			class="bg-white-only header header-md navbar navbar-fixed-top-xs">
			<div class="navbar-header aside bg-info nav-xs">
				<a class="btn btn-link visible-xs"
					data-toggle="class:nav-off-screen,open" data-target="#nav,html">
					<i class="icon-list"></i>
				</a> <a href="Welcome.jsp" class="navbar-brand text-lt"> <img
					src="images/logo.png" alt="."> <span
					class="hidden-nav-xs m-l-sm">首页</span>
				</a> <a class="btn btn-link visible-xs" data-toggle="dropdown"
					data-target=".user"> <i class="icon-settings"></i>
				</a>
			</div>
			<ul class="nav navbar-nav hidden-xs">
				<li><a href="#nav,.navbar-header"
					data-toggle="class:nav-xs,nav-xs" class="text-muted"> <i
						class="fa fa-indent text"></i> <i class="fa fa-dedent text-active"></i>
				</a></li>
			</ul>
			<%-- <form action=""
				class="navbar-form navbar-left input-s-lg m-t m-l-n-xs hidden-xs"
				role="search">
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-btn">
							<button type="submit"
								class="btn btn-sm bg-white btn-icon rounded">
								<i class="fa fa-search"></i>
							</button>
						</span> <input type="text"
							class="form-control input-sm no-border rounded"
							placeholder="查询商家">
					</div>
				</div>
			</form> --%>
			<div class="navbar-right ">
				<ul class="nav navbar-nav m-n hidden-xs nav-user user">
					<!-- 这里放管理员的个人信息 -->
					<li class="dropdown"><a href="#"
						class="dropdown-toggle bg clear" data-toggle="dropdown"> <span
							class="thumb-sm avatar pull-right m-t-n-sm m-b-n-sm m-l-sm">
								<img src="images/a0.png" alt="...">
						</span> 葛丛丛 <b class="caret"></b>
					</a>
						<ul class="dropdown-menu animated fadeInRight">
							<li><span class="arrow top"></span> <a href="Login.jsp">注销</a></li>
							<li class="divider"></li>
							<%-- <li><a href="#"> <span
									class="badge bg-danger pull-right">3</span> 未读信息
							</a></li> --%>
						</ul></li>
				</ul>
			</div>
		</header>
		<section>
			<section class="hbox stretch">
				<!-- .aside -->
				<aside class="bg-black dk nav-xs aside hidden-print" id="nav">
					<section class="vbox">
						<section class="w-f-md scrollable">
							<div class="slim-scroll" data-height="auto"
								data-disable-fade-out="true" data-distance="0" data-size="10px"
								data-railOpacity="0.2">



								<!-- nav -->
								<nav class="nav-primary hidden-xs">
									<ul class="nav bg clearfix">
										<li class="hidden-nav-xs padder m-t m-b-sm text-xs text-muted">
											功能一栏</li>
										<li><a href="findAllMerchant"> <i
												class="icon-disc icon text-success"></i> <span
												class="font-bold">所有商家</span>
										</a></li>
										<li><a href="findPassMerchant"> <i
												class="icon-drawer icon text-primary-lter"></i> <span
												class="font-bold">通过审核</span>
										</a></li>
										<li><a href="findUnPassMerchant"> <i
												class="icon-list icon  text-info-dker"></i> <span
												class="font-bold">未通过审核</span>
										</a></li>
										<li><a href="ManagerPub.jsp"> <i
												class="icon-notebook icon  text-info-dker"></i> <span
												class="font-bold">发布通知</span>
										</a></li>
										<li><a href="lookNotice"> <i
												class="icon-envelope-open icon  text-info-dker"></i> <span
												class="font-bold">管理并查看通知</span>
										</a></li>
										<%-- <li><a href="NewMerchants.jsp" data-target="#content"
											data-el="#bjax-el" data-replace="true"> <i
												class="icon-grid icon  text-primary"></i> <b
												class="badge bg-primary pull-right">6</b> <!-- 新注册商家的数量 -->
												<span class="font-bold">新注册商家</span>
										</a></li> --%>
										<li class="m-b hidden-nav-xs"></li>
									</ul>
								</nav>
								<!-- / nav -->
							</div>
						</section>

						<footer class="footer hidden-xs no-padder text-center-nav-xs">
							<div class="bg hidden-xs ">
								<div class="dropdown dropup wrapper-sm clearfix">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">
										<span class="thumb-sm avatar pull-left m-l-xs"> <img
											src="images/a3.png" class="dker" alt="..."> <i
											class="on b-black"></i>
									</span> <span class="hidden-nav-xs clear"> <span
											class="block m-l"> <strong class="font-bold text-lt">葛丛丛</strong>
												<b class="caret"></b>
										</span> <span class="text-muted text-xs block m-l">技术总监</span>
									</span>
									</a>
									<ul class="dropdown-menu animated fadeInRight aside text-left">
										<li><span class="arrow bottom hidden-nav-xs"></span> <a
											href="Login.jsp">注销</a></li>
										<li class="divider"></li>
										<%-- <li><a href="#"> <span
												class="badge bg-danger pull-right">3</span> 未读信息
										</a></li> --%>
									</ul>
								</div>
							</div>
						</footer>
					</section>
				</aside>
				<!-- /.aside -->
				<section id="content">
					<section class="hbox stretch">
						<section>
							<section class="vbox">
								<section class="scrollable padder-lg w-f-md" id="bjax-target">
									<a href="AllMerchant.jsp" class="pull-right text-muted m-t-lg"
										data-toggle="class:fa-spin"><i
										class="icon-refresh i-lg  inline" id="refresh"></i></a>
									<h2 class="font-thin m-b">
										发布通知 <span class="musicbar animate inline m-l-sm"
											style="width: 20px; height: 20px"> <span
											class="bar1 a1 bg-primary lter"></span> <span
											class="bar2 a2 bg-info lt"></span> <span
											class="bar3 a3 bg-success"></span> <span
											class="bar4 a4 bg-warning dk"></span> <span
											class="bar5 a5 bg-danger dker"></span>
										</span>
									</h2>

									<div class="container body-content">
										<div class="row">      <!-- col-md-offset-3  放在下面div的class里,用来控制居中 -->
											<div class="col-md-6 well" style="width:900px">
												<form action="noticeinsert" method="post"
													class="form-horizontal" >
													<fieldset>
														<legend>今天想告诉商家什么</legend>
														<div class="form-group">
															<label for="password" class="col-lg-2 control-label">内容</label>
															<div class="col-lg-10">
																<textarea class="form-control" id="password"
																	name="notice.content" placeholder="请输入内容" cols="100"
																	rows="10" required>
							                                    </textarea>
															</div>
														</div>
														<div class="form-group">
															<div class="col-lg-10 col-lg-offset-2">
																<button type="submit" class="btn btn-primary">发布</button>
															</div>
														</div>
													</fieldset>
												</form>
											</div>
										</div>
									</div>
								</section>
							</section>
						</section>
						<!-- side content -->
						<%-- <aside class="aside-md bg-light dk" id="sidebar">
							<section class="vbox animated fadeInRight">
								<section class="w-f-md scrollable hover">
									<h4 class="font-thin m-l-md m-t">合作伙伴</h4>
									<ul class="list-group no-bg no-borders auto m-t-n-xxs">
										<li class="list-group-item"><span
											class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
												<img src="images/a1.png" alt="..." class="img-circle">
												<i class="on b-light right sm"></i>
										</span>
											<div class="clear">
												<div>
													<a href="#">Chris Fox</a>
												</div>
												<small class="text-muted">New York</small>
											</div></li>
										<li class="list-group-item"><span
											class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
												<img src="images/a2.png" alt="..."> <i
												class="on b-light right sm"></i>
										</span>
											<div class="clear">
												<div>
													<a href="#">Amanda Conlan</a>
												</div>
												<small class="text-muted">France</small>
											</div></li>
										<li class="list-group-item"><span
											class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
												<img src="images/a3.png" alt="..."> <i
												class="busy b-light right sm"></i>
										</span>
											<div class="clear">
												<div>
													<a href="#">Dan Doorack</a>
												</div>
												<small class="text-muted">Hamburg</small>
											</div></li>
										<li class="list-group-item"><span
											class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
												<img src="images/a4.png" alt="..."> <i
												class="away b-light right sm"></i>
										</span>
											<div class="clear">
												<div>
													<a href="#">Lauren Taylor</a>
												</div>
												<small class="text-muted">London</small>
											</div></li>
										<li class="list-group-item"><span
											class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
												<img src="images/a5.png" alt="..." class="img-circle">
												<i class="on b-light right sm"></i>
										</span>
											<div class="clear">
												<div>
													<a href="#">Chris Fox</a>
												</div>
												<small class="text-muted">Milan</small>
											</div></li>
										<li class="list-group-item"><span
											class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
												<img src="images/a6.png" alt="..."> <i
												class="on b-light right sm"></i>
										</span>
											<div class="clear">
												<div>
													<a href="#">Amanda Conlan</a>
												</div>
												<small class="text-muted">Copenhagen</small>
											</div></li>
										<li class="list-group-item"><span
											class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
												<img src="images/a7.png" alt="..."> <i
												class="busy b-light right sm"></i>
										</span>
											<div class="clear">
												<div>
													<a href="#">Dan Doorack</a>
												</div>
												<small class="text-muted">Barcelona</small>
											</div></li>
										<li class="list-group-item"><span
											class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
												<img src="images/a8.png" alt="..."> <i
												class="away b-light right sm"></i>
										</span>
											<div class="clear">
												<div>
													<a href="#">Lauren Taylor</a>
												</div>
												<small class="text-muted">Tokyo</small>
											</div></li>
										<li class="list-group-item"><span
											class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
												<img src="images/a9.png" alt="..." class="img-circle">
												<i class="on b-light right sm"></i>
										</span>
											<div class="clear">
												<div>
													<a href="#">Chris Fox</a>
												</div>
												<small class="text-muted">UK</small>
											</div></li>
										<li class="list-group-item"><span
											class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
												<img src="images/a1.png" alt="..."> <i
												class="on b-light right sm"></i>
										</span>
											<div class="clear">
												<div>
													<a href="#">Amanda Conlan</a>
												</div>
												<small class="text-muted">Africa</small>
											</div></li>
										<li class="list-group-item"><span
											class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
												<img src="images/a2.png" alt="..."> <i
												class="busy b-light right sm"></i>
										</span>
											<div class="clear">
												<div>
													<a href="#">Dan Doorack</a>
												</div>
												<small class="text-muted">Paris</small>
											</div></li>
										<li class="list-group-item"><span
											class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
												<img src="images/a3.png" alt="..."> <i
												class="away b-light right sm"></i>
										</span>
											<div class="clear">
												<div>
													<a href="#">Lauren Taylor</a>
												</div>
												<small class="text-muted">Brussels</small>
											</div></li>
									</ul>
								</section>
								<footer class="footer footer-md bg-black">
									<form action="" class="" role="search">
										<div class="form-group clearfix m-b-none">
											<div class="input-group m-t m-b">
												<span class="input-group-btn">
													<button type="submit"
														class="btn btn-sm bg-empty text-muted btn-icon">
														<i class="fa fa-search"></i>
													</button>
												</span> <input type="text"
													class="form-control input-sm text-white bg-empty b-b b-dark no-border"
													placeholder="查找合作伙伴">
											</div>
										</div>
									</form>
								</footer>
							</section>
						</aside> --%>
						<!-- / side content -->
					</section>
					<a href="#" class="hide nav-off-screen-block"
						data-toggle="class:nav-off-screen,open" data-target="#nav,html"></a>
				</section>
			</section>
		</section>
	</section>
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.js"></script>
	<!-- App -->
	<script src="js/app.js"></script>
	<script src="js/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="js/app.plugin.js"></script>
	<script type="text/javascript" src="js/jPlayer/jquery.jplayer.min.js"></script>
	<script type="text/javascript"
		src="js/jPlayer/add-on/jplayer.playlist.min.js"></script>
	<script type="text/javascript" src="js/jPlayer/demo.js"></script>
    
</body>
</html>