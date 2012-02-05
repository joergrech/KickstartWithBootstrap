<ul class="nav">
	<li class="dropdown">
		<a class="dropdown-toggle" href="#">Info <b class="caret"></b></a>
		<ul class="dropdown-menu">
		
			<%-- Note: Links to pages without controller are redirected in conf/UrlMappings.groovy --%>
			<li class=""><a href="${createLink(uri: '/about')}">About</a></li>
			<li class=""><a href="http://wordpress.com/signup/"><i>Blog</i></a></li>
			<li class=""><a href="${createLink(uri: '/contact')}">Contact</a></li>
			
			<li class="divider"></li>
			<li class=""><a href="${createLink(uri: '/systeminfo')}">System Info</a></li>
			
			
<%--			<li class="divider"></li>--%>
<%--			<li class=""><a href="${createLink(uri: '/imprint')}">Imprint</a></li>--%>
<%--			<li class=""><a href="${createLink(uri: '/terms')}"><i>Terms of Use</i></a></li>--%>
		</ul>
	</li>
</ul>
