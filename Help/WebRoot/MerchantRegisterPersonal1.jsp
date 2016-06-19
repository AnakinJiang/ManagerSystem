<!-- 注册主页面，用框架包含注册子页面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<%
  String picUrl =(String)(session.getAttribute("Picurl"));
  System.out.println(picUrl); 
  String  step = (String)(session.getAttribute("step"));
  System.out.println(step);
  String defaultPic ="Merchant/image/man.GIF";
/*   System.out.println(merchant.merchantAge); */
  String age=(String)(session.getAttribute("merchant.merchantAge"));
  if("3".equals(step))
    defaultPic = picUrl;
%>
<meta charset="utf-8">
<title>我帮你注册</title>
<link rel="stylesheet" href="Merchant/css/MerchantRegisterStyle1.css"  type="text/css">
<script type="text/javascript">
document.createElement("section");
document.createElement("article");
document.createElement("footer");
document.createElement("header");
document.createElement("hgroup");
document.createElement("nav");
document.createElement("menu");
</script>
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
 <header>
   <div class="w12 header">
   <a class="db logo fl"><img src="Merchant/img/logo.jpg" width="327" height="94"  alt=""/></a>
   <div class="fr logofr"><a>返回首页</a> |<a>客服中心</a><br>
      如注册遇到问题请拨打：<strong style="font-size:14px;">123456</strong></div>
   </div>
 </header>
 <div class="head_border"></div>
 <section class="w12 login">
 <em class="fr">已经是会员，请&nbsp;&nbsp;<a class="db logbtn fr" href="MerchantLogin.jsp">前往登录</a> </em>
 </section>
 <section class="main w12">
   <div class="title"><a class="title2 db fl">外卖侠</a><a class="title1 db fl">商家</a></div>
   <div class="fr tit2"><span class="arr" style="float:right"></span></div>
   <div class="w12 step"></div>
  <div ><iframe id="content" src="MerchantRegisterPersonal.jsp" height="740px" width="100%" frameborder="0" ></iframe></div>
   </section>
</body>
</html>