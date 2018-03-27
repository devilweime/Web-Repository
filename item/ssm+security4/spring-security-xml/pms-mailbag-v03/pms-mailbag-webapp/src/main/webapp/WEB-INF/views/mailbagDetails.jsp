<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邮袋详情</title>
<%@include file="header.jsp"%>
</head>
<body>

	<div id="top" class="container pb_10">
		<div class="row">
			<div class="col-xs-12 col-md-12 mt_10 md_10">
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
				<c:choose>
					<c:when test="${responseResult.code eq '0'}">
						<table class="table table-bordered blank">
							<tr>
								<td>邮袋</td>
								<td>${responseResult.data.mailbagCode}</td>
							</tr>
							<tr>
								<td>公司</td>
								<td>${responseResult.data.companyName}</td>
							</tr>
							<tr>
								<td>包裹数</td>
								<td>${responseResult.data.packageCount}</td>
							</tr>
							<tr>
								<td>重量</td>
								<td>${responseResult.data.mailbagWeight}kg</td>
							</tr>
							<tr>
								<td>装袋时间</td>
								<td>${responseResult.data.bagTime}</td>
							</tr>
							<tr>
								<td>揽收时间</td>
								<td>${responseResult.data.receiveTime}</td>
							</tr>
							<tr>
								<td>交付时间</td>
								<td>${responseResult.data.deliverTime}</td>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
						${responseResult.message}
					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</div>

</body>
</html>