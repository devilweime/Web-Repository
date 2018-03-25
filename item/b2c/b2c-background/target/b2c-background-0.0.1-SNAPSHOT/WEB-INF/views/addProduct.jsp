<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>UploadiFive Test</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/uploadify/uploadify.css">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/uploadify/jquery.uploadify.min.js"
	type="text/javascript"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js\bootstrap\css\bootstrap.min.css">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="${pageContext.request.contextPath}/js\bootstrap\js\bootstrap.min.js"></script>
<style type="text/css">
body {
	font: 13px Arial, Helvetica, Sans-serif;
}
</style>

<script type="text/javascript">
	$(function() {
		$("#uploadImage").uploadify(
				{
					height : 20,
					swf : '${pageContext.request.contextPath}/js/uploadify/uploadify.swf',
					uploader : '${pageContext.request.contextPath}/upload/img',
					width : 80,
					'fileObjName' : 'file',
					'buttonText' : '上传图片',
					'removeTimeout' : 0.3,
					'onUploadSuccess' : function(file, data, response) {
			           /*  alert('The file ' + file.name + ' was successfully uploaded with a response of ' + response + ':' + data); */
			           $("#img").attr("src",data);
			           $("#img").show();
			           $("#imgUrl").val(data);
			        }
				});
		$.ajax({
			   type: "POST",
			   url: "<%=request.getContextPath()%>/productCategory/list/0",
			success : function(data) {
				var text = '<option value="">-请选择-</option>';
				for (var i = 0; i < data.length; i++) {
					text += "<option value="+data[i].id+">" + data[i].name
							+ "</option>";
				}
				$("#categoryId").html(text);
			}
		});

		$("#categoryId").change(function() {
			var selectText = $("#categoryId").find("option:selected").text();
			$("#category").val(selectText);
		})
			
		/* 添加商品 */
		$("#save").click(function () {
			if($("#productId").val()==''){
				$.ajax({
					 type:'post',
					 url:'${pageContext.request.contextPath}/product/addProduct',
					 data:$("#form_data").serialize(),
					 success: function(msg){
						 if(msg=='ok'){
						 	location.href="${pageContext.request.contextPath}/product/productList/"+(pages+1);
						 }
					}
				 })
			}
		})
	});
</script>
</head>
<body>
	<!-- <div style="width: 600px; height:400px;"> -->
	<div class="container">
		<!-- <div class="row"> -->
			<!-- <div class="col-md-6"> -->
				<form class="form-horizontal" action="${pageContext.request.contextPath}/product/addProduct"
			method="post" id="form_data">
			<div class="form-group">
					<label for="aaaa" class="col-sm-2 control-label">商品名称</label>
					<div class="col-sm-3"">
						<input type="text" name="name" class="form-control" id="aaaa">
					</div>
			</div>
			<!-- 商品名称：<input type="text" name="name"><br>  -->
			<input type="hidden" name="id" id="productId"> 
			
			<div class="form-group">
					<label for="aaaa" class="col-sm-2 control-label">商品价格</label>
					<div class="col-sm-3"">
						<input type="text" name="price" class="form-control" id="aaaa">
					</div>
			</div>
			<!-- 商品价格：<input type="text" name="price"><br>  -->
			<div class="form-group">
					<label for="aaaa" class="col-sm-2 control-label">商品买点</label>
					<div class="col-sm-3"">
						<input type="text" name="salePoint" class="form-control" id="aaaa">
					</div>
			</div>
			<!-- 商品买点：<input type="text" name="salePoint"><br>  -->
			<input type="hidden"id="category" name="category"> 
			<div class="form-group">
					<label for="aaaa" class="col-sm-2 control-label">商品类别</label>
					<div class="col-sm-3"">
						<select class="form-control" name="categoryId" id="categoryId"></select>
					</div>
			</div>
			
		<!-- 商品类别：
			<select class="form-control" name="categoryId" id="categoryId">
	
			</select> -->
			<div class="form-group">
					<label for="aaaa" class="col-sm-2 control-label">&nbsp; &nbsp; &nbsp; &nbsp; </label>
					<div class="col-sm-3"">
						<img alt="" src=""
					style="width: 100px; height: 100px; display: none;" id="img">
					</div>
			</div>
			<div class="form-group">
					<label for="aaaa" class="col-sm-2 control-label">&nbsp; &nbsp; &nbsp; &nbsp; </label>
					<div class="col-sm-3"">
						<input type="file" name="file" id="uploadImage" />
					</div>
			</div>
			
			<!-- <div id="fileQueue">
				<img alt="" src=""
					style="width: 100px; height: 100px; display: none;" id="img">
			</div> -->
			<!-- <br> <input type="file" name="file" id="uploadImage" /><br> -->
			<input type="hidden" name="images" id="imgUrl"> 
			
			<div class="form-group">
					<label for="aaaa" class="col-sm-2 control-label">商品描述</label>
					<div class="col-sm-3"">
						<textarea class="form-control" rows="8" name="desc"></textarea>
					</div>
			</div>
			<!-- 商品描述：<br>
			<textarea rows="10" cols="20" name="desc"></textarea> -->
			<input type="hidden" name="descId">
			<!-- <div class="form-group">
					<label for="aaaa" class="col-sm-2 control-label">&nbsp; &nbsp; &nbsp; &nbsp; </label>
					<div class="col-sm-3"">
						<input class="btn btn-default"  type="submit" value="提交">
					</div>
			</div> -->
			<!-- <br> <input type="submit" value="提交"> -->
		</form>
			<!-- </div> -->
			<!-- <div class="col-md-2"> -->
			<!-- </div> -->
		<!-- </div> -->
		<!-- <div class="col-md-4"></div> -->
<!-- 	</div> -->
</div>
</body>
</html>