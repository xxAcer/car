﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 取得到项目的根路径 -->
<c:set var="prince" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link rel="stylesheet" type="text/css"
	href="${prince}/Styles/formui.css" />
<link rel="stylesheet" type="text/css"
	href="${prince}/Styles/admin-all.css" />
<link rel="stylesheet" type="text/css" href="${prince}/Styles/base.css" />
<script type="text/javascript" src="${prince}/Scripts/jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="${prince}/Scripts/jquery-ui-1.8.22.custom.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${prince}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
<style type="text/css">
<script type="text/javascript">
.auto-style1 {
	height: 26px;
}
</style>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "${prince}/allrentorder",
			dtatType : "json",
			success : function(data) {
				if (data.flg == "ok") {
					$('#top').show();
				} else {
					$("#error_message").text("查询失败!");
				}
			}

		});
	});
</script>
<script type="text/JavaScript">
             function rent(obj){
            	 
            	 var flag=window.confirm("您确定要租吗？");
            	 
            	 if(flag){
            		 //发送请求进行删除
            		 window.location.href="${prince}/confirm?tableid="+obj;
            	 }
             }
		</script>
</head>
<body>
<form action="index.jsp" id="userForm" method="post">
	<div class="alert alert-info">
		当前位置<b class="tip"></b>申请租车信息<b class="tip"></b>租车信息
	</div>
	<table class="tb" id="top">
		<thead>
			<tr>
				<th>出租单编号</th>
				<th>预付金</th>
				<th>应付金</th>
				<th>实际交付</th>
				<th>起租日期</th>
				<th>归还日期</th>
				<th>申请状态</th>
				<th>客户号</th>
				<th>车号</th>
				<th>服务人员</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rentorder }" var="r">
				<tr>
					<td><a>${r.tableid }</a></td>
					<td>${r.imprest }</td>
					<td>${r.shouldpayprice }</td>
					<td>${r.price }</td>
					<td>${r.begindate }</td>
					<td>${r.returndate }</td>
					<c:if test="${r.renflag ==0 }">
					<td><font color=red>未通过</font></td>
					</c:if>
					<c:if test="${r.renflag ==1}">
					<td><font color=green>已通过</font></td>
					</c:if>
					<td>${r.cname }</td>
					<td>${r.carid }</td>
					<td>${r.username }</td>
					<c:if test="${r.renflag ==0}">
					<td><input type="button" class="btn btn-mini btn-primary" id="btn" onclick="rent(${r.tableid });" value="确认出租" /></td>
					</c:if>
					<c:if test="${r.renflag ==1}">
					<td><input type="button" class="btn btn-mini btn-primary" id="btn"  value="以租" /></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	 </form>
</body>
</html>
