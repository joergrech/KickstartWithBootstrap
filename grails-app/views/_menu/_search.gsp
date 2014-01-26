<g:form controller="search" action="viaNavBar" method="post" class="navbar-form navbar-left" >
	<div class="form-group fieldcontain text-center">
		<input name="query" type="text" class="form-control nav-search" placeholder="${message(code: 'search.navbar.placeholder', default: 'Search ...')}" value="${query}">
	</div>
</g:form>
