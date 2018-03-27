<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>扫描邮袋详情</title>
<%@include file="header.jsp"%>
</head>
<body>

	<div class="container pb_10">
		<div class="row">
			<div id="top" class="col-xs-12 col-md-12 mt_10 md_10">
				<table class="header_table">
					<tr>
						<td><a id="back" class="block fl ml_10" href="javascript:history.go(-1)"><span class="glyphicon glyphicon glyphicon-chevron-left"></span></a></td>
						<td><a id="myInfo" class="block fr mr_10" href="javascript:void(0);"><span class="glyphicon glyphicon-user"></span></a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<div id="content" class="container">
		<div class="row">
			<div class="col-xs-12 col-md-12 center">
				<table class="table table-bordered blank">
					<tr class="hidden">
						<td>邮袋ID</td>
						<td>${responseRsult.data.mailbagId}</td>
					</tr>
					<tr>
						<td>邮袋</td>
						<td>${responseRsult.data.mailbagCode}</td>
					</tr>
					<tr>
						<td>公司</td>
						<td>${responseRsult.data.companyName}</td>
					</tr>
					<tr>
						<td>包裹数</td>
						<td>${responseRsult.data.packageCount}</td>
					</tr>
					<tr>
						<td>重量</td>
						<td>${responseRsult.data.mailbagWeight}kg</td>
					</tr>
				</table>
			</div>
			<c:choose>
				<c:when test="${responseRsult.code eq '0'}">
					<div class="col-xs-12 col-md-12 center">
						<button type="button" onclick="confirmMailbag('${responseRsult.data.mailbagCode}')" class="btn btn-primary">确认揽收</button>
					</div>
				</c:when>
				<c:otherwise>
					<div class="col-xs-12 col-md-12 center">
						<font color="red">${responseRsult.message}</font>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<div id="bottom" class="container pb_10" style="height: 30%"></div>


	<div id="content" class="container">
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div id="successMassge" style="display: none">
					<p class="font_success">包裹揽收成功</p>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	function confirmMailbag(mailbagCode) {
		var mailbag = new Object();
		mailbag.mailbagCode = mailbagCode;
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/mailbag/page/confirmMailbag",
			data : JSON.stringify(mailbag),
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data.success) {
					showSuccessMessage()
				} else {
					alert(data.message);
				}
			}
		});
	}

	function showSuccessMessage() {
		/* $('#successMassge').removeClass("hidden"); */
		$('#successMassge').toggle('slow', 'swing',function(){
			window.location.href = "${pageContext.request.contextPath}/mailbag/page/toReceiveMailbag";
		});
	}
</script>

</html>