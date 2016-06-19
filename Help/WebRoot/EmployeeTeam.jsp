<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="cn.edu.zjut.po.Employee"%>
<%@ page import="cn.edu.zjut.po.Igroup"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
     <title></title>
     <meta charset="utf-8"/>
     <meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
     <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
        
        <link rel="stylesheet" href="Employee/css/bootstrap.min.css" type="text/css" />
		<link rel="stylesheet" href="commonCSS/appNobg.css" type="text/css" />
        
        <link rel="stylesheet" href="Employee/css/normalize.css"/>
        <link rel="stylesheet" href="Employee/css/font-awesome.css"/>
        <link rel="stylesheet" href="Employee/css/templatemo-style.css"/>
        <link rel="stylesheet" href="Employee/css/menuList.css"/>
        <link rel="stylesheet" href="Employee/css/chinaz.css"/>
        <script src="commonJS/jquery.min.js"></script>
		<script src="Employee/js/chinaz.js"></script>
        <script src="Employee/js/vendor/modernizr-2.6.2.min.js"></script> 
	    <!-- Bootstrap -->
	    <script src="commonJS/bootstrap.js"></script>
	    <script src="commonJS/app.js"></script>
<!-- send message -->
<script type="text/javascript">
  function createRequest(url){
    var xmlHttp = false;
    try {
    xmlHttp = new XMLHttpRequest();
    } catch (trymicrosoft) {
        try {
        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (othermicrosoft) {
            try {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (failed) {
                xmlHttp = false;
            }
        }
    }

    if (!xmlHttp || xmlHttp==false)
    alert("Error initializing XMLHttpRequest!");
    else {
    xmlHttp.open("GET", url, true);
    xmlHttp.onreadystatechange=processRequest;
    xmlHttp.send(null);
    }
  } 
   function processRequest() {
         if (http_request.readyState == 4) {
             if (http_request.status == 200) {
             } else {
                 alert("服务器繁忙，信息发送失败");
             }
         }
     }
  function callserver(){
      var content=document.getElementById("cid").value;
      if(content==""||content==null){
          alert("输入信息不能为空")
      }
      else {
      var groupID=document.getElementById("groupid").value;
      content=window.encodeURI(content);
      content=window.encodeURI(content);
      var url="chatsend?content="+content+"&groupID="+groupID;
      createRequest(url);
      document.getElementById("cid").value="";
      }
  }
  function dosend(e){
  if(e.keyCode==13){
  callserver();
  }
  }
</script>
</head>
<body class="" style="font-family: Microsoft JhengHei;background-color:#fff">
	<div class="row">
		<div class="col-md-12"><a href="employeeExitTeam" class="pull-right btn btn-s-md btn-danger btn-rounded" style="margin-top:30px;">退出团队</a>
			<h4 class="widget-title" style="font-size: 25px;margin-top:30px;font-weight: 600;margin-bottom:30px">我的团队
			</h4>
			
		</div>
	</div>

	<div>
		<h5 class="widget-title" style="font-size: 16px;margin-bottom:18px">
			队伍名：<s:property value="#session.igroup.groupName"/>&nbsp;&nbsp;
			<a class="btn btn-danger btn-xs" style="display:inline">
			<%
				Igroup igroup = (Igroup)session.getAttribute("igroup");
				Double rate = igroup.getRate();
				rate = (rate -1)*100;
				String rate_text = rate.toString().substring(0, 2)+"%";
				Double poolPercent = igroup.getMoneyPool();
				String poolPercent_text = Double.toString(100*poolPercent/igroup.getPoolFull())+"%";
				System.out.println("percent="+poolPercent_text);
			 %>
			报酬加成&nbsp;<%=rate_text %>
			
			</a>
		</h5>
		共享池余量：<a href="#" data-toggle="modal" data-target="#donate" class="btn btn-warning btn-xs" style="display:inline">+&nbsp;捐献</a>
		<div class="progress progress-sm progress-striped active" style="margin-top:12px">
			<div class="progress-bar bg-danger" data-toggle="tooltip" data-original-title="<%=poolPercent_text %>" style="width: <%=poolPercent_text %>"></div>
		</div>
		
		<table>
		<tr><td class="widget-title" style="font-size: 15px;font-weight: 600;padding-bottom:10px">成员<br></td></tr>
		<tr>
			<s:iterator value="#session.teamMemberList">
				<td>&nbsp;&nbsp;<a class="pull-left thumb-sm avatar" ><img src='<s:property value="employeeIMG"/>' class="img-circle" alt="..."></a><br><br><s:property value="employeeName"/>&nbsp;&nbsp;</td>
			</s:iterator>
		</tr>
		</table>
	</div>
	<br>
	<div>
	    <p><input type="hidden"  id="groupid" name="chatgroup" value="${sessionScope.groupID}" /></p>
	    <iframe id="content" src="messageWindow.jsp" height="500px" width="100%"></iframe>
	    <footer class="panel-footer">
		<!-- chat form -->
		<article class="chat-item" id="chat-form">
			<a class="pull-left thumb-sm avatar"><img src='<s:property value="#session.employee.employeeIMG"/>' class="img-circle" alt="..."></a>
			<section class="chat-body">
			<form class="m-b-none">
				<div class="input-group">
					<input type="text" name="content" onkeydown="dosend(event)" id="cid" class="form-control" placeholder="Say something">
					<span class="input-group-btn">
						<input class="btn btn-default" type="button" name="call" value="发送" onClick="callserver()" />
					</span>
				</div>
			</form>
			</section>
		</article>
		</footer>
    </div>
    
    		<!-- 模态框 -->
			<div class="modal fade" id="donate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  
			  <div class="modal-dialog">  
			  	<form class="form-horizontal" action="donate" method="post">
			  	<%
					session.setAttribute("myGroup", igroup);
			  	 %>
			    <div class="modal-content">  
			      <div class="modal-header">  
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>  
			        <h4 class="modal-title">共享池捐献</h4>  
			      </div>  
			      <div class="modal-body">  
                    <div class="form-group">
                      <label class="col-sm-2 control-label">捐献金额</label>
                      <div class="col-sm-6">
                      	<input type="text" name="igroup.tmpMoney" class="form-control"/>
                      </div>
                    </div>
			      </div>  
			      <div class="modal-footer">  
			        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
			        <button type="submit" class="btn btn-primary" >确认捐献</button>  
			      </div>  
			    </div><!-- /.modal-content -->  
			    </form>
			  </div><!-- /.modal-dialog -->  
			</div><!-- /.modal -->
</body>
</html>