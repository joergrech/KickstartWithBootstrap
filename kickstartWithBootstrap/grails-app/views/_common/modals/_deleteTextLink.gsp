<!-- 
This modal is used to show a button that initiates the delete action.
-->

<!-- Button to trigger modal if Javascript is available -->
<div class="requiresJavascript"> <!-- Wrapped in a div to work around false colloring due to line 2484 in Bootstrap.css (.nav > li > a:hover) -->
	<a href="#DeleteModal" role="button" class="btn btn-danger" data-toggle="modal" title="${message(code: 'default.button.delete.label', default: 'Delete')}">
		<g:message code="default.button.delete.label" default="Delete"/>
	</a>

	<g:render template="/_common/modals/deleteDialog" model="[item: item]" plugin="SPECTRAwebPlugin"/>
</div>

<!-- delete button if no Javascript is available -->
<noscript>
<g:form>
	<g:hiddenField name="id" value="${item ? item.id : params.id}" />
	<span class="button">
		<!-- TODO: use a special action that will request to confim the deletion! (e.g., "deleteConfirm") -->
		<g:actionSubmit action="delete" class="btn btn-danger" 
			value="${message(code: 'default.button.delete.label', default: 'Delete')}"
			/>
	</span>
</g:form>
</noscript>
