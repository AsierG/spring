<%@ include file="/WEB-INF/views/includes.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>

	<section class="forms">
		<div class="container">
		
			<form:form action="${pageContext.request.contextPath}/book/searchBooks" method="get" commandName="searchBookForm">	
				
				<div class="row">
					<div class="col-lg-4 col-md-12 col-sm-12 row small-top-buffer">
						<div class="col-lg-2 col-md-2 col-sm-2">
							<form:label path="title">
								<spring:message code="sample.book.title" var="title"/>
								${title}
							</form:label>
						</div>
						<div class="col-lg-10 col-md-10 col-sm-10">
							<form:errors path="title" element="div" class="alert alert-danger" />
		                	<form:input path="title"  maxlength="40" class="form-control" placeholder="${title}"/> 
						</div>
					</div>
					<div class="col-lg-8 col-md-12 col-sm-12 row small-top-buffer">
						<div class="col-lg-2 col-md-2 col-sm-2">
							<form:label path="description">
								<spring:message code="sample.book.description" var="description"/>
								${description}
							</form:label>
						</div>
						<div class="col-lg-10 col-md-10 col-sm-10">
							<form:errors path="description" element="div" class="alert alert-danger" />
		                	<form:input path="description"  maxlength="100" class="form-control" placeholder="${description}"/> 
						</div>
					</div>
				</div>		
              
              <div class="row top-buffer left-buffer media">
	              <button type="submit" class="btn btn-success pull-left">
	              	<spring:message code="sample.search-with-submit" />
	              </button>
	               <button type="button" class="btn btn-success pull-left" onclick="searchModelAndView();">
	              		<spring:message code="sample.search-model-and-view" />
	              </button>
              </div>
              
			</form:form>
			
			<jsp:include page="book-results.jsp" />
			
		</div>
	</section>

	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>

<script type="text/javascript">
	function searchModelAndView(){
		function callbackModelAndView(data){
			$("#books").html(data);
		}
		$.get('<c:url value="/book/searchBooksModelAndView" />', 
				$('#searchBookForm').serialize(), callbackModelAndView);
	}
</script>

</html>