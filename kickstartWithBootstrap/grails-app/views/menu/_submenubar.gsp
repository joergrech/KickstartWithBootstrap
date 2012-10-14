<!-- 
This menu is used to show function that can be triggered on the content (an object or list of objects).
-->

<%-- Only show the "Pills" navigation menu if a controller exists (but not for home) --%>
<g:if test="${	params.controller != null
			&&	params.controller != ''
			&&	params.controller != 'home'
}">
	<ul id="Menu" class="nav nav-pills">

		<g:set var="entityName" value="${message(code: params.controller+'.label', default: params.controller.substring(0,1).toUpperCase() + params.controller.substring(1).toLowerCase())}" />
		
		<li class="${ params.action == "list" ? 'active' : '' }">
			<g:link action="list"><i class="icon-th-list"></i> <g:message code="default.list.label" args="[entityName]"/></g:link>
		</li>
		<li class="${ params.action == "create" ? 'active' : '' }">
			<g:link action="create"><i class="icon-plus"></i> <g:message code="default.new.label"  args="[entityName]"/></g:link>
		</li>
		
		<g:if test="${ params.action == 'show' || params.action == 'edit' }">
			<!-- the item is an object (not a list) -->
			<li class="${ params.action == "edit" ? 'active' : '' }">
				<g:link action="edit"><i class="icon-pencil"></i> <g:message code="default.edit.label"  args="[entityName]"/></g:link>
			</li>
			<li class="${ params.action == "edit" ? 'active' : '' }">
				<g:render template="/_common/modals/deleteTextLink" plugin="SPECTRAwebPlugin"/>
			</li>
		</g:if>
		
		<g:if test="${ params.controller == 'user' }">
			<li class="${ params.action == "dashboard" ? 'active' : '' }">
				<g:link action="dashboard"><i class="icon-th-list"></i> <g:message code="default.dashboard.button" args="[entityName]"/></g:link>
			</li>
		</g:if>
		
		<g:if test="${ params.controller == 'product' }">
			<li class="${ params.action == "dashboard" ? 'active' : '' }">
				<g:link action="dashboard"><i class="icon-th-list"></i> <g:message code="default.dashboard.button" args="[entityName]"/></g:link>
			</li>
			<li class="${ params.action == "createWizard" ? 'active' : '' }">
				<g:link action="createWizard"><i class="icon-magic"></i> <g:message code="default.new.wizard.label"  args="[entityName]"/></g:link>
			</li>
		</g:if>
		
		<g:if test="${ params.controller == 'station' }">
			<li class="${ params.action == "map" ? 'active' : '' }">
				<g:link action="mapWithGoogle"><g:message code="default.map.label"  args="[entityName]"/> <i class="icon-chevron-right"></i></g:link>
			</li>
			<li class="${ params.action == "mapWithGoogle" ? 'active' : '' }">
				<g:link action="mapWithGoogle"><i class="icon-globe"></i> <g:message code="default.map.google.label"  default="Google"/></g:link>
			</li>
			<li class="${ params.action == "mapWithBing" ? 'active' : '' }">
				<g:link action="mapWithBing"><i class="icon-globe"></i> <g:message code="default.map.bing.label" default="Bing"/></g:link>
			</li>
			<li class="${ params.action == "mapWithOSM" ? 'active' : '' }">
				<g:link action="mapWithOSM"><i class="icon-globe"></i> <g:message code="default.map.osm.label" default="OSM"/></g:link>
			</li>
			<li class="${ params.action == "mapWithNokia" ? 'active' : '' }">
				<g:link action="mapWithNokia"><i class="icon-globe"></i> <g:message code="default.map.nokia.label" default="Nokia"/></g:link>
			</li>
		</g:if>
	</ul>
</g:if>
