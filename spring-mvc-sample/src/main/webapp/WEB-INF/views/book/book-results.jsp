<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row left-buffer">
	<h2><spring:message code="sample.search-results" /></h2>
</div>

<div class="panel panel-default">
	<div class="panel-heading">
	    <a class="accordion-toggle" data-toggle="collapse" data-target="#books" href="#books">
	    	<spring:message code="sample.book-list" />
		</a>
	</div>
	<div class="panel-body panel-collapse collapse in table-responsive" id="books">
		<jsp:include page="book-results-table.jsp" />
	</div>
</div>
<div class="media">
	<button type="button" id="new Book" class="btn btn-info pull-left" 
		onclick="window.location.href='${pageContext.request.contextPath}/createBook'">
        <spring:message code="buttons.new" />
    </button>
 </div>