<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="shop_bd_list_content clearfix">
				<ul>
					<c:forEach items="${page.list}" var="pro">
					<li>
						<dl>
							<dt><a href="http://localhost:8083/b2c-detail/product/${pro.id}.html"><img src="${pro.images}" /></a></dt>
							<dd class="title"><a href="http://localhost:8083/b2c-detail/product/${pro.id}.html">${pro.name}</a>&nbsp;&nbsp;<span>${pro.salePoint}</span></dd>
							
							<dd class="content">
								<span class="goods_jiage">￥<strong>${pro.price}</strong></span>
								<span class="goods_chengjiao">最近成交5笔</span>
							</dd>
						</dl>
					</li>
					</c:forEach>
				</ul>
			</div>
			<div class="clear"></div>
			<div class="pagination"> 
			<small>当前第${page.currentPage}页，共有${page.totalCount}记录，共${page.totalPage}页</small>
				<ul>
					<li><span><a index="1" href="search/queryByMain/1?mainSearch=${mainSearch}">首页</a></span></li>
						<c:if test="${page.currentPage!=1}">
							<li><span><a index="${page.currentPage-1}" href="search/queryByMain/${page.currentPage-1}?mainSearch=${mainSearch}">上一页</a></span></li>
						</c:if>
						<c:forEach items="${page.navigatepageNums}" var="num">
							<c:choose>
								<c:when test="${page.currentPage==num}">
									<li><span class="currentpage"><a index="${num}" href="search/queryByMain/${num}?mainSearch=${mainSearch}">${num}</a></span></li>
								</c:when>
								<c:otherwise>
									<li><span><a index="${num}" href="search/queryByMain/${num}?mainSearch=${mainSearch}">${num}</a></span></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${page.currentPage!=page.totalPage}">
							<li><span><a index="${page.currentPage+1}" href="search/queryByMain/${page.currentPage+1}?mainSearch=${mainSearch}">下一页</a></span></li>
						</c:if>
							<li><span><a index="${page.totalPage}" href="search/queryByMain/${page.totalPage}?mainSearch=${mainSearch}">尾页</a>
							</span>
					</li>
				</ul> 
			</div>
</body>
</html>