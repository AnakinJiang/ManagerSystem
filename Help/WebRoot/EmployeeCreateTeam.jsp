<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="cn.edu.zjut.po.Employee"%>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
<meta charset="utf-8" />
<title></title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="commonCSS/app.css" type="text/css" /> 
<link rel="stylesheet" href="commonCSS/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="commonJS/slider/slider.css" type="text/css" />
<link rel="stylesheet" href="commonJS/chosen/chosen.css" type="text/css" />
</head>
<body class="" style="font-family: Microsoft JhengHei">

<section class="vbox" style="margin-top:120px">
    <section>
      <section class="hbox stretch">
        <section id="content">
          <section class="vbox">
            <section class="scrollable padder">
              <section class="panel panel-default">
                <header class="panel-heading font-bold">
                 	创建队伍
                </header>
                <div class="panel-body">
                  <form class="form-horizontal" action="employeeCreateTeam" method="post">
                    <div class="form-group">
                      <label class="col-sm-2 control-label">队伍名</label>
                      <div class="col-sm-6">
                      	<input type="text" name="igroup.groupName" class="form-control"/>                    
                      	<input type="text" name="igroup.moneyPool" value=0 class="form-control" style="display:none"/>
                      	<input type="text" name="igroup.poolFull" value=500 class="form-control" style="display:none"/>
                      	<input type="text" name="igroup.rate" value=1.1 class="form-control" style="display:none"/>
                      </div>
                    </div>
                    <div class="line line-dashed b-b line-lg pull-in"></div>
                    <div class="form-group">
                      <label class="col-sm-2 control-label">队伍宣言</label>
                      <div class="col-sm-6">
                      	<input type="text" name="igroup.groupDescribe" class="form-control"/>                    
                      </div>
                    </div>
                    <div class="line line-dashed b-b line-lg pull-in"></div>
                    <div class="form-group">
                      <label class="col-sm-2 control-label">队伍标签</label>
                      <div class="col-sm-10">
                        <select style="width:260px" multiple class="chosen-select">
                          <option value="hl">活力</option>
                          <option value="rq">热情</option>
                          <option value="zpy">朋友</option>
                          <option value="jr">家人</option>
                          <option value="tx">同学</option>
                          <option value="kl">快乐</option>
                        </select>
                      </div>
                    </div>
                    <div class="form-group">
                    <br>
	                    <div class="col-sm-4 col-sm-offset-2">
	                        <button type="reset" class="btn btn-default">重置</button>
	                        <button type="submit" class="btn btn-primary" style="background-color:#f46151;border-color:#f46151">创建</button>
	                    </div>
                    </div>
                    
                  </form>
                </div>
              </section>
            </section>
          </section>
        </section>
      </section>
    </section>    
  </section>
  <script src="commonJS/jquery.min.js"></script>
  <!-- Bootstrap -->
  <script src="commonJS/bootstrap.js"></script>
  <!-- App -->
  <script src="commonJS/app.js"></script>  
  <script src="commonJS/slimscroll/jquery.slimscroll.min.js"></script>
  <!-- datepicker -->
  <script src="commonJS/datepicker/bootstrap-datepicker.js"></script>
  <!-- slider -->
  <script src="commonJS/slider/bootstrap-slider.js"></script>
  <!-- markdown -->
  <script src="commonJS/markdown/epiceditor.min.js"></script>
  <script src="commonJS/markdown/demo.js"></script>

  <script src="commonJS/chosen/chosen.jquery.min.js"></script>
  <script src="commonJS/app.plugin.js"></script>
  <script type="text/javascript" src="commonJS/jPlayer/jquery.jplayer.min.js"></script>
  <script type="text/javascript" src="commonJS/jPlayer/add-on/jplayer.playlist.min.js"></script>
  <script type="text/javascript" src="commonJS/jPlayer/demo.js"></script>

</body>
</html>
