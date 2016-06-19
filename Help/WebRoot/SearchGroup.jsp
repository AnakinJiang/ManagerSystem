<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Employee/css/searchstyle.css" type="text/css" media="screen" title="Test Stylesheet" charset="utf-8" />
<script src="Employee/js/searchjquery.js" type="text/javascript" charset="utf-8"></script>
<script src="Employee/js/searchfcbkcomplete.min.js" type="text/javascript" charset="utf-8"></script>
<link href="Employee/css/searchSuggest.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="Employee/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="Employee/js/searchSuggest.js"></script>
<script>
//Ajax 动态发送请求

function loadXMLDoc(url2,cfunc)//适配浏览器内核
{
	if (window.XMLHttpRequest)
	{// IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp2=new XMLHttpRequest();
	}
	else
	{// IE6, IE5
		xmlhttp2=new ActiveXObject("Microsoft.XMLHTTP");
	}
	var gname = $("#suggest_input").val();//获取文本上的值
	url2=url2+"?gname="+gname
	xmlhttp2.onreadystatechange=cfunc;
	xmlhttp2.open("GET",url2,true);
	xmlhttp2.send();
}

function myFunction()
{

	loadXMLDoc("SearchGroup_get_data.jsp",function()
	{
	  	if (xmlhttp2.readyState==4 && xmlhttp2.status==200)
	    {
	    	document.getElementById("suggest_ul").innerHTML=xmlhttp2.responseText;
	    }
	});
}

function aaa(i)//li点击响应函数
{   
    
    myFunction2(i);
    
}


function myFunction2(i)
{

	loadXMLDoc2(i,"SearchGroup_refresh_data.jsp",function()
	{
	  	if (xmlhttp2.readyState==4 && xmlhttp2.status==200)
	    {
	        need = xmlhttp2.responseText; 
	        
	    	document.getElementById("suggest_input").value=need.substr(5);
	    }
	});
}

function loadXMLDoc2(i,url2,cfunc)//适配浏览器内核
{
	if (window.XMLHttpRequest)
	{// IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp2=new XMLHttpRequest();
	}
	else
	{// IE6, IE5
		xmlhttp2=new ActiveXObject("Microsoft.XMLHTTP");
	}
	var gname = $("#suggest_input").val();//获取文本上的值
	url2=url2+"?place="+i
	xmlhttp2.onreadystatechange=cfunc;
	xmlhttp2.open("GET",url2,true);
	xmlhttp2.send();
}
</script>
</head>


<body id="test" style="font-family: Microsoft JhengHei">   

    <br><br><br><br>
    <h4 align="center"><s:property value="#request.jointip"/></h4>
    <h1 align="center">加入小组</h1>
    <form action="searchGroup" method="post" accept-charset="utf-8">
      <ol>        
        <li id="facebook-list" class="input-text">
           <p style="font-size:15px">请输入关键字进行查询</p>
           <div style="white-space:nowrap;">
              <input type="text" autocomplete="off" size="15" name="group.groupName" onKeyUp="myFunction()" id="suggest_input" >
              <input type="submit" style="width:50px;height:30px;background-color:#f46151; border-color:#f46151;color:#ffffff" value="加入" >
           </div>
              <ul id="suggest_ul">
              </ul>
        </li>
      </ol>   
    </form>
   </body>
</html>
			