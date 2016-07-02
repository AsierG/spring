<%@ include file="/WEB-INF/views/includes.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>

	<section id="title-enroll">
		<div class="jumbotron">
			<div class="container-fluid">
				<h1>
					<spring:message code="sample.application.title" />
				</h1>
				<p>
					<spring:message code="sample.application.description" />
				</p>
			</div>
			<!-- .container-fluid -->
		</div>
		<!-- .jumbotron -->
	</section>
	<!-- #title-enroll -->

	<section>
		<div class="container" id="explanation">
			<div class="container">
				<p class="lead">
					<spring:message code="sample.application.explanation" />
				</p>
			</div>
		</div>
	</section>

	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>

</html>