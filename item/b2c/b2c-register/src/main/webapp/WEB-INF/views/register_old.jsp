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
<script src="${pageContext.request.contextPath}/js\bootstrap\css\bootstrap.min.css"></script>
<script type="text/javascript">
	$(function () {
		$("#reg_form").submit(function() {
			if($.trim($("#password").val())!=$.trim($("#confirm").val())){
				alert("两次密码不相同");
				return false;
			}
		})
	})

</script>

</head>
<body>
	<div class="container">
		<form class="form-signin" method="post" action="${pageContext.request.contextPath}/register/register" id="reg_form">
			<h3 class="form-signin-heading">用户注册</h3>
			<label for="inputEmail" class="sr-only">Email address</label> 
			<input type="text"  class="form-control" placeholder="用户名" name="username" required autofocus> 
			<label for="inputPassword" class="sr-only">Password</label> 
			<input type="password"  class="form-control" placeholder="密码" name="password" id="password" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label> 
			<input type="password"  class="form-control" placeholder="确认密码" name= "confirm" id="confirm" required>
			<label for="inputEmail" class="sr-only">Email address</label> 
			<input type="text"  class="form-control" placeholder="邮箱" name="email" required autofocus> 
			<br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
		</form>
	</div>
	<!-- /container -->
</body>
</html>