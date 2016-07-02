<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row left-buffer">
	<h2><spring:message code="sample.search-results" /></h2>
</div>

<div class="panel panel-default">
	<div class="panel-heading">
	    <a class="accordion-toggle" data-toggle="collapse" data-target="#actions" href="#actions">
	    	<spring:message code="sample.action-list" />
		</a>
	</div>
	<div class="panel-body panel-collapse collapse in table-responsive" id="actions">
		<jsp:include page="action-results-table.jsp" />
	</div>
</div>