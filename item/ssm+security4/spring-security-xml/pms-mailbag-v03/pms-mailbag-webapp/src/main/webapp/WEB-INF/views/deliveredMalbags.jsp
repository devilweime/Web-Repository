<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@include file="header.jsp"%>
<ul class="list-group my-list-group">
	<c:choose>
		<c:when test="${responseResult.code eq '0'}">
			<c:choose>
				<c:when test="${empty responseResult.data or  fn:length(responseResult.data)==0}">
					<li class="list-group-item">暂无数据</li>
				</c:when>
				<c:otherwise>
					<c:forEach items="${responseResult.data}" var="mailbag">
						<li class="list-group-item" onclick="getMailbagDetails('${mailbag.mailbagId}')">
							<div class="row">
								<div class="col-xs-6 col-md-6 hidden">${mailbag.mailbagId}</div>
								<div class="col-xs-6 col-md-6">${mailbag.mailbagCode}</div>
								<div class="col-xs-6 col-md-6">${mailbag.companyName}</div>
							</div>
						</li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<li class="list-group-item">${responseResult.message}</li>
		</c:otherwise>
	</c:choose>
</ul>
