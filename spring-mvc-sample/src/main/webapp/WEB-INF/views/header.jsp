<%@ page session="false" %>

<header>

  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      
      <div class="navbar-header">
        
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button><!-- .navbar-toggle -->

        <a class="navbar-brand" href="">
          Spring MVC Sample
        </a><!-- .navbar-brand -->

      </div><!-- .navbar-header -->

      <div class="collapse navbar-collapse">
      
        <ul class="nav navbar-nav navbar-middle">
          <li class="dropdown">
            <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Opciones<span class="caret"></span></a>

            <ul class="dropdown-menu" role="menu">
              <li><a href='<c:url value="/home" />'><spring:message code="sample.menu.home" /></a>
              <li><a href='<c:url value="/createBook" />'><spring:message code="sample.menu.create-book" /></a></li>
			  <li><a href='<c:url value="/books" />'><spring:message code="sample.menu.search-books" /></a></li>
			  <li><a href='<c:url value="/viewActions" />'><spring:message code="sample.menu.view-actions" /></a></li>
            </ul><!-- .dropdown-menu -->

          </li><!-- .dropdown -->
        </ul>
        
        <ul class="nav navbar-nav navbar-right">
          <li class="dropdown">
            <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><spring:message code="sample.language"/><span class="caret"></span></a>

            <ul class="dropdown-menu" role="menu">
              <li><a href="?mylocale=en"><spring:message code="sample.language.english"/></a></li>
              <li><a href="?mylocale=es"><spring:message code="sample.language.spanish"/></a></li>
            </ul><!-- .dropdown-menu -->

          </li><!-- .dropdown -->
        </ul>
        
      </div><!-- .collapse -->

    </div><!-- .container-->
  </nav><!-- .navbar -->

</header>