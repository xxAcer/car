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
<link rel="stylesheet" type="text/css" href="${prince}/Styles/base.css" />
<link rel="stylesheet" type="text/css"
	href="${prince}/Styles/admin-all.css" />
<script type="text/javascript" src="${prince}/Scripts/jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="${prince}/Scripts/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript"
	src="${prince}/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="${prince}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
<script src="${prince}/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		$.ajax({
			type:"post",
			url:"${prince}/rentorder",
			data:$("#userForm").serialize(),
			dataType:"json",
			success:function(data){
				if(data.flg=="ok"){
					location.href="${prince}/shenqingzuche.html";
				}else{
					alert("租车失败，请刷新页面");
					$("#error_message").text("失败!");
				}				
			}
			
		})
	})
})
</script>

</head>
<body>
	<div class="alert alert-info">
		当前位置<b class="tip"></b>租车界面<b class="tip"></b>租车
	</div>

		<form action="rentorder" id="userForm" method="post">
	<table class="tbform list">
		<tbody>
			<tr>
				<td class="tdl">预付金</td>
				<td><input type="text" readonly="readonly"
					value="${carbyid.deposit+carbyid.rentprice }" name="imprest"
					class="ipt" /></td>
				<td class="tdl">应付金</td>
				<td><input type="text" readonly="readonly"
					value="${carbyid.deposit+carbyid.rentprice }" name="shouldpayprice"
					class="ipt" /></td>
			</tr>
			<tr>
				<td class="tdl">实际交付金额</td>
				<td><input type="text" name="price" class="ipt" /></td>
				<td class="tdl">起租日期</td>
				<td><input type="text" onfocus="WdatePicker();"
					name="begindate" class="ipt" /></td>
				<td class="tdl">归还日期</td>
				<td><input type="text" onfocus="WdatePicker();"
					name="returndate" class="ipt" /></td>
			</tr>
			<tr>
				<td class="tdl">客户号</td>
				<td><input type="text" readonly="readonly"
					value="${customers.cname }" name="cname" class="ipt" /></td>
				<td class="tdl">服务人员</td>
				<td><input type="text" readonly="readonly"
					value="admin" name="username" class="ipt" /></td>
				<td class="tdl">车号</td>
				<td><input type="text" readonly="readonly"
					value="${carbyid.carnumber }" name="carid" class="ipt" /></td>
				<td class="tdl">&nbsp;操作</td>
				<td colspan="6"><input class="btn btn-mini btn-primary" id="btn" type="button" value="申请租车" /></td>
			</tr>
		</tbody>
	</table>
	</tbody>
	</table>
	</form>
</body>
</html>
