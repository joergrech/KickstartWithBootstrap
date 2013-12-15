<li class="dropdown">
	<a class="dropdown-toggle" data-toggle="dropdown" href="#">Browse <b class="caret"></b></a>
	<ul class="dropdown-menu">
		<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
			<li class="controller">
				<g:link controller="${c.logicalPropertyName}">
				<g:if test="${c.fullName.contains('HomeController')}">
					<i class="icon-home"></i>
				</g:if>
				<g:elseif test="${c.fullName.contains('DemoPageController')}">
					<i class="icon-beaker"></i>
				</g:elseif>
				<g:elseif test="${c.fullName.contains('DbdocController')}">
					<i class="icon-sitemap"></i>
				</g:elseif>
				${c.fullName.substring(c.fullName.lastIndexOf('.')+1)}
			</g:link>
			</li>
		</g:each>
	</ul>
</li>
