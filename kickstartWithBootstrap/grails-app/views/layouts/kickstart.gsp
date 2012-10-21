<!DOCTYPE html>
<%-- <html lang="${org.springframework.web.servlet.support.RequestContextUtils.getLocale(request).toString().replace('_', '-')}"> --%>
<html lang="${session.'org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE'}">

<head>
	<title><g:layoutTitle default="${meta(name:'app.name')}" /></title>
	
    <meta charset="utf-8">
    <meta name="viewport"		content="width=device-width, initial-scale=1.0">
    <meta name="description"	content="">
    <meta name="author"			content="">
    
	<link rel="shortcut icon"		href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
	
	<link rel="apple-touch-icon"	href="assets/ico/apple-touch-icon.png">
    <link rel="apple-touch-icon"	href="assets/ico/apple-touch-icon-72x72.png"	sizes="72x72">
    <link rel="apple-touch-icon"	href="assets/ico/apple-touch-icon-114x114.png"	sizes="114x114">
	
	<r:require modules="jquery, ${session.skin ? session.skin : 'bootstrap'}, bootstrap_utils"/>
	<r:layoutResources />
	<g:layoutHead />
	
	<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
	<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
    
	<%-- For Javascript see end of body --%>
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
	
<!-- Included Javascript files -->
<r:layoutResources />
<!-- Application-specific functionality -->
<script src="${resource(dir:'js',			file:'application.js')}"></script>

</body>

</html>