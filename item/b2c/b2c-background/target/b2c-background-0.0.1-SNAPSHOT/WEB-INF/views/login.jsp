<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	 <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js\bootstrap\css\bootstrap.min.css">
	 <!-- jquery -->
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js\jquery-1.9.1.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="${pageContext.request.contextPath}/js\bootstrap\css\bootstrap.min.css"></script>

</head>
<body>
	<div class="container">

		<form class="form-signin" action="${pageContext.request.contextPath}/user/login" method="post">
			<h2 class="form-signin-heading">后台管理</h2>
			<label for="inputEmail" class="sr-only">Email address</label> 
			<input type="text" id="inputEmail" class="form-control" name="username" placeholder="用户名" required autofocus> 
			<label for="inputPassword" class="sr-only" name="password">Password</label> 
			<input type="password" id="inputPassword" class="form-control" name="password" placeholder="密码" required>${msg}
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>



	</div>
	<!-- /container -->
</body>
</html>