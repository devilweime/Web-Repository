<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>待揽收的邮袋</title>
<%@include file="header.jsp"%>
</head>
<body>
	<div class="container pb_10">
		<div class="row">
			<div id="top" class="col-xs-12 col-md-12">
				<table class="header_table">
					<tr>
						<td>
							<h4 class="block ml_10">
								<font color="30B2E6">待揽收邮袋</font>
							</h4>
						</td>
						<td><a id="myInfo" class="block fr mr_10" href="javascript:void(0);"><span class="glyphicon glyphicon-user"></span></a></td>
					</tr>
				</table>
			</div>
			<div id="content" class="col-xs-12 col-md-12">
				<ul class="list-unstyled">
					<c:choose>
						<c:when test="${not empty data}">
							<c:forEach items="${data}" var="mailbagDetails">
								<li>
									<table class="table table-bordered blank">
										<tr>
											<td class="hide w_h"><input id="mailbagId" value="${mailbagDetails.mailbagId}"></td>
											<td class="w_h">${mailbagDetails.mailbagCode}</td>
											<td class="w_h">${mailbagDetails.companyName}</td>
										</tr>
										<tr>
											<td class="w_h">包裹数：${mailbagDetails.packageCount}</td>
											<td class="w_h">${mailbagDetails.mailbagWeight}kg</td>
										</tr>
									</table>
								</li>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<li>暂无数据</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
	<footer class="myFooter_wrap">
	<div class="myFooter center">
		<button type="button" class="btn btn-primary" onclick="toReceiveMailbag()">扫码揽收</button>
	</div>
	</footer>
</body>
</html>