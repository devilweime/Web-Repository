<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息列表</title>
<link href="${pageContext.request.contextPath}/css/signin.css"
	rel="stylesheet">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js\bootstrap\css\bootstrap.min.css">
<!-- jquery -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js\jquery-1.9.1.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="${pageContext.request.contextPath}/js\bootstrap\js\bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$("#add_id").click(function() {
			$('#myModal').modal({
				backdrop:'static',
				
			});
			$.ajax({
				type:'get',
			  url: "<%=request.getContextPath()%>/page/addProduct",
			  success: function(html){
			   $("#add_content").html(html) 
			  
			  }
			});
		});
		
		/* 复选框 */
		$("#delBatch_id").click(function() {
			var ids="";
			$("input:checked").each(function() {
				ids += $(this).val()+",";
			})
			location.href='${pageContext.request.contextPath}/product/delBatch/'+ids;
		})
		/* 多个按钮 */
		$("button[btn_id]").on("click", function(){
			if($(this).text()=='修改'){
				/* alert('修改'+$(this).attr('btn_id')); */
				$('#myModal').modal({
					backdrop:'static',
					
				});
				$.ajax({
					type:'get',
				  url: "<%=request.getContextPath()%>/product/toUpdateProduct/"+$(this).attr('btn_id'),
				  success: function(html){
				   $("#add_content").html(html) 
				  
				  }
				});
				debugger;
			}
			if($(this).text()=='删除'){
				/* alert('删除'+$(this).attr('btn_id')); */
				location.href='${pageContext.request.contextPath}/product/delById/'+$(this).attr('btn_id');
				
			}
		});
	})
</script>

</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<span><strong style="font-size: 22px;">后台管理</strong></span><span>
					---> 商品信息管理</span>
			</div>
		</div>
		<div class="row ">
			<div class="col-md-2 col-md-offset-10">
				<button type="button" class="btn btn-primary" id="add_id">添加</button>
				<button type="button" class="btn btn-danger" id="delBatch_id">批量删除</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
				
					<thead class="navbar navbar-default">
						<tr>
							<td>ID</td>
							<td>商品类别</td>
							<td>商品名称</td>
							<td>商品价格</td>
							<td>商品卖点</td>
							<td>商品图片</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pageInfo.list}" var="p">
							<tr>
								<td><input type="checkbox" value="${p.id}">${p.id}</td>
								<td>${p.category}</td>
								<td>${p.name}</td>
								<td>${p.price}</td>
								<td>${p.salePoint}</td>
								<td><img src="${p.images}" class="img-rounded"
									width="100px" height="100px"></td>
								<td>
									<button type="button" class="btn btn-info btn-sm" btn_id="${p.id}">修改</button>
									<button type="button" class="btn btn-danger btn-sm" btn_id="${p.id}">删除</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<small>当前第${pageInfo.pageNum}页，共有${pageInfo.total}记录，共${pageInfo.pages}页</small>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-7">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<!-- 首页 -->
					<li><a
						href="${pageContext.request.contextPath}/product/productList/1">首页</a></li>
					<!-- 上一页 -->
					<c:choose>
						<c:when test="${pageInfo.pageNum!=1}">
							<li><a
								href="${pageContext.request.contextPath}/product/productList/${pageInfo.pageNum-1}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:when>
						<c:otherwise>
							<li class="disabled"><a
								href="${pageContext.request.contextPath}/product/productList/${pageInfo.pageNum-1}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:otherwise>
					</c:choose>

					<!-- 中间 -->
					<c:forEach items="${pageInfo.navigatepageNums}" var="pn">
						<c:if test="${pageInfo.pageNum==pn }">
							<li class="active"><a
								href="${pageContext.request.contextPath}/product/productList/${pn}">${pn}</a></li>
						</c:if>
						<c:if test="${pageInfo.pageNum!=pn }">
							<li><a
								href="${pageContext.request.contextPath}/product/productList/${pn}">${pn}</a></li>
						</c:if>
					</c:forEach>
					<!-- 下一页 -->
					<c:choose>
						<c:when test="${pageInfo.pageNum!=pageInfo.lastPage}">
							<li><a
								href="${pageContext.request.contextPath}/product/productList/${pageInfo.pageNum+1}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:when>
						<c:otherwise>
							<li class="disabled"><a
								href="${pageContext.request.contextPath}/product/productList/${pageInfo.lastPage}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:otherwise>
					</c:choose>
					<!-- 尾页 -->
					<li><a
						href="${pageContext.request.contextPath}/product/productList/${pageInfo.lastPage}">尾页</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				</div>
				<div class="modal-body" id="add_content">
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="save">保存</button>
				</div>
			</div>
		</div>
	</div>

</body>

</html>