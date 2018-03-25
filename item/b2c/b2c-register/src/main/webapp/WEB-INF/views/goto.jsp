<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=request.getContextPath()%>/">
<title>跳转页面</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		var i = 5;
		setInterval(function() {
			i--;
			$("#second").html(i);
			if(i==1){
				location.href="http://localhost:8086/b2c-login/login/toLogin";
			}
		},1000)
	})

</script>

</head>
<body>
	<div style="margin:auto 0px;">
		<table style="text-align: center;">
			<tr>
				<td>已发送<font color="red">账号激活邮件</font>到您的邮箱，请注意查收激活账号</td>
			</tr>
			<tr>
				<td><font id="second" color="blue">5</font>秒后自动跳转登录页面...</td>
			</tr>
			<tr>
				<td><a href="http://localhost:8086/b2c-login/login/toLogin">点击马上跳转</a></td>
			</tr>
		</table>
	</div>
</body>
</html>