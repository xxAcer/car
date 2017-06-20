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
<script type="text/javascript">
.auto-style1 {
	height: 26px;
}
</style>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "${prince}/checkAll",
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
<script type="text/javascript">
        $(function () {

            $('#find').click(function () {
                 $.dialog({
                    title: '查询结果',
                    content: 'url:jianchadan.html',
                    lock: true,
					width:650,
					height:450
            			})
            })
        })

    </script>


<script type="text/JavaScript">
             function rent(obj){
            	 
            	 var flag=window.confirm("您确定要租吗？");
            	 
            	 if(flag){
            		 //发送请求进行删除
            		 window.location.href="${prince}/zhuche?carnumber="+obj;
            	 }
             }
		</script>
</head>
<body>
<form action="index.jsp" id="userForm" method="post">
	<div class="alert alert-info">
		当前位置<b class="tip"></b>检查单信息<b class="tip"></b>检查单
	</div>
	<table class="tb" id="top">
		<thead>
			<tr>
				<th>检查单号</th>
				<th>检查时间</th>
				<th>问题</th>
				<th>赔费</th>
				<th>检查员</th>
				<th>出租单编号</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${check }" var="check">
				<tr>
					<td><a>${check.checkid }</a></td>
					<td>${check.checkdate }</td>
					<td>${check.problem }</td>
					<td>${check.paying }</td>
					<td>${check.username }</td>
					<td>${check.rentid }</td>
					<td><input type="button" class="btn btn-mini btn-primary" id="find"<%--  onclick="rent(${check.checkid });" --%> value="删除" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	 </form>
</body>
</html>
