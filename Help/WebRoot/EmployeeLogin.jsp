<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>受雇者登录页面</title>
<link href="Employee/css/EmployeeLoginStyle.css" rel="stylesheet" type="text/css" media="all"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<link href="commonCSS/fileinput.css" media="all" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="commonCSS/bootstrap-3.3.5-dist/css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="Employee/css/font-awesome.min.css" type="text/css" />
<!-- <link href='http://fonts.useso.com/css?family=Roboto:500,900italic,900,400italic,100,700italic,300,700,500italic,100italic,300italic,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'> -->
</head>
<body style="font-family: Microsoft JhengHei">
<div class="login">
	<h2></h2>
	<div class="login-top">
		<h1>登录页面</h1>
		<div class="tip">
			<s:property value="#request.tip"/>
			<s:fielderror />
		</div>
		<s:form action="EmployeeLogin" method="post" theme="simple">
			<s:textfield name="employee.employeeID" placeholder="请输入您的学号" />
			<s:password name="employee.employeePassword" placeholder="请输入密码" />
	    <div class="forgot">
	    	<a href="#" data-toggle="modal" data-target="#myModal">扫描人脸登录</a>
	    	<s:submit value="登录" theme="simple"/>
	    </div>
	    </s:form>
	</div>
	<div class="login-bottom-employee">
		<h3>没有账号？&nbsp;<a href="EmployeeRegisterHome.jsp">点此注册</a></h3>
	</div>
</div>	
<div class="copyright">
	<p>Copyright &copy; 2016 Clouds Help项目开发小组</p>
</div>

<form action="EmployeeFace" method="post" enctype="multipart/form-data">
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  
			  <div class="modal-dialog" style="margin: auto;position: absolute;top: 0; left: 0; bottom: 0; right: 0;width:650px;margin-top:150px">  
			    <div class="modal-content">  
			      <div class="modal-header">  
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>  
			        <h4 class="modal-title">人脸识别</h4>  
			      </div>  
			      
			      <div class="modal-body">  
				  	<input id="file-1" class="file" type="file" name="face">
			      </div>  
			      <div class="modal-footer">  
			        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
			        <button type="submit" class="btn btn-primary" >登录</button>  
			      </div>  
			    </div><!-- /.modal-content -->  
			  </div><!-- /.modal-dialog -->  
			</div><!-- /.modal -->
</form>


<script src="commonJS/jquery.min.js" type="text/javascript"></script>
<script src="commonJS/fileinput.js" type="text/javascript"></script>	
<script src="commonJS/fileinput_locale_zh.js" type="text/javascript"></script>
<script src="commonCSS/bootstrap-3.3.5-dist/js/bootstrap.js" type="text/javascript"></script>
<script>
	    $("#file-0").fileinput({
	        'allowedFileExtensions' : ['jpg','jpeg', 'png','gif'],
	        maxFilesNum: 10,
	    });
	    $("#file-1").fileinput({
	        uploadUrl: '#', // you must set a valid URL here else you will get an error
	        allowedFileExtensions : ['jpeg', 'jpg', 'png','gif'],
	        overwriteInitial: false,
	        maxFilesNum: 10,
	        //allowedFileTypes: ['image', 'video', 'flash'],
	        slugCallback: function(filename) {
	            return filename.replace('(', '_').replace(']', '_');
	        }
		});
	    /*
	    $(".file").on('fileselect', function(event, n, l) {
	        alert('File Selected. Name: ' + l + ', Num: ' + n);
	    });
	    */
		$("#file-3").fileinput({
			showUpload: false,
			showCaption: false,
			browseClass: "btn btn-primary btn-lg",
			fileType: "any",
	        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>"
		});
		$("#file-4").fileinput({
			uploadExtraData: {kvId: '10'}
		});
	    $(".btn-warning").on('click', function() {
	        if ($('#file-4').attr('disabled')) {
	            $('#file-4').fileinput('enable');
	        } else {
	            $('#file-4').fileinput('disable');
	        }
	    });    
	    $(".btn-info").on('click', function() {
	        $('#file-4').fileinput('refresh', {previewClass:'bg-info'});
	    });
	    /*
	    $('#file-4').on('fileselectnone', function() {
	        alert('Huh! You selected no files.');
	    });
	    $('#file-4').on('filebrowse', function() {
	        alert('File browse clicked for #file-4');
	    });
	    */
	    $(document).ready(function() {
	        $("#test-upload").fileinput({
	            'showPreview' : false,
	            'allowedFileExtensions' : ['jpg', 'png','gif'],
	            'elErrorContainer': '#errorBlock'
	        });
	        /*
	        $("#test-upload").on('fileloaded', function(event, file, previewId, index) {
	            alert('i = ' + index + ', id = ' + previewId + ', file = ' + file.name);
	        });
	        */
	    });
</script>
</body>
</html>