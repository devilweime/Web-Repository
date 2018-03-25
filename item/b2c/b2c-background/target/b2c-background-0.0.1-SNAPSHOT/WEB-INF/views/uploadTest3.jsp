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
					height : 30,
					swf : '${pageContext.request.contextPath}/js/uploadify/uploadify.swf',
					uploader : '${pageContext.request.contextPath}/upload/img',
					width : 120,
					'fileObjName' : 'file',
					'buttonText' : '上传图片',
					'onUploadSuccess' : function(file, data, response) {
			            alert('The file ' + file.name + ' was successfully uploaded with a response of ' + response + ':' + data);
			        }
				});
	});
</script>
</head>
<body>

	 <div>
        <%--用来作为文件队列区域--%>
        <div id="fileQueue">
        </div>
        <input type="file" name="file" id="uploadImage" />
    </div>

</body>
</html>