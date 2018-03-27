<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的</title>
<%@include file="header.jsp"%>
</head>
<body>
	<section class="content-wrap">
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-md-12 mt_10 md_10">
				<table class="header_table">
					<tr>
						<td><a id="back" class="block fl ml_10" href="javascript:history.go(-1)"><span class="glyphicon glyphicon glyphicon-chevron-left"></span></a></td>
						<td><a id="myInfo" class="block fr mr_10" href="javascript:void(0);"><span class="glyphicon glyphicon-user"></span></a></td>
					</tr>
				</table>
			</div>
			<div class="col-xs-12 col-md-12">
				<div class="widget center">
					<a href="${pageContext.request.contextPath}/mailbag/page/myMailbags">我的邮袋</a>
				</div>
				<div class="widget center">
					<a href="${pageContext.request.contextPath}/mailbag/page/toModifyPassword">修改密码</a>
				</div>
				<div class="widget center">
					<a href="${pageContext.request.contextPath}/loginout">退出</a>
				</div>
				<div class="widget center">
					<a onclick="aboutInfo()" href="javascript:void(0);">关于</a>
				</div>
				<div id='about' class="widget center about hidden">
					版本 v0.1<br>
					反馈意见至 &nbsp;&nbsp;1665382553@qq.com<br>
					深圳市力得得力技术有限公司开发
				</div>
			</div>
		</div>
	</div>
	</section>
</body>
<script type="text/javascript">
	function aboutInfo(){
		if($('#about').hasClass('hidden')){
			$('#about').removeClass('hidden');
		}else{
			$('#about').addClass('hidden');
		}
		
	}
</script>

</html>