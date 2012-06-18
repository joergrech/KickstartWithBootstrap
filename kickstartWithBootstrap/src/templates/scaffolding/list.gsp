<% import grails.persistence.Event %>
<% import org.codehaus.groovy.grails.plugins.PluginManagerHolder %>
<%=packageName%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>

<section id="list" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			<%  excludedProps = Event.allEvents.toList() << 'version'
				allowedNames = domainClass.persistentProperties*.name << 'id' << 'dateCreated' << 'lastUpdated'
				props = domainClass.properties.findAll { allowedNames.contains(it.name) && !excludedProps.contains(it.name) && !Collection.isAssignableFrom(it.type) }
				Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
				display = true
				int addCol
				addCol = 6
				boolean hasHibernate = PluginManagerHolder.pluginManager.hasGrailsPlugin('hibernate')
				props.eachWithIndex { p, i ->
					if (hasHibernate) {
						cp = domainClass.constrainedProperties[p.name]
						display = (cp ? cp.display : true)
						if (!display) { addCol++ }
					}
					if (display && i < addCol ) {
						if (p.isAssociation()) { %>
				<th><g:message code="${domainClass.propertyName}.${p.name}.label" default="${p.naturalName}" /></th>
			<%	  } else { %>
				<g:sortableColumn property="${p.name}" title="\${message(code: '${domainClass.propertyName}.${p.name}.label', default: '${p.naturalName}')}" />
			<%  }   }   } %>
			</tr>
		</thead>
		<tbody>
		<g:each in="\${${propertyName}List}" status="i" var="${propertyName}">
			<tr class="\${(i % 2) == 0 ? 'odd' : 'even'}">
			<%  props.eachWithIndex { p, i ->
					if (i == 0) { %>
				<td><g:link action="show" id="\${${propertyName}.id}">\${fieldValue(bean: ${propertyName}, field: "${p.name}")}</g:link></td>
			<%	  } else else {
					display = true
					hasHibernate = PluginManagerHolder.pluginManager.hasGrailsPlugin('hibernate')
					if (hasHibernate) {
						cp = domainClass.constrainedProperties[p.name]
						display = (cp ? cp.display : true)
						}
					if (display && i <  addCol ) {
						if (p.type == Boolean.class || p.type == boolean.class) { %>
				<td><g:formatBoolean boolean="\${${propertyName}.${p.name}}" /></td>
			<%		  } else if (p.type == Date.class || p.type == java.sql.Date.class || p.type == java.sql.Time.class || p.type == Calendar.class) { %>
				<td><g:formatDate date="\${${propertyName}.${p.name}}" /></td>
			<%		  } else { %>
				<td>\${fieldValue(bean: ${propertyName}, field: "${p.name}")}</td>
			<%  }   }   }  } %>
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="\${${propertyName}Total}" />
	</div>
</section>

</body>

</html>
