<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
	<link rel="stylesheet" href="commonCSS/bootstrap.css" type="text/css" />
	<link rel="stylesheet" href="commonCSS/app.css" type="text/css" />  
	<title>聊天窗口</title>

</head>
<script type="text/javascript">
    
    var xmlHttp = false;
    
    setInterval(create,600);
    function create(){
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
    
        try{
        var groupID=window.parent.document.getElementById("groupid").value;
        var url="chatreceive?groupID="+groupID;
        xmlHttp.onreadystatechange=put;
        xmlHttp.open("GET",url,true);
        xmlHttp.send();
        }catch(failed){
        alert("服务器繁忙");
        }
    }
    function put(){
    if(xmlHttp.readyState==4){
        var xmlDoc=xmlHttp.responseText;
        var data=eval(xmlDoc);
        var i=0;
        if(data!=null){
        var insertText="";
        var userName="${sessionScope.employee.employeeUserName}";
        //alert(userName);
        for (i=0;i<data.length;i++){
        //alert(data[i].messageSender.getString("UTF-8"));
	        if(data[i].messageSender==userName){
	        	insertText+="<article id=\"chat-id-"+i+"\" class=\"chat-item right\" >"+
	                        "<a href=\"#\" class=\"pull-right thumb-sm avatar\"><img src=\""+data[i].senderIMG+"\" alt=\"...\"></a>"+
	                        "<section class=\"chat-body\">"+
	                        "<div class=\"panel bg-light text-sm m-b-none\">"+
	                        "<div class=\"panel-body\">"+
	                        "<span class=\"arrow right\"></span>"+
	                        "<p class=\"m-b-none\" >"+data[i].messageContent+"</p>"+
	                        "</div></div></section></article>";
	        }
	        else{
	        	insertText+="<article id=\"chat-id-"+i+"\" class=\"chat-item left\" >"+
	                        "<a href=\"#\" class=\"pull-left thumb-sm avatar\"><img src=\""+data[i].senderIMG+"\" alt=\"...\"></a>"+
	                        "<section class=\"chat-body\">"+
	                        "<div class=\"panel b-light text-sm m-b-none\">"+
	                        "<div class=\"panel-body\">"+
	                        "<span class=\"arrow left\"></span>"+
	                        "<p class=\"m-b-none\" >"+data[i].messageContent+"</p>"+
	                        "</div></div></section></article>";
	        }
        }
        document.getElementById("insert").innerHTML = insertText;
        scrollTo(0,document.body.scrollHeight);
        }
    }
    }
</script>
<body>
<div class="row" style="font-family: Microsoft JhengHei;">
	<div class="col-lg-12">
		<section class="panel panel-default">
			<header class="panel-heading">团队聊天窗口</header>
			<section id="insert" class="chat-list panel-body" style="min-height:410px">
			</section>
		</section>
	</div>
</div>
</body>
</html>
