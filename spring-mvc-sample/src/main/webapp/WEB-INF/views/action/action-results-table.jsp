<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:choose>
	<c:when test="${fn:length(results) > 0}">
		<table class="table table-hover">
			<tr>
				<th><spring:message code="sample.action.id" /></th>
				<th><spring:message code="sample.action.type" /></th>
				<th><spring:message code="sample.action.date" /></th>
			</tr>
			<c:forEach items="${results}" var="action" varStatus="i">
				<c:set var="index" value="${i.index}" scope="request" />
				<tr id="row${index}">
					<td>${action.actionId}</td>
					<td><spring:message code="sample.action.${action.type}" /></td>
					<td>${action.date}</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<div class="alert alert-info">
			<spring:message code="sample.info.no-results" />
		</div>
	</c:otherwise>
</c:choose>

