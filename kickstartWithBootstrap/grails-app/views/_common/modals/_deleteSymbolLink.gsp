<!-- 
This modal is used to show a button that initiates the delete action.
-->

<!-- Button to trigger modal -->
<span class="requiresJavascript"> <!-- Wrapped in a div to work around false colloring due to line 2484 in Bootstrap.css (.nav > li > a:hover) -->
	<a href="#DeleteModal" role="button" class="btn btn-danger btn-small" data-toggle="modal" title="${message(code: 'default.button.delete.label', default: 'Delete')}">
		<i class="icon-trash icon-large"></i>
	</a>

	<g:render template="/_common/modals/deleteDialog" model="[item: item]" plugin="SPECTRAwebPlugin"/>
</span>

<!-- delete button if no Javascript is available -->
<noscript>
<div class="button">
	<!-- TODO: use a special action that will request to confim the deletion! (e.g., "deleteConfirm") -->
	<g:link action="deleteConfirm" id="${item ? item.id : params.id}" role="button" class="btn btn-danger btn-small">
		<i class="icon-trash"></i>
	</g:link>
</div>
</noscript>
