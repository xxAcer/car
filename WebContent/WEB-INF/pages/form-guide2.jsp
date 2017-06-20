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
<
script type ="text/javascript">.auto-style1 {
	height: 26px;
}
</style>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "${prince}/allCar",
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
	
	$(function(){
		$("a").click(function(){
			$.ajax({
				type:"post",
				url:"${prince}/allCar",
				data:$("#userForm").serialize(),
				dataType:"json",
				success:function(data){
					if(data.flg=="ok"){
						location.href="${sxt}/form-guide2.html";
					}			
				}
				
			})
		})
	})
</script>
<script type="text/JavaScript">
             function removeCar(obj){
            	 
            	 var flag=window.confirm("您确定要删除吗？");
            	 
            	 if(flag){
            		 alert("删除成功");
            		 window.location.href="${prince}/removeCar?carnumber="+obj;
            	 }
             }
function findCarByC(obj){
            	 
            	 var flag=window.confirm("您确定修改吗？");
            	 
            	 if(flag){
            		 //发送请求进行删除
            		 window.location.href="${prince}/findCarByC?carnumber="+obj;
            	 }
             }
		</script>
<script type="text/javascript">
	function change(index,size) {
		document.getElementById("userForm").action="allCar?index="+index+"&size="+size;
		
		document.getElementById("userForm").submit();
		
	}
	
	function excle() {
		 var flag=window.confirm("您确定生成吗？");
    	 
    	 if(flag){
    		 //发送请求进行删除
    		 window.location.href="${prince}/excle";
    	 }
	}
	
	</script>
	
  </head>
<body>
	<form action="download" id="userForm" method="post" enctype="multipart/form-data">
		<div class="alert alert-info">
			当前位置<b class="tip"></b>汽车信息<b class="tip"></b>车
		</div>
		<table class="tb" id="top">
			<thead>
				<tr>
					<th>车号</th>
					<th>型号</th>
					<th>颜色</th>
					<th>价值</th>
					<th>租金</th>
					<th>押金</th>
					<th>简介</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${pageBean.list }" var="pageBean">
				<tr>
					<td><a>${pageBean.carnumber }</a></td>
					<td>${pageBean.cartype }</td>
					<td>${pageBean.color }</td>
					<td>${pageBean.price }</td>
					<td>${pageBean.rentprice }</td>
					<td>${pageBean.deposit }</td>
					<td>${pageBean.description }</td>
						<td><input type="button" class="btn btn-mini btn-primary"
							id="btn" onclick="removeCar(${pageBean.carnumber });" value="删除" />
						<input type="button" class="btn btn-mini btn-primary"
							id="btn" onclick="findCarByC(${pageBean.carnumber });" value="修改" /></td>
				</tr>
			</c:forEach>
			<tr>
			<td><input type="button" class="btn btn-mini btn-primary"
							id="btn" onclick="excle();" value="生成Excel文档" />
			</tr>
			<tr>
			<td><input type="submit" class="btn btn-mini btn-primary"
							id="btn" value="下载Excel文档" />
			</tr>
		<tr class="pager">
			<td  colspan="100"  align="center">    				
    					<a href="allCar?index=1&size=${pageBean.size}">首页 </a>&nbsp;
    					<c:if test="${pageBean.index !=1 }">    						
    								<a href="allCar?index=${pageBean.index-1 }&size=${pageBean.size}">上一页  </a>&nbsp;
    					</c:if>
    					<c:if test="${pageBean.index ==1 }">
    							上一页&nbsp;
    					</c:if>
    					
    					<c:forEach items="${pageBean.numbers }" var="number">
    						<c:if test="${number==pageBean.index }">    						
    							<a href="allCar?index=${number}&size=${pageBean.size}" class="current">${number}</a>&nbsp;
    						</c:if>
    						<c:if test="${number!=pageBean.index }">
    								<a href="allCar?index=${number}&size=${pageBean.size}" class="badge badge-warning">${number}</a>
    						</c:if>
    					</c:forEach>    					
    					   
    					 <c:if test="${pageBean.index != pageBean.totalPageCount }">
    					 	<a href="allCar?index=${pageBean.index+1 }&size=${pageBean.size}">下一页</a>
    					 </c:if>
    					 <c:if test="${pageBean.index == pageBean.totalPageCount }">
    					 	下一页
    					 </c:if>
    					 <a href="allCar?index=${pageBean.totalPageCount }&size=${pageBean.size}"> 末页  </a>&nbsp;    		 			    					 
    					 每页
    					 <select onchange="change(1,this.value)" id="size">
    					 	<c:forEach begin="5" end="30" step="5" var="i">
    					 		<c:if test="${ i== pageBean.size}">
    					 			<option value="${i }" selected="selected">${i }</option>
    					 		</c:if>
    					 		<c:if test="${ i!= pageBean.size}">
    					 			<option value="${i }">${i }</option>
    					 		</c:if>	
    					 	</c:forEach>
    					 </select>
    					 条记录	
    					 共${pageBean.totalCount }条记录
		 </tr>
		</table>
	</form>
</body>
</html>
