<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>扫码揽收</title>
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


	<div id="bottom" class="container ">
		<div class="row ">
			<div class="col-xs-12 col-md-12 center_box_size /*blank*/ center-block">
				<!-- <div id="cameraScanDiv" class="">
					<img class="show_img " alt="扫描窗口" src="/images/test_piture02.jpg" height="280px"> <input class="hidden" id="cameraScanMailbagCode" type="text" name="mailbagCode" value="">
				</div> -->
				<div id="manualInputDiv" class="center-block" style="margin-top: 130px">
					<div class="input-group">
						<input id="manualInputMailbagCode" type="text" name="mailbagCode" class="form-control" placeholder="邮袋编号" aria-describedby="basic-addon2"> <span class="input-group-addon" onclick="scanMailbag()" id="basic-addon2">GO!</span>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- <div id="bottom" class="container pb_10">
		<div class="row">
			<div class="col-xs-6 col-md-6">
				<button id="manualInput" onclick="manualInput()" type="button" class="btn btn-primary fl">手动输入编码</button>
			</div>

			<div class="col-xs-6 col-md-6">
				<button type="button" class="btn btn-primary fr">打开手电筒</button>
			</div>
		</div>
	</div> -->

</body>
<script type="text/javascript">
	/* function manualInput() {
		$("#manualInputDiv").removeClass("hidden");
		$("#cameraScanDiv").addClass("hidden");
	} */

	$(function() {
		$(document).keydown(function(evnet) {
			if (evnet.keyCode == '13') {
				scanMailbag();
			}
		});
	})

	function scanMailbag() {
		var cameraScanMailbagCode = $("#cameraScanMailbagCode").val()
		var manualInputMailbagCode = $("#manualInputMailbagCode").val()
		var mailbagCode = cameraScanMailbagCode ? cameraScanMailbagCode
				: (manualInputMailbagCode ? manualInputMailbagCode : '');
		if (!mailbagCode) {
			alert("邮袋编号不能为空！")
			return;
		}
		/* $("#scanMailbag input").val(mailbagCode);
		 $("#scanMailbag").submit(); */
		window.location.href = "${pageContext.request.contextPath}/mailbag/page/scanMailbag/" + mailbagCode;
	}
</script>

</html>