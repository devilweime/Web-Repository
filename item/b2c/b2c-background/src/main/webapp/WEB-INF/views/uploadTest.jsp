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
			   success: function(data){
				   var text = '<option value="">-请选择-</option>';
				  for(var i=0;i<data.length;i++){
					  text += "<option value="+data[i].id+">"+data[i].name+"</option>";
				  }
			     $("#categoryId").html(text);
			   }
			});
		
		$("#categoryId").change(function(){
			 var selectText = $("#categoryId").find("option:selected").text();
			 $("#category").val(selectText);
		})
		 
	});
</script>
</head>
<body>

	 <div>
        <form action="${pageContext.request.contextPath}/product/addProduct" method="post">
        商品名称：<input type="text" name="name"><br>
        <input type="hidden" name="id">
        商品价格：<input type="text" name="price"><br>
   	商品买点：<input type="text" name="salePoint"><br>
   	<input type="hidden" id="category" name="category">
   	商品类别：<select name="categoryId" id="categoryId">
   		
   	</select>
        <div id="fileQueue">
        	<img alt="" src="" style="width: 100px;height: 100px; display: none;" id="img">
        </div>
        <br>
        
        <input type="file" name="file" id="uploadImage" /><br>
        <input type="hidden" name="images" id="imgUrl">
     商品描述：<br>
     <input type="hidden" name="descId">
     <textarea rows="10" cols="20" name="desc"></textarea><br>
     	<input type="submit" value="提交">
        </form>
    </div>
	
</body>
</html>