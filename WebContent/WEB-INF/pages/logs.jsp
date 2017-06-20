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
			url : "${prince}/allLogs",
			dtatType : "json",
			success : function(data) {
				if (data.flg == "ok") {
					location.href="${prince}/logs";
				} else {
					$("#error_message").text("查询失败!");
				}
			}

		});
	});
</script>
</head>
<body>
<form action="index.jsp" id="userForm" method="post">
	<div class="alert alert-info">
		当前位置<b class="tip"></b>日志信息<b class="tip"></b>操作日志
	</div>
	<table class="tb" id="top">
		<thead>
			<tr>
				<th>日志ID</th>
				<th>用户名</th>
				<th>操作</th>
				<th>操作时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allLogs }" var="r">
				<tr>
					<td><a>${r.id }</a></td>
					<td>${r.username }</td>
					<td>${r.action }</td>
					<td>${r.actiontime }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	 </form>
</body>
</html>
