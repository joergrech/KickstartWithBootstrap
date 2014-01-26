<!-- 
This button is used to call the show page.
-->

<!-- Button -->
<span class=""> 
	<g:link action="show" id="${item ? item.id : params.id}" role="button" class="btn btn-sm" title="${message(code: 'default.button.show.label', default: 'Show')}">
		<i class="glyphicon glyphicon-eye-open"></i>
	</g:link>
</span>
