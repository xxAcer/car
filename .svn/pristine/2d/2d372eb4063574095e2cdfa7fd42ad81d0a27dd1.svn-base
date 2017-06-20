<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="prince" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title> 
    <link rel="stylesheet" type="text/css" href="${prince}/Styles/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="${prince}/Styles/base.css"/>
    <script type="text/javascript" src="${prince}/Scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${prince}/Scripts/jquery-ui-1.8.22.custom.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${prince}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
    <link rel="stylesheet" type="text/css" href="${prince}/Styles/formui.css"/>
    <script type="text/javascript" src="${prince}/Scripts/tb.js"></script>
			
			<script type="text/javascript">
	$(function(){
		$("#find").click(function(){
			$.ajax({
				type:"post",
				url:"${prince}/addCars",
				data:$("#userForm").serialize(),
				dataType:"json",
				success:function(data){
					if(data.flg=="ok"){
						alert("添加成功");
						location.href="${prince}/form-guide2";
					}else{
						$("#error_message").text("失败!");
					}				
				}
				
			})
		})
	})
</script>
			<script type="text/javascript">
			
			function excle() {
				 var flag=window.confirm("您确定添加吗？");
		    	 
		    	 if(flag){
		    		 //发送请求进行删除
		    		 window.location.href="${prince}/excle1";
		    	 }
			}
			
			function excle1() {
				alert("上传成功可以导入")
		    	 
			}
			</script>
			
			
</head>
<body>
    <div class="alert alert-info">当前位置<b class="tip"></b>添加界面<b class="tip"></b>添加汽车</div>
    <table class="tbform">
        <thead>
            <tr>
                <td colspan="4" class="auto-style2">&nbsp;请填写添加条件 </td>
            </tr>
        </thead>
        <form action="index.jsp" id="userForm" method="post">
        <tbody>

            <tr>
                <td class="tdl">类型</td>
                <td class="detail">
                    <input type="text" name="cartype" class="ipt" />
                </td>
                
            </tr>
            <tr>
                <td class="tdl">颜色</td>
                <td>
                         <input type="text" name="color" class="ipt" />
                </td>
            </tr>
            <tr>
                <td class="tdl">价值 </td>
                <td>
                         <input type="text" name="price" class="ipt" />
                </td>
            </tr>
            <tr>
                <td class="tdl">租金</td>
                <td>
                    <div class="input-append">
                       <input type="text"  name="rentprice" class="ipt" />
                    </div>
                </td>
            </tr>
            <tr>
                <td class="tdl">押金 </td>
                <td>
                         <input type="text" name="deposit" class="ipt" />
                </td>
            </tr>
            <tr>
                <td class="tdl">租用情况</td>
                <td class="detail">
                    <input type="text" value="0" readonly="readonly" name="isrenting" class="ipt" />
                </td>
            </tr>
            <tr>
                <td class="tdl">简介</td>
                <td class="detail">
                    <input type="text" name="description" class="ipt" />
                </td>
                
            </tr>
            <tr>
                <td colspan="6" align="left">
                    <input class="btn" id="find" type="button" value="添加" />
                   </td>
            </tr>
            
        </tbody>
      </form>
      <form action="fileupload" method="post" enctype="multipart/form-data">
            	<td>
            	上传文件:<input type="file" name="file" >
            	</input>
            	</td>
			<td><input type="submit" class="btn btn-mini btn-primary"
							id="btn"  value="上传" />
			 </td>
			 <td><input type="button" class="btn btn-mini btn-primary"
							id="btn" onclick="excle();" value="导入" />
			 </td>
            </form>
    </table>
</body>
</html>
