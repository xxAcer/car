﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 取得到项目的根路径 -->
<c:set var="prince" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${prince}/Styles/formui.css" />
    <link rel="stylesheet" type="text/css" href="${prince}/Styles/base.css"/>
    <link rel="stylesheet" type="text/css" href="${prince}/Styles/admin-all.css" />
    <script type="text/javascript" src="${prince}/Scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${prince}/Scripts/jquery-ui-1.8.22.custom.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${prince}/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
    <script type="text/javascript" src="${prince}/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
        $(function () {
            var _this = $('.list').find('thead');
            //折叠
            _this.click(function () {
                var i = $(this).find('i');
                if (i.attr('class') == 'tip-down') { i.attr('class', 'tip-up') } else { i.attr('class', 'tip-down') }
                $(this).parent().find('tbody').toggle();
            })
            //添加
            var _html = '<tr>' + _this.parent().find('.demo').html() + '</tr>';
            $('.add').click(function () {
                $(this).parents('.list').find('tbody').append(_html);

            })
            //删除
            $('.del').live('click',function () {
                var _tr = $(this).parents('tr');
                // alert(_tr.attr('class'))
                if (_tr.attr('class') != "demo") {
                    if (confirm("你确定要干掉这条数据吗？")) { _tr.remove(); }
                }
            })
        })
    </script>
    <script type="text/javascript">
	function change() {
		alert("申请还车成功，请等待检查");
		
	}
	
	</script>
</head>
<body>
    <div class="alert alert-info">当前位置<b class="tip"></b>还车界面<b class="tip"></b>还车</div>

    <table class="tbform list">
       <form action="huanche" id="userForm" method="post">
      
        <tbody>
            <tr>
                <td>出租车编号</td>
                <td><input type="text" name="tableid" class="ipt" /></td>
                </tr>
                 <tr>
                <td>车牌号</td>
                <td><input type="text" name="carnumber" class="ipt" /></td>
                </tr>
                <tr>
                <td>客户号</td>
                 <td><input type="text" readonly="readonly" value="${customers.cname }" name="cname" class="ipt" /></td>
                 </tr>
                <tr>
                <td>&nbsp;操作</td>
                <td colspan="6"> <input class="btn btn-mini btn-primary" id="btn" type="submit" onclick="change();" value="申请还车" /></td>
            </tr>
               
        </tbody>
         </form>
    </table>
</body>
</html>
