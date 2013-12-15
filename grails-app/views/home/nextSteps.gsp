<html>

<head>
	<title>Next Steps</title>
	<meta name="layout" content="kickstart" />
</head>

<body>

	<h1>Next Steps</h1>
	
	<section id="intro" class="first">
		<h3>Customization</h3>
		<p>
			
			<ol>
				<li><b>Search: </b> If you want to have a search on your site you need to integrate/implement a search mechanism (e.g., using Hibernate, elasticsearch, etc.). Currently the search form points to the controller "search" and action "viaNavBar" that you need to implement. The form can be edited in the file <pre>/grails-app/views/_menu/_search.gsp</pre></li>
				<li><b>Login & Registration: </b> If you want users to authenticate themselves you need to integrate/implement a security / authentication  mechanism (e.g., using Spring Security or Shiro). Currently the login and registration form points the controller "login" and action "register" that you need to implement. The forms can be edited in the file <pre>/grails-app/views/_menu/_user.gsp</pre> and  <pre>/grails-app/views/_common/modals/_registerDialog.gsp</pre></li>
				<li><b>NavBar/Menu: </b> To change the navbar (dark menu on top of page) edit the file <pre>/grails-app/views/_menu/_navbar.gsp</pre></li>
				<li><b>Company Info: </b> To change the pages "about", "terms", or "contact" edit them in the directory <pre>/grails-app/views/siteinfo/</pre></li>
			</ol>
		</p>
		<h3>Authentication via Spring Security</h3>
		<p>
			If you want to provide an authentication system I recommend 
			<a href="http://grails.org/plugin/spring-security-core">Spring Security</a>. 
			Kickstart comes with views for the login (/login/auth.gsp) and auth denied (/login/denied.gsp) views. 
		</p>
		<ol>
			<li>Install <a href="http://grails.org/plugin/spring-security-core">spring-security-core</a> in BuildConfig.groovy, e.g.: <pre>compile ":spring-security-core:1.2.7.3"</pre> </li>
			<li>Clean and compile your app to load the plugin</li>
			<li>Execute the <a href="http://grails-plugins.github.com/grails-spring-security-core/docs/manual/ref/Scripts/s2-quickstart.html">s2-quickstart script</a> to generate the required domain classes <pre>grails s2-quickstart com.yourapp User Role</pre></li>
			<ul>
				<li>BUT replace "com.yourapp" with your package structure (e.g., "com.${meta(name:'app.name')}.security")</li>
				<li>Do not overwrite the views auth.gsp and denied.gsp (or copy them from the Kickstart plugin)</li>
			</ul>
			<li>Set security configuration in your Config.groovy (see <a href="http://grails-plugins.github.com/grails-spring-security-core/docs/manual/guide/5%20Configuring%20Request%20Mappings%20to%20Secure%20URLs.html#5.2%20Simple%20Map%20in%20Config.groovy">here</a>)</li>
		</ol>
	</section>

<%--TODO: Search via elasticsearch--%>

</body>

</html>
	