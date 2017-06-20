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

    <script  type="text/javascript">
			$(function() {
				$.ajax({
					url : "${prince}/updateUser",
					dtatType : "json",
					success : function(data) {
						var json = JSON.parse(data);
						console.info(json);
						for (var i = 0; i < json.length; i++) {
							var p = json[i];
							$("#roomId").append(
									"<option value='"+p.code+"'>" + p.name
											+ "</option>");

						}

					}

				});
			});
			</script>
			
			<script type="text/javascript">
	$(function(){
		$("#find").click(function(){
			$.ajax({
				type:"post",
				url:"${prince}/add",
				data:$("#userForm").serialize(),
				dataType:"json",
				success:function(data){
					if(data.flg=="ok"){
						alert("添加成功")
						location.href="${prince}/find-form";
					}else{
						$("#error_message").text("失败!");
					}				
				}
				
			})
		})
	})
</script>
			
			
			
</head>
<body>
    <div class="alert alert-info">当前位置<b class="tip"></b>查询界面<b class="tip"></b>添加用户</div>
    <table class="tbform">
        <thead>
            <tr>
                <td colspan="4" class="auto-style2">&nbsp;请填写添加条件 </td>
            </tr>
        </thead>
        <form action="index.jsp" id="userForm" method="post">
        <tbody>

            <tr>
                <td class="tdl">登录名</td>
                <td class="detail">
                    <input type="text" value="userByNmae.username" name="username" class="ipt" />
                </td>
                
            </tr>
            <tr>
                <td class="tdl">密码</td>
                <td>
                         <input type="text" value="userByNmae.password" name="password" class="ipt" />
                </td>
            </tr>
            <tr>
                <td class="tdl">身份证 </td>
                <td>
                         <input type="text" value="userByNmae.identity" name="identity" class="ipt" />
                </td>
            </tr>
            <tr>
                <td class="tdl">姓名</td>
                <td>
                    <div class="input-append">
                       <input type="text" value="userByNmae.fullname"  name="fullname" class="ipt" />
                    </div>
                </td>
            </tr>
            <tr>
                <td class="tdl">性别 </td>
                <td>
                         <input type="text" value="userByNmae.sex" name="sex" class="ipt" />
                </td>
            </tr>
            <tr>
                <td class="tdl">地址</td>
                <td class="detail">
                    <input type="text" value="userByNmae.address" name="address" class="ipt" />
                </td>
            </tr>
            <tr>
                <td class="tdl">联系电话</td>
                <td class="detail">
                    <input type="text" value="userByNmae.phone" name="phone" class="ipt" />
                </td>
                
            </tr>
            <td class="tdl">角色</td>
                <td>
                    <select class="ipt" name="roleid" id="roomId">
                        <option value="-1" selected="selected">请选择</option>
                    </select>
                </td>
            <tr>
             <tr>
                <td class="tdl">职位/职业</td>
                <td class="detail">
                    <input type="text" value="userByNmae.position" name="position" class="ipt" />
                </td>
                
            </tr>
                <td colspan="6" align="left">
                    <input class="btn"  id="find" type="button" value="修改" />
            </tr>
        </tbody>
      </form>
    </table>
</body>
</html>
