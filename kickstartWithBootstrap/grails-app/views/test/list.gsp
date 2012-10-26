
<%@ page import="kickstartwithbootstrapgrailsplugin.Test" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'test.label', default: 'Test')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-test" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="birthday" title="${message(code: 'test.birthday.label', default: 'Birthday')}" />
			
				<g:sortableColumn property="isGrailsUser" title="${message(code: 'test.isGrailsUser.label', default: 'Is Grails User')}" />
			
				<g:sortableColumn property="name" title="${message(code: 'test.name.label', default: 'Name')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${testInstanceList}" status="i" var="testInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${testInstance.id}">${fieldValue(bean: testInstance, field: "birthday")}</g:link></td>
			
				<td><g:formatBoolean boolean="${testInstance.isGrailsUser}" /></td>
			
				<td>${fieldValue(bean: testInstance, field: "name")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${testInstanceTotal}" />
	</div>
</section>

</body>

</html>
