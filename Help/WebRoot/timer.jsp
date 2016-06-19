<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="cn.edu.zjut.po.Order"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>任务进行中</title>
	<link rel="stylesheet" href="Employee/css/timerStyle.css" media="screen" type="text/css"/>
	<meta name="viewport" content="width=device-width, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
</head>
<body>
<div id="CountMsg" class="HotDate" style="font-family:SimHei;line-height:2;font-size:20px;color:white">
	<span>距离任务开始还有：</span>
    <span id="t_d">0天</span>
    <span id="t_h">0时</span>
    <span id="t_m">0分</span>
    <span id="t_s">0秒</span>
</div>
<div id="startMission" style="font-family:SimHei;line-height:2;font-size:20px;color:white;display:none">
	<span>任务已经开始，计时器将会记录本次任务的耗时。已经提前完成？点击<a id="sure" href="SubmitOrder">确定</a></span>
</div>
<div id="endMission" style="font-family:SimHei;line-height:2;font-size:20px;color:white;display:none">
	<span>抱歉，您已超时，任务失败了！</span>
</div>
<script type="text/javascript">
setInterval(getRTime,1000);
function getRTime(){//距离任务开始的倒计时
	var EndTime= new Date("<%=((Order)session.getAttribute("order")).getStartTime() %>"); //任务开始时间
	var NowTime = new Date();
	var t =EndTime.getTime() - NowTime.getTime();
	var d=Math.floor(t/1000/60/60/24);
	var h=Math.floor(t/1000/60/60%24);
	var m=Math.floor(t/1000/60%60);
	var s=Math.floor(t/1000%60);
	if(d==0 && h==0 && m==0 && s==0){
		document.getElementById('CountMsg').style.display="none";
		document.getElementById('startMission').style.display="block";
	}
	if(d<0 || h<0 || m<0 || s<0){
	    document.getElementById('haptic2').click();//启动任务计时
		document.getElementById('CountMsg').style.display="none";
		document.getElementById('startMission').style.display="block";
		setInterval(nexttime,1000);
	}
	document.getElementById("t_d").innerHTML = d + "天";
	document.getElementById("t_h").innerHTML = h + "时";
	document.getElementById("t_m").innerHTML = m + "分";
	document.getElementById("t_s").innerHTML = s + "秒";
}
function nexttime(){//距离任务结束的倒计时
	var FinishTime= new Date("<%=((Order)session.getAttribute("order")).getEndTime() %>"); //任务开始时间
	var NowTime = new Date();
	var tt =FinishTime.getTime() - NowTime.getTime();
	var dd=Math.floor(tt/1000/60/60/24);
	var hh=Math.floor(tt/1000/60/60%24);
	var mm=Math.floor(tt/1000/60%60);
	var ss=Math.floor(tt/1000%60);
	if(dd==0 && hh==0 && mm==0 && ss==0){
		document.getElementById('haptic').click();//停止任务计时
		document.getElementById('startMission').style.display="none";
		document.getElementById('endMission').style.display="block";
	}
	if(dd<0 || hh<0 || mm<0 || ss<0){
		clearInterval(timer);
	}
}
</script>

  <h1 style="font-family:SimHei;text-align:center;line-height:4;color:white" >任务计时器</h1>
  <input id="help" class="help" name="controls" type="checkbox" />
  <input id="settings" class="settings" name="controls" type="checkbox" />

  <input id="orange" class="orange"  name="color" type="radio"  />
  <input id="green" class="green"  name="color" type="radio" checked="checked" />

  <div class="stopwatch">

    <input id="start" class="start" name="controls" type="radio" />
    <input id="stop" class="stop" name="controls" type="radio" />
    <input id="reset" class="reset" name="controls" type="radio" />

    <div class="container">
      <div class="arrow_cont">
        <div class="arrow">
        </div>
      </div>

      <div class="digit_contianer">
        <div class="animcont">
          <div class="hours">
            0 1 2 3 4 5 6 7 8 9
          </div>
        </div>
        <div class="animcont">
          <div class="hours">
            0 1 2 3 4 5 6 7 8 9
          </div>
        </div>
        <div class="space">
          :
        </div>

        <div class="animcont">
          <div class="min1">
            0 1 2 3 4 5
          </div>
        </div>
        <div class="animcont">
          <div class="min">
            0 1 2 3 4 5 6 7 8 9
          </div>
        </div>
        <div class="space">
          :
        </div>

        <div class="animcont">
          <div class="sec1">
            0 1 2 3 4 5
          </div>
        </div>
        <div class="animcont">
          <div class="sec">
            0 1 2 3 4 5 6 7 8 9
          </div>
        </div>
        <div class="space">
          :
        </div>

        <div class="animcont">
          <div class="mil0">
            0 1 2 3 4 5 6 7 8 9
          </div>
        </div>
        <div class="animcont">
          <div class="mil1">
            0 1 2 3 4 5 6 7 8 9
          </div>
        </div>
        <div class="animcont">
          <div class="mil">
            0 1 2 3 4 5 6 7 8 9
          </div>
        </div>

      </div>

      <div class="controls">
        <label class="stop_" id="haptic" for="stop" style="display:none">
        </label>
        <label id="haptic2" class="start_" for="start" style="display:none">
        </label>
        <label id="haptic3" class="reset_" for="reset" style="display:none">
        </label>
      </div>
    </div>
  </div>
<div style="text-align:center;clear:both;">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
</div>
</body>
</html>