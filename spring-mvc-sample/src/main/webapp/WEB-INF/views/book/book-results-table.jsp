<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:choose>
	<c:when test="${fn:length(results) > 0}">
		<table class="table table-hover">
			<tr>
				<th><spring:message code="sample.book.title" /></th>
				<th><spring:message code="sample.book.description" /></th>
				<th></th>
			</tr>
			<c:forEach items="${results}" var="book" varStatus="i">
				<c:set var="index" value="${i.index}" scope="request" />
				<tr id="row${index}">
					<td
						onclick="window.document.location='${pageContext.request.contextPath}/book/edit/${book.id}';"
						class="clicable">${book.title}</td>
					<td
						onclick="window.document.location='${pageContext.request.contextPath}/book/edit/${book.id}';"
						class="clicable">${book.description}</td>
					<td class="column-delete">
						<button type="button" class="btn btn-danger btn-circle deleteBook"
							data-book-id="${book.id}">
							<i class="glyphicon glyphicon-remove "></i>
						</button>
					</td>
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

<script>
	function deleteBook(bookId, rowId) {
		$.ajax({
			type : "POST",
			"url" : '<c:url value="/book/delete" />',
			data : {
				bookId : bookId
			}
		}).done(function(data) {
			if (data === "deleted") {
				$("#" + rowId).remove();
			}
		});
	}

	$(document).ready(function() {
		$('.deleteBook').on('click', function(element) {
			if (confirm('<spring:message code="delete.question"/>')) {
				var bookId = $(this).data("book-id");
				var rowId = $(this).parent().parent().attr("id");
				deleteBook(bookId, rowId);
			}
		});
	});
</script>



