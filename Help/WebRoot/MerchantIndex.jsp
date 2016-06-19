<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="cn.edu.zjut.po.Merchant"%>
<!DOCTYPE html>
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>我的主页</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="Merchant/css/normalize.css">
	<link rel="stylesheet" href="Merchant/css/font-awesome.css">
	<link rel="stylesheet" href="Merchant/css/bootstrap.min.css">
	<link rel="stylesheet" href="Merchant/css/templatemo-style.css">
	<script src="Merchant/js/vendor/modernizr-2.6.2.min.js"></script>
	<script>
  		function showDiv(name){//只显示特定block的内容
      		if("PutMission"==name){
    			document.getElementById(name).style.display="block";
    			document.getElementById("HistoryMission").style.display="none";
    			document.getElementById("Pay").style.display="none";
    			document.getElementById("Information").style.display="none";
    			document.getElementById("notice").style.display="none";
   			}
   			if("HistoryMission"==name){
    			document.getElementById(name).style.display="block";
    			document.getElementById("PutMission").style.display="none";
    			document.getElementById("Pay").style.display="none";
    			document.getElementById("Information").style.display="none";
    			document.getElementById("notice").style.display="none";
   			}
   			if("Pay"==name){
    			document.getElementById(name).style.display="block";
    			document.getElementById("PutMission").style.display="none";
    			document.getElementById("HistoryMission").style.display="none";
    			document.getElementById("Information").style.display="none";
    			document.getElementById("notice").style.display="none";
   			}
   			if("Information"==name){
   				document.getElementById(name).style.display="block";
    			document.getElementById("PutMission").style.display="none";
    			document.getElementById("HistoryMission").style.display="none";
    			document.getElementById("Pay").style.display="none";
    			document.getElementById("notice").style.display="none";
   			}
   			if("notice"==name){
   				document.getElementById(name).style.display="block";
    			document.getElementById("PutMission").style.display="none";
    			document.getElementById("HistoryMission").style.display="none";
    			document.getElementById("Pay").style.display="none";
    			document.getElementById("Information").style.display="none";
   			}
  		}
  		
  		function reinitIframe(name){//iframe自适应高度
			var iframe = document.getElementById(name);
			try{
				var bHeight = iframe.contentWindow.document.body.scrollHeight;
				var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
				var height = Math.max(bHeight, dHeight);
				iframe.height = height;
				console.log(height);
			}catch (ex){
				//alert(ex.message);//显示报错内容
				window.clearInterval(timer);
			}
		}
		var timer=setInterval(reinitIframe,1000);
	</script>
