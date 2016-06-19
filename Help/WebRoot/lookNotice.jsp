<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.zjut.po.Notice" %>

<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" href="Merchant/css/bootstrap.min.css">

<div class="container body-content">
    <div class="row">
			<div class="col-md-12">
			    <table>
				    <tr>
				        <td><h4 class="widget-title" style="font-size: 25px;font-weight: 600;">最新通知</h4></td>
				        <td>
				            <form action="findNotice" method="post">
				                <button type="submit" class="btn btn-sm btn-danger" style="margin-right:10px;margin-left:750px;">点击刷新</button>
				            </form>
				        </td>
				    </tr>
				</table>
			</div>
    </div>
    <br>
    <br>
    <div class="row">
	    <div class="col-md-12">
			<table class="table table-hover table-striped">
				<thead>
					<th>通知内容</th>
					<th>日期</th>
				</thead>
				<s:iterator value="#request.note" status="st">
					<tr>
						<td><s:property value="content" />
						</td>
			
						<td><s:property value="yearr" />年 <s:property value="monthh" />月
							<s:property value="datee" />日</td>
					</tr>
				</s:iterator>
			    
			</table>
		</div>
	</div>
</div>