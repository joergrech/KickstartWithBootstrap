<g:set var="lang" value="${session.'org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE' ?: org.springframework.web.servlet.support.RequestContextUtils.getLocale(request).toString().substring(0,2)}"/>
<g:set var="currentURL" value="${request.forwardURI}"/>

<ul class="nav secondary-nav language-dropdown pull-right">
	<li class="dropdown js-language-dropdown">
		<a href="javascript:;" class="dropdown-toggle">
			<img class="" src="${resource(dir: 'images/flags',file: lang.toString()+'.png')}" />
		</a>
		<ul class="dropdown-menu dropdown-menu-dark">

			<!-- assuming that the default locale is English -->
			<li><a class="js-language-link" title="English" data-lang-code="en" href="${currentURL+'?lang=en'}">
				<img class="" src="${resource(dir: 'images/flags',file: 'en.png')}"/>
				<g:message code="language.en" default="en"/> ${currentlURL }
			</a></li>

			<li class="divider"></li>

			<!-- get list of all locales available due to an existing property-file in /grails-app/i18n (set once in Bootstrap.groovy) -->
			<g:set var="allLocales" value="${grailsApplication.config.grails.i18n.locales}"/>
			<g:each status="i" var="locale" in="${allLocales}">
				<li><a class="js-language-link" title="${message(code: 'language.'+locale, default: locale)}" data-lang-code="${locale}" href="${currentURL+'?lang='+locale}">
					<img class="" src="${resource(plugin: 'kickstart-with-bootstrap', dir: 'images/flags',file: locale+'.png')}"/>
					<g:message code="language.${locale}" default="${locale}"/>
				</a></li>
			</g:each>

		</ul>
	</li>
</ul>