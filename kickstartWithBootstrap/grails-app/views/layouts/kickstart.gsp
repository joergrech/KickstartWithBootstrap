<!DOCTYPE html>
<%-- <html lang="${org.springframework.web.servlet.support.RequestContextUtils.getLocale(request).toString().replace('_', '-')}"> --%>
<html lang="${session.'org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE'}">

<head>
    <meta charset="utf-8">
    <meta name="viewport"		content="width=device-width, initial-scale=1.0">
    <meta name="description"	content="">
    <meta name="author"			content="">
    
	<title><g:layoutTitle default="${meta(name:'app.name')}" /></title>
	<link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
	
	<g:set var="skin" value="${session.skin ? session.skin : 'bootstrap'}" />
	
<%--	<r:require modules="${skin}"/>--%>

	<!-- Skin specific styles: main focus are Bootstrap variants (e.g., using Less) -->
	<link rel="stylesheet" href="${resource(dir: skin+'/css',		file: skin+'.css')}" />
	<link rel="stylesheet" href="${resource(dir: skin+'/css',		file: skin+'-responsive.css')}" />

	<!-- Bootstrap extensions / adaptations -->
<%-- 	<link rel="stylesheet" href="${resource(dir: 'FontAwesome/css',	file:'font-awesome.css')}"> --%>
	<link rel="stylesheet" href="${resource(dir: 'datepicker/css',	file: 'datepicker.css')}" />
	<link rel="stylesheet" href="${resource(dir: 'kickstart/css',	file: 'docs.css')}" />
	<link rel="stylesheet" href="${resource(dir: 'kickstart/css',	file: 'kickstart.css')}" />
	
    <link rel="apple-touch-icon" href="assets/ico/apple-touch-icon.png">
    <link rel="apple-touch-icon" href="assets/ico/apple-touch-icon-72x72.png"	sizes="72x72">
    <link rel="apple-touch-icon" href="assets/ico/apple-touch-icon-114x114.png"	sizes="114x114">
    
<%-- 	<r:layoutResources /> --%>
    <g:layoutHead />
	
	<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
	<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
    
    <!-- Skin-specific functionality -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="${resource(dir:skin+'/js',		file:skin+'.js')}"></script>
    
	<!-- Bootstrap-specific functionality -->
	<script src="${resource(dir:'datepicker/js',file:'bootstrap-datepicker.js')}"></script>
    <script src="${resource(dir:'kickstart/js', file:'kickstart.js')}"></script>
    <script src="${resource(dir:'kickstart/js', file:'checkboxes.js')}"></script>
    
	<!-- Application-specific functionality -->
	<script src="${resource(dir:'js',			file:'application.js')}"></script>

</head>

<body>
	<g:render template="/_menu/navbar"/>														

	<!-- Enable to overwrite Header by individual page -->
	<g:if test="${ pageProperty(name:'page.header') }">
   		<g:pageProperty name="page.header" />
	</g:if>
	<g:else>
		<g:render template="/layouts/header"/>														
	</g:else>

	<!-- use different templates for HTML structure based on layout (e.g., grid or fluid; Default is grid) -->
	<g:if test="${session.layout == 'fluid'}">
		<g:render template="/layouts/content_${session.layout}"	plugin="SPECTRAwebPlugin"/>														
	</g:if>
	<g:else>
		<g:render template="/layouts/content_grid"/>														
	</g:else>

	<!-- Enable to overwrite Footer by individual page -->
	<g:if test="${ pageProperty(name:'page.footer') }">
	    <g:pageProperty name="page.footer" />
	</g:if>
	<g:else>
		<g:render template="/layouts/footer"/>														
	</g:else>

	<!-- Insert a modal dialog for registering -->
	<g:render template="/_common/modals/registerDialog" model="[item: item]"/>
	
    <r:layoutResources />
</body>

</html>