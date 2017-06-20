<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<
script type ="text/javascript">.auto-style1 {
	height: 26px;
}
</style>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "${prince}/find",
			dtatType : "json",
			success : function(data) {
				if (data.flg == "ok") {
					
				} else {
					$("#error_message").text("查询失败!");
				}
			}

		});
	});
</script>
<script type="text/JavaScript">
             function deleteUser(obj){
            	 
            	 var flag=window.confirm("您确定要删除吗？");
            	 
            	 if(flag){
            		 //发送请求进行删除
            		 window.location.href="${prince}/removeUser?username="+obj;
            	 }
             }
 function findUserByName(obj){
            	 
            	 var flag=window.confirm("您确定要修改吗？？");
            	 
            	 if(flag){
            		 //发送请求进行删除
            		 window.location.href="${prince}/findUserByName?username="+obj;
            	 }
             }
	 function findCuByName(obj){
	 
		 var flag=window.confirm("您确定要修改吗？");
	 
		 if(flag){
		 //发送请求进行删除
			 window.location.href="${prince}/findCuByName?cname="+obj;
		 }
 	}
 function deleteCu(obj){
	 
	 var flag=window.confirm("您确定要删除吗？");
	 
	 if(flag){
		 //发送请求进行删除
		 window.location.href="${prince}/removeCu?cname="+obj;
	 }
 }
		</script>
</head>
<body>
	<div class="alert alert-info">
		当前位置<b class="tip"></b>查询界面<b class="tip"></b>查询用户
	</div>
	<table class="tb" id="list">
		<tbody>
			<tr>
				<th>登录人</th>
				<th>身份证</th>
				<th>姓名</th>
				<th>性别</th>
				<th>地址</th>
				<th>联系电话</th>
				<th>密码</th>
				<th>职位</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${list }" var="list">
				<tr>
					<td><a>${list.username }</a></td>
					<td>${list.identity }</td>
					<td>${list.fullname }</td>
					<td>${list.sex }</td>
					<td>${list.address }</td>
					<td>${list.phone }</td>
					<td>${list.password }</td>
					<c:if test="${list.roleid==1 }">
						<td>BOSS</td>
					</c:if>
					<c:if test="${list.roleid==2 }">
						<td>检车员</td>
					</c:if>
					<td><input type="button" class="btn btn-mini btn-primary"
							id="btn" onclick="deleteUser(${list.username });" value="删除" />
						<input type="button" class="btn btn-mini btn-primary"
							id="btn" onclick="findUserByName(${list.username });" value="修改" /></td>
				</tr>
			</c:forEach>
			<c:forEach items="${list1 }" var="list1">
				<tr>
					<td><a>${list1.cname }</a></td>
					<td>${list1.id}</td>
					<td>${list1.custname }</td>
					<td>${list1.sex }</td>
					<td>${list1.address }</td>
					<td>${list1.phone }</td>
					<td>${list1.cpwd }</td>
					<c:if test="${list1.roleid==3 }">
						<td>客户</td>
					</c:if>
					<td colspan="6">
					<input class="btn btn-mini btn-primary"id="btn" type="button" onclick="deleteCu(${list1.cname });" value=" 删除" />
						<input class="btn btn-mini btn-primary" id="btn" type=button
						onclick="updateCu(${list1.cname });" value=" 修改" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
