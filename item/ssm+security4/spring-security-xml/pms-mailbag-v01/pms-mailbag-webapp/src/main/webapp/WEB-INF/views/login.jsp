<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<title>登录</title>
<%@include file="header.jsp"%>
</head>

<body class="body_signin">

	<div class="container">
		<form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="username" class="sr-only">用户名</label> 
			<input type="text" id="username" name="username" class="form-control" placeholder="用户名" required autofocus> 
			<label for="password" class="sr-only">密码</label> 
			<input type="password" id="password" name="password" class="form-control" placeholder="密码" required>
			<c:if test="${not empty error}">
				<p class="signin_error">用户名或密码错误</p>
			</c:if>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>
	</div>
</body>
</html>
