<div id="Content" class="container-fluid">
	<div class="row-fluid">

		<!-- Main menu on the left side (e.g., controller entry points) -->
		<g:if test="${!layout_nomainmenu}">
		<div class="span2">
			<g:render template="/_menu/menubar"/>														
		</div>
		</g:if>
		
		<!-- Main content on the right side -->
		<div class="span10">
			<!-- Secondary menu in one line (e.g., actions for current controller) -->
			<div class="row-fluid">
				<div class="span12">
					<g:if test="${!layout_nosecondarymenu}">
						<g:render template="/_menu/submenubar"/>
					</g:if>
				</div>
			</div>

			<!-- print system messages (infos, warnings, etc) - not validation errors -->
			<g:if test="${flash.message && !layout_noflashmessage}">
				<div class="alert alert-info">${flash.message}</div>
			</g:if>

			<!-- Show page's content -->
			<g:layoutBody />
			<g:pageProperty name="page.body" />

		</div>
	</div>
</div>
