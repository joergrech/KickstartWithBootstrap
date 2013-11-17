<nav id="Navbar" class="navbar navbar-fixed-top navbar-inverse" role="navigation">
	<div class="container">
	
	    <div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
        		<span class="sr-only">Toggle navigation</span>
        		<span class="icon-bar"></span>
	           	<span class="icon-bar"></span>
	           	<span class="icon-bar"></span>
			</button>
	
			<a class="navbar-brand" href="${createLink(uri: '/')}">
				<img class="logo" src="${resource(plugin: 'kickstart-with-bootstrap', dir:'kickstart/img', file:'grails.png')}" alt="${meta(name:'app.name')}" width="16px" height="16px"/> 
				${meta(name:'app.name')}
				<small> v${meta(name:'app.version')}</small>
			</a>
		</div>

		<div class="collapse navbar-collapse navbar-ex1-collapse" role="navigation">

		<ul class="nav navbar-nav">
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
		</ul>

    	<ul class="nav navbar-nav navbar-right">
 			<g:render template="/_menu/search"/> 
			<g:render template="/_menu/admin"/>														
			<g:render template="/_menu/info"/>														
			<g:render template="/_menu/user"/><!-- NOTE: the renderDialog for the "Register" modal dialog MUST be placed outside the NavBar (at least for Bootstrap 2.1.1): see bottom of main.gsp -->
			<g:render template="/_menu/language"/>														
	    </ul>			

		</div>
	</div>
</nav>
