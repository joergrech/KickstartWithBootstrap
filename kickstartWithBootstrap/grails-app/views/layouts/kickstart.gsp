<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"		content="width=device-width, initial-scale=1.0">
    <meta name="description"	content="">
    <meta name="author"			content="">
    
	<title><g:layoutTitle default="${meta(name:'app.name')}" /></title>
	<link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
	
	<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	
	<link rel="stylesheet" href="${resource(dir:'bootstrap/css',file:'bootstrap.css')}" />
	<link rel="stylesheet" href="${resource(dir:'bootstrap/css',file:'bootstrap-responsive.css')}" />
	<link rel="stylesheet" href="${resource(dir:'kickstart/css',file:'docs.css')}" />
<%--	<link rel="stylesheet" href="${resource(dir:'bootstrap/js/google-code-prettify/',file:'prettify.css')}" />--%>
	<link rel="stylesheet" href="${resource(dir:'kickstart/css',file:'kickstart.css')}" />

    <link rel="apple-touch-icon" href="assets/ico/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="assets/ico/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="assets/ico/apple-touch-icon-114x114.png">
    
    <g:layoutHead />
	
    <!-- Note: Place at the end of the document to load faster -->
<%--    <script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>--%>
<%--    <script src="assets/js/jquery.js"></script>--%>
<%--    <script src="assets/js/google-code-prettify/prettify.js"></script>--%>

    <script src="${resource(dir:'bootstrap/js',file:'bootstrap.js')}"></script>
    <script src="${resource(dir:'bootstrap/js',file:'bootstrap-transition.js')}"></script>
    <script src="http://code.jquery.com/jquery-1.6.2.min.js"></script>
    <script src="${resource(dir:'kickstart/js',file:'kickstart.js')}"></script>
	<g:javascript library="application" />
</head>

<body>
	<div id="Navbar" class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<ul class="nav">
					<li class="">
						<a class="logo" href="${createLink(uri: '/')}">
							<img class="logo" src="${resource(dir:'kickstart/img',file:'grails.png')}" alt="${meta(name:'app.name')}" height="25" border="0" />
						</a>
					</li>
				</ul>

				<h3 id="ProjectName">
				<a class="brand" href="${createLink(uri: '/')}">
					${meta(name:'app.name')}
					<small> v${meta(name:'app.version')}</small>
				</a>
				</h3>

				<ul class="nav">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">Browse <b class="caret"></b></a>
						<ul class="dropdown-menu">
		                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
		                    <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName.substring(c.fullName.lastIndexOf('.')+1)}</g:link></li>
		                    </g:each>
						</ul>
					</li>
				</ul>
				
				<div class="pull-right">
<%--					<form class="navbar-search">--%>
<%--						<input type="text" class="search-query" placeholder="Search">--%>
<%--					</form>--%>
					
<%--					<g:render template="/menu/login"/>														--%>
<%--					<g:render template="/menu/user"/>														--%>
					<g:render template="/menu/language"/>														
					<g:render template="/menu/info"/>														
				</div>
				
			</div>
		</div>
	</div>

	<g:if test="${ pageProperty(name:'page.header') }">
   	<g:pageProperty name="page.header" />
	</g:if>
	<g:else>
	<header id="Header" class="jumbotron masthead">
		<div class="inner">
			<div class="container">
				<h1 class="pageTitle"><g:layoutTitle default="${meta(name:'app.name')}" /></h1>
			</div>
		</div>
	</header>
	</g:else>

	<div id="Content" class="container">
<%--		<div class="container">--%>
			<g:if test="${	params.controller != null
						&&	params.controller != ''
						&&	params.controller != 'home'
						&&	params.controller != 'login'
			}">
			<ul id="Menu" class="nav nav-pills">
		        <g:set var="entityName" value="${message(code: params.controller+'.label', default: params.controller.substring(0,1).toUpperCase() + params.controller.substring(1).toLowerCase())}" />
<%--		        	<g:render template="menu"/>--%>
				<li class="${ params.action == "list" ? 'active' : '' }">
					<g:link action="list"><g:message code="default.list.label" args="[entityName]"/></g:link>
				</li>
				<li class="${ params.action == "create" ? 'active' : '' }">
					<g:link action="create"><g:message code="default.new.label"  args="[entityName]"/></g:link>
				</li>
			</ul>
            </g:if>
            
<%--            <g:hasErrors bean="${propertyName}">--%>
<%--            <div class="alert error">--%>
<%--                <g:renderErrors bean="${propertyName}" as="list" />--%>
<%--            </div>--%>
<%--            </g:hasErrors>--%>
<%--            <g:hasErrors bean="${bookInstance}">--%>
<%--            <div class="alert error">--%>
<%--                <g:renderErrors bean="${bookInstance}" as="list" />--%>
<%--            </div>--%>
<%--            </g:hasErrors>--%>
            
            <g:if test="${flash.message}">
            <div class="alert alert-info">${flash.message}</div>
            </g:if>
            
			<g:layoutBody />
            <g:pageProperty name="page.body" />
<%--		</div>--%>
	</div>

	<g:if test="${ pageProperty(name:'page.footer') }">
    <g:pageProperty name="page.footer" />
	</g:if>
	<g:else>
	<footer id="Footer">
	</footer>
	</g:else>
		
</body>

</html>