</head>
    <body>      
        <div class="responsive-header visible-xs visible-sm">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="top-section">
                            <div class="profile-image">
                                <img src= '<s:property value="#session.merchant.merchantIMG"/>' alt="Volton"/><%//！！用户头像的存放路径还得修改！！%>
                            </div>
                            <div class="profile-content">
                                <h3 class="profile-title"><s:property value="#session.merchant.merchantUsername" /></h3>
                                <p style="font-family:SimHei;color:white">等级：
                                <%  Merchant merchant=(Merchant)session.getAttribute("merchant");
                                	float grade=merchant.getMerchantGrade();
                                	int i;
                                	for(i=1;i<grade;i++){%>
                                	<i class="fa fa-star"></i>
                                	<%}%>
                                	<%if(i-grade>0.5 && i-grade<1){%>
                                		<i class="fa fa-star-o"></i>
                                	<%}%>
                                	<%if(i-grade<0.5 && i-grade>0){%>
                                		<i class="fa fa-star-half-empty"></i>
                                	<%}%>
                                	<%if(i-grade==0){%>
                                		<i class="fa fa-star"></i>
                                	<%}%>
                                </p>
                                <p class="profile-description"><s:property value="#session.merchant.merchantSignature" /></p>
                            </div>
                        </div>
                    </div>
                </div>
                <a href="#" class="toggle-menu"><i class="fa fa-bars"></i></a>
                <div class="main-navigation responsive-menu">
                    <ul class="navigation">
                   		 <li><a href="#PutMission" onclick="showDiv('PutMission')"><i class="fa fa-th-large"></i>发布招募</a></li>
                    <li><a href="#HistoryMission" onclick="showDiv('HistoryMission')"><i class="fa fa-history"></i>发布历史</a></li>
                    <li><a href="#Pay" onclick="showDiv('Pay')"><i class="fa fa-yen"></i>支付记录</a></li>
                    <li><a href="#notice" onclick="showDiv('notice')"><i class="fa fa-flag"></i>接受通知</a></li>
                    <li><a href="#Information" onclick="showDiv('Information')"><i class="fa fa-cog"></i>个人信息</a></li>
                    </ul>
                </div>
            </div>
        </div>
		
        <div class="sidebar-menu hidden-xs hidden-sm">
            <div class="top-section">
                <div class="profile-image">
                    <img src= '<s:property value="#session.merchant.merchantIMG"/>' alt="Volton"/><%//！！用户头像的存放路径还得修改！！%>
                </div>
                <h3 class="profile-title"><s:property value="#session.merchant.merchantUsername" /></h3>
                <p style="font-family:SimHei;color:white">等级：
                <%for(i=1;i<grade;i++){%>
                <i class="fa fa-star"></i>
                <%}%>
                <%if(i-grade>0.5 && i-grade<1){%>
                <i class="fa fa-star-o"></i>
                <%}%>
                <%if(i-grade<0.5 && i-grade>0){%>
                <i class="fa fa-star-half-empty"></i>
                <%}%>
                <%if(i-grade==0){%>
                <i class="fa fa-star"></i>
                <%}%>
                </p>
                <p class="profile-description"><s:property value="#session.merchant.merchantSignature" /></p>
            </div> <!-- top-section -->
            <div class="main-navigation">
                <ul class="navigation">
                    <li><a href="#PutMission" onclick="showDiv('PutMission')"><i class="fa fa-th-large"></i>发布招募</a></li>
                    <li><a href="#HistoryMission" onclick="showDiv('HistoryMission')"><i class="fa fa-history"></i>发布历史</a></li>
                    <li><a href="#Pay" onclick="showDiv('Pay')"><i class="fa fa-yen"></i>支付记录</a></li>
                    <li><a href="#notice" onclick="showDiv('notice')"><i class="fa fa-flag"></i>接受通知</a></li>
                    <li><a href="#Information" onclick="showDiv('Information')"><i class="fa fa-cog"></i>个人信息</a></li>
                </ul>
            </div> <!-- .main-navigation -->
            <div class="social-icons">
                <ul>
                	<li><a href="#"><i class="fa fa-qq"></i></a></li>
                    <li><a href="#"><i class="fa fa-wechat"></i></a></li>
                </ul>
            </div> <!-- .social-icons -->
        </div> <!-- .sidebar-menu -->
        
		<div class="copyrights">2016 Clouds Help项目开发小组</div>

        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="fluid-container">
                <div class="content-wrapper">
                
                    <!-- 发布招募 -->
                    <div class="page-section" id="PutMission" style="display:block" >
                    	<iframe id="PutMission" name="PutMission" src="MerchantPutMission.jsp" frameborder="0" scrolling="no" onload="reinitIframe('PutMission')" width=100% height="700px"></iframe>
                    </div>
                    
                    <!-- 发布历史 -->
                    <div class="page-section" id="HistoryMission" style="display:none">
                    	<iframe id="HistoryMission" name="HistoryMission" src="findFinishedOrder" frameborder="0" scrolling="no" width=100% height="1100px"></iframe>
                    </div>
                    
                    <!-- 支付记录 -->
					<div class="page-section" id="Pay" style="display:none">
						<iframe id="Pay" name="Pay" src="findUnpayedOrder" frameborder="0" scrolling="no" height="1100px" width="100%"></iframe>
					</div>
					
                    <!-- 个人信息 -->
                    <div class="page-section" id="Information" style="display:none">
                    <div class="row">
                        <div class="col-md-12">
                            <h4 class="widget-title" style="font-family:Microsoft JhengHei;font-size: 25px;font-weight: 600;">个人信息</h4>
                        </div>
                    </div>
                    <div class="tip"><s:fielderror/></div>
                    <div class="row">
                        <form action="MerchantUpdate" method="post" class="contact-form"><!-- 查看、更新个人信息 -->
                            <s:hidden name="merchant.merchantPassword" value="%{#session.merchant.merchantPassword}"/><!-- 密码 -->
                            <s:hidden name="merchant.merchantSex" value="%{#session.merchant.merchantSex}"/><!-- 性别 -->
                            <s:hidden name="merchant.merchantGrade" value="%{#session.merchant.merchantGrade}"/><!-- 等级 -->
                            <s:hidden name="merchant.merchantState" value="%{#session.merchant.merchantState}"/><!-- 审核状态 -->
                            <s:hidden name="merchant.merchantIMG" value="%{#session.merchant.merchantIMG}"/><!-- 头像 -->
                            <s:property value="#request.updateTip"/>
                            <fieldset class="col-md-4 col-sm-6">
                            	<p>昵称：</p>
                            	<input type="text" name="merchant.merchantUsername" value="<s:property value="#session.merchant.merchantUsername"/>"/>
                            </fieldset>
                            <fieldset class="col-md-4 col-sm-6">
                            	<p>真实姓名：</p>
                            	<input type="text" name="merchant.merchantName" value="<s:property value="#session.merchant.merchantName"/>" readonly/>
                            </fieldset>
                            <fieldset class="col-md-4 col-sm-6">
                            	<p>身份证号：</p>
                                <input type="text" name="merchant.merchantIDNum" value="<s:property value="#session.merchant.merchantIDNum"/>" readonly/>
                            </fieldset>
                            <fieldset class="col-md-4 col-sm-6">
                            	<p>性别：</p>
                            	<s:if test="#session.merchant.merchantSex==false">
                            		<input type="text" value="女" readonly/>
                            	</s:if>
                            	<s:else>
                            		<input type="text" value="男" readonly/>
                            	</s:else>
                            </fieldset>
                            <fieldset class="col-md-4 col-sm-6">
                            	<p>年龄：</p>
                                <input type="text" name="merchant.merchantAge" value="<s:property value="#session.merchant.merchantAge"/>" readonly/>
                            </fieldset>
                            <fieldset class="col-md-4 col-sm-6">
                            <p>联系方式：</p>
                                <input type="text" name="merchant.merchantID" value="<s:property value="#session.merchant.merchantID"/>"readonly/>
                            </fieldset>
                            <fieldset class="col-md-12 col-sm-12">
                            	<p>个性签名：</p>
                                <textarea name="merchant.merchantSignature" cols="30" rows="6" ><s:property value="#session.merchant.merchantSignature"/></textarea>
                            </fieldset>
                            <fieldset class="col-md-12 col-sm-12">
                                <input type="submit" class="button big default" value="提交修改"/>
                            </fieldset>
                        </form>
                    </div> <!-- .contact-form -->
                    </div>
                    
                    <!-- 接受通知 -->
                    <div class="page-section" id="notice" style="display:none">
						<iframe id="notice" name="notice" src="findNotice" frameborder="0" scrolling="no" height="1100px" width="100%"></iframe>
					</div>
					
                    <div class="row" id="footer">
                    <hr></hr>
                        <div class="col-md-12 text-center">
                            <p class="copyright-text">Copyright &copy; 2016 Clouds Help项目开发小组</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="Merchant/js/vendor/jquery-1.10.2.min.js"></script>
        <script src="Merchant/js/min/plugins.min.js"></script> 
        <script src="Merchant/js/min/main.min.js"></script>

    </body>
</html>