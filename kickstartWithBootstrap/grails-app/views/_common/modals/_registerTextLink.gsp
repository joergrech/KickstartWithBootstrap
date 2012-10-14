<!-- 
This modal is used to show a button that initiates the registration action.
-->

<!-- Button to trigger modal if Javascript is available -->
<div class="requiresJavascript"> <!-- Wrapped in a div to work around false colloring due to line 2484 in Bootstrap.css (.nav > li > a:hover) -->
    <a href="#RegisterModal" class="btn btn-success" role="button" data-toggle="modal" title="${message(code: 'security.register.button', default: 'Register')}">
    	<i class="icon-signin"></i> 
    	<g:message code="security.register.button"/>
    </a>

	<!-- NOTE: the renderDialog MUST be placed outside the NavBar (at least for Bootstrap 2.1.1): see bottom of main.gsp -->
<%--	<g:render template="/_common/modals/registerDialog" model="[item: item]" plugin="SPECTRAwebPlugin"/>--%>
</div>

<!-- register button if no Javascript is available -->
<noscript>
<g:form>
	<span class="button">
		<!-- TODO: use link to a special action that will show a special page where to register! (e.g., "register.gsp") -->
		<g:actionSubmit action="register" class="btn btn-danger" 
			value="${message(code: 'security.register.button', default: 'Register')}"
			/>
	</span>
</g:form>
</noscript>
