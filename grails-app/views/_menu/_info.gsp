<ul class="nav pull-right">
	<li class="dropdown dropdown-btn">
		
		<a class="dropdown-toggle" data-toggle="dropdown" href="#">
    		<i class="icon-info-sign"></i>
			<g:message code="default.info.label"/> <b class="caret"></b>
		</a>
		
		<ul class="dropdown-menu">
		
			<%-- Note: Links to pages without controller are redirected in conf/UrlMappings.groovy --%>
			<li class="">
				<a href="${createLink(uri: '/about')}">
					<i class="icon-info-sign"></i>
					<g:message code="default.about.label"/>
				</a>
			</li>
			<li class="">
				<a href="http://wordpress.com/signup/">
					<i class="icon-align-justify"></i>
					<i><g:message code="default.blog.label"/></i>
				</a>
			</li>
			<li class="">
				<a href="${createLink(uri: '/contact')}">
					<i class="icon-envelope"></i>
					<g:message code="default.contact.label"/>
				</a>
			</li>
						
<%--			<li class="divider"></li>--%>
<%--			<li class=""><a href="${createLink(uri: '/imprint')}">Imprint</a></li>--%>
<%--			<li class=""><a href="${createLink(uri: '/terms')}"><i>Terms of Use</i></a></li>--%>
		</ul>
	</li>
</ul>
