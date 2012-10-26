
<%@ page import="kickstartwithbootstrapgrailsplugin.Test" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'test.label', default: 'Test')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-test" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="test.birthday.label" default="Birthday" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${testInstance?.birthday}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="test.isGrailsUser.label" default="Is Grails User" /></td>
				
				<td valign="top" class="value"><g:formatBoolean boolean="${testInstance?.isGrailsUser}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="test.name.label" default="Name" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: testInstance, field: "name")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
