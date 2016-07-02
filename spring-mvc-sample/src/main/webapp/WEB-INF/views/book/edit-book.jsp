<%@ include file="/WEB-INF/views/includes.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>

	<section class="forms">
		<div class="container">
		
			<c:if test="${info eq 'saved'}">
				<div class="alert alert-success"><spring:message code="success.save" /></div>
			</c:if>	
			<c:if test="${info eq 'updated'}">
				<div class="alert alert-success"><spring:message code="success.update" /></div>
			</c:if>
			<c:if test="${not empty errors}">
				<div class="alert alert-danger"><spring:message code="edit.error" /></div>
			</c:if>

			<form:form action="${pageContext.request.contextPath}/book/save" method="post" commandName="book">	
				
			  <c:if test="${not empty book.id}">
				<form:input path="id" type="hidden"/>
			 </c:if>	
				
              <div class="form-group">
				<label for="title">
                	<spring:message code="sample.book.title" var="title"/>
                	${title} *
                </label>
                <form:errors path="title" element="div" class="alert alert-danger" />
                <form:input path="title"  maxlength="40" class="form-control" placeholder="${title}"/> 
              </div>
              
              <div class="form-group">
                <label for="description">
                	<spring:message code="sample.book.description" var="description"/>
                	${description} *
                </label>
                <form:errors path="description" element="div" class="alert alert-danger" />
                <form:textarea path="description" rows="4"  maxlength="500" class="form-control" placeholder="${description}"/>
              </div>
              
             <div class="form-group">
                <label for="date">
                	<spring:message code="sample.book.date" var="dateLabel"/>
                	${dateLabel} *
                </label>
                <form:errors path="date" element="div" class="alert alert-danger" />
                <fmt:formatDate value="${book.date}" var="dateBook" pattern="dd/MM/yyyy" />
                <form:input path="date" class="form-control datepicker" placeholder="${dateLabel}" value="${dateBook}" />
              </div>
              
              <div class="form-group">
                <label for="writer">
                	<spring:message code="sample.book.writer" var="writer"/>
                	${writer} *
                </label>
                <form:errors path="writer" element="div" class="alert alert-danger" />
                <form:input path="writer"  maxlength="40" class="form-control" placeholder="${writer}"/>
              </div>
              
              <div class="form-group">
                <label for="writer">
                	<spring:message code="sample.book.price" var="priceLabel"/>
                	${priceLabel}
                </label>
                <form:errors path="price" element="div" class="alert alert-danger" />
                <c:set var="priceValue">
                	<fmt:formatNumber pattern="###,###.###" value="${book.price}"/>
                </c:set>
                <form:input path="price"  maxlength="10" class="form-control" placeholder="${priceLabel}" type="number" step="any"/>
              </div>

			  <button type="submit" class="btn btn-success btn-block">
				<c:choose>
					<c:when test="${not empty book.id}">
						<spring:message code="sample.update" />
					</c:when>
					<c:otherwise>
						<spring:message code="sample.save" />
					</c:otherwise>
				</c:choose>
             	</button>
              
			</form:form>
			
		</div>
	</section>

	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>

<script>
	$(document).ready(function(){
		$('.datepicker').datepicker({
			format : 'dd/mm/yyyy'
		});
	});
</script>		

</html>