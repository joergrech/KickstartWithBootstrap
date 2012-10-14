<ul class="nav pull-right">
	<li class="dropdown">
		<a class="dropdown-toggle" data-toggle="dropdown" href="#">
			<i class="icon-cog icon-large ${session.skin == 'bootstrap_skinA' ? '' : 'icon-white'}"></i>
<%--			<g:message code="default.config.title"/><b class="caret"></b>--%>
		</a>
		<ul class="dropdown-menu">
			<li class="controller">
				<a tabindex="-1" href="#"><b>Visual Style</b></a>
			</li>
			<li class="dropdown-submenu">
				<a href="#" class="dropdown-toggle">
					<i class="${params.layout == 'fluid' ? 'icon-resize-full' : 'icon-resize-vertical'}"></i>
					<span class="js-current-language">${layout ? layout.toString().toUpperCase() : "${message(code: 'default.layout.button', default: 'Layout')}"}</span>
				</a>
				<ul class="dropdown-menu dropdown-menu-dark">
					<li><a class="js-language-link" title="Vertical" href="${createLink(uri: request.forwardURI+'?layout=grid')}">
						<i class="icon-resize-vertical"></i>
						Grid 940px (Menu Top)
					</a></li>
					<li><a class="js-language-link" title="Horizontal" href="${createLink(uri: request.forwardURI+'?layout=fluid')}">
						<i class="icon-resize-full"></i>
						Fluid (Menu Left)
					</a></li>
				</ul>
			</li>
<%--			<li class="dropdown-submenu">--%>
<%--				<a href="#" class="dropdown-toggle">--%>
<%-- 					<i class="${params.skin != 'bootstrap_skinA' ? 'icon-check-empty' : 'icon-sign-blank'}"></i> --%>
<%--					<span class="js-current-language">${message(code: 'default.skin.button', default: 'Skin')}</span>--%>
<%--				</a>--%>
<%--				<ul class="dropdown-menu dropdown-menu-dark">--%>
<%--					<li>--%>
<%--						<a title="Original" href="${createLink(uri: request.forwardURI+'?skin=bootstrap')}">--%>
<%-- 							<i class="icon-check-empty"></i> -->
<%--							<g:message code="default.skin.original.label" default="Bright (Original)"/>--%>
<%--						</a>--%>
<%--					</li>--%>
<%--					<li>--%>
<%--						<a title="Skin1"    href="${createLink(uri: request.forwardURI+'?skin=bootstrap_skinA')}">--%>
<%-- 							<i class="icon-sign-blank"></i> -->
<%--							<g:message code="default.skin.skinA.label"    default="Dark (Skin A)"/>--%>
<%--						</a>--%>
<%--					</li>--%>
<%--				</ul>--%>
<%--			</li>--%>
		</ul>
	</li>
</ul>

<noscript>
<ul class="nav pull-right">
	<li class="">
		<g:link controller="user" action="config"><g:message code="user.config.button" default="Config"/></g:link>
	</li>
</ul>
</noscript>
