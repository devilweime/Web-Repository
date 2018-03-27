<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<%@include file="header.jsp"%>
</head>
<body>

	<div id="top" class="container pb_10">
		<div class="row">
			<div class="col-xs-12 col-md-12 mt_10 md_10">
				<table class="header_table">
					<tr>
						<td><a id="back" class="block fl ml_10" href="javascript:history.go(-1)"><span class="glyphicon glyphicon glyphicon-chevron-left"></span></a></td>
					</tr>
				</table>
			</div>

			<div class="col-xs-12 col-md-12 mt_10 md_10">
				<form id="passwordForm" class="form-horizontal">
					<div class="form-group">
						<label for="oldPassword" class="col-sm-2 control-label">原密码</label>
						<div class="col-sm-10 ">
							<input type="password" name="oldPassword" class="form-control" id="oldPassword" placeholder="原密码">
						</div>
					</div>
					<div class="form-group">
						<label for="newPassword" class="col-sm-2 control-label">新密码</label>
						<div class="col-sm-10">
							<input type="password" name="newPassword" onblur="vidatePass()" class="form-control" id="newPassword" placeholder="新密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmPassword" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-10">
							<input type="password" name="confirmPassword" onblur="confirmPass()" class="form-control" id="confirmPassword" placeholder="确认密码">
						</div>
					</div>
					<div class="form-group">
						<div>
							<button type="button" onclick="modifyPassword()" class="btn btn-primary center-block">确认提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">

	function modifyPassword() {
		var isVidatePass = vidatePass();
		var isconfirmPass = confirmPass();

		var param = $("#passwordForm").serializeJson();
		if (isVidatePass && isconfirmPass) {
			$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/mailbag/page/modifyPassword",
				data : JSON.stringify(param),
				contentType : "application/json;charset=utf-8",
				success : function(data) {
					if (data.success) {
						alert("密码修改成功");
						window.location.href = "${pageContext.request.contextPath}/login";
					} else {
						alert(data.message);
					}
				}
			});
		}
	}

	function vidatePass() {
		var strLength = $("#newPassword").val().length;
		if (strLength<6 || strLength>12) {
			alert("密码长度在6-12位!");
			return false;
		}
		return true;
	}

	function confirmPass() {
		var newPassword = $("#newPassword").val();
		var confirmPassword = $("#confirmPassword").val();
		if (confirmPassword == "") {
			vidatePass()
		}
		if (newPassword != confirmPassword) {
			alert("两次输入的密码不相同！");
			return false;
		}
		return true;
	}
</script>

</html>