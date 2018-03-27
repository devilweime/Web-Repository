<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的邮袋</title>
<%@include file="header.jsp"%>
</head>
<body>
	<div class="container pb_10">
		<div class="row">
			<div id="top" class="col-xs-12 col-md-12 mt_10 md_10">
				<table class="header_table">
					<tr>
						<td><a id="back" class="block fl ml_10" href="javascript:history.go(-1)"><span class="glyphicon glyphicon glyphicon-chevron-left"></span></a></td>
					</tr>
				</table>
			</div>
			<div id="content" class="col-xs-12 col-md-12">
				
				<ul class="menu">
					<li id="undelivered_menu" onclick="loadUndeliveredMalbags()">未交付(${undeliveredMailbagsCount})</li>
					<li id="delivered_menu" onclick="loadDeliveredMalbags()">已交付</li>
				</ul>
			</div>
			<div class="col-xs-12 col-md-12">
				<div id="panel" class="auto_height"></div>
			</div>
		</div>
	</div>
	<footer class="myFooter_wrap">
	<div class="myFooter center">
		<button type="button" class="btn btn-primary center-block no_opacity" onclick="toReceiveMailbag()">扫码揽收</button>
	</div>
	</footer>
</body>
<script type="text/javascript">
	$(function() {
		loadUndeliveredMalbags();
	})

	function loadUndeliveredMalbags() {
		$("#undelivered_menu").addClass("menu_selected");
		$("#delivered_menu").removeClass("menu_selected");
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/mailbag/page/undeliveredMalbags",
			success : function(data) {
				$("#panel").html(data);
			}
		});
	}

	function loadDeliveredMalbags() {
		$("#delivered_menu").addClass("menu_selected");
		$("#undelivered_menu").removeClass("menu_selected");
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/mailbag/page/deliveredMalbags",
			success : function(data) {
				$("#panel").html(data);
			}
		});
	}
</script>


</html>