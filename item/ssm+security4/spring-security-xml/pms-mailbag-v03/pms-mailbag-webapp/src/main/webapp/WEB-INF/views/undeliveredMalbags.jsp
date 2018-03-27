<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>
<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
	<c:forEach items="${resultMap.data}" var="mapOfList" varStatus="i">
		<div class="panel panel-default">
			<div class="panel-heading" role="tab" id="heading${i.index}">
				<h4 class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse${i.index}" aria-expanded="false" aria-controls="collapse${i.index}">${mapOfList.datetime}(${mapOfList.total}) </a>
				</h4>
			</div>
			<div id="collapse${i.index}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${i.index}">
				<c:choose>
					<c:when test="${mapOfList.total == 0}">
						<div class="text_center_box">暂无数据</div>
					</c:when>
					<c:otherwise>
						<ul class="list-group">
							<c:forEach items="${mapOfList.dataList}" var="mailbag">
								<li class="list-group-item" onclick="getMailbagDetails('${mailbag.mailbagId}')">
									<div class="row">
										<div class="col-xs-6 col-md-6 hidden">${mailbag.mailbagId}</div>
										<div class="col-xs-6 col-md-6">${mailbag.mailbagCode}</div>
										<div class="col-xs-6 col-md-6">${mailbag.companyName}</div>
									</div>
								</li>
							</c:forEach>
						</ul>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</c:forEach>
</div>
<script type="text/javascript">
	
	$(function() {
		$('#collapse0').collapse('show');
	})

	/* function collapseHide(obj) {
		if ($('#' + obj).hasClass("in")) {
			$('#' + obj).collapse('hide');
		}
		
	}  */
</script>

