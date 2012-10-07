<g:set var="lang" value="${session.'org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE' ?: org.springframework.web.servlet.support.RequestContextUtils.getLocale(request).toString().substring(0,2)}"/>

<ul class="nav secondary-nav language-dropdown pull-right">
	<li class="dropdown js-language-dropdown">
		<a href="javascript:;" class="dropdown-toggle">
			<span class="js-current-language">${lang ? lang.toString().toUpperCase() : "${message(code: 'default.language.button', default: 'Language')}"}</span>
		</a>
		<ul class="dropdown-menu dropdown-menu-dark">
			<li><a class="js-language-link" title="English" data-lang-code="en" href="${createLink(uri: '/?lang=en')}">English</a></li>
			<li><a class="js-language-link" title="German" data-lang-code="de" href="${createLink(uri: '/?lang=de')}">Deutsch</a></li>
			<li><a class="js-language-link" title="Spanish" data-lang-code="es" href="${createLink(uri: '/?lang=es')}">Español</a></li>
			<li><a class="js-language-link" title="French" data-lang-code="fr" href="${createLink(uri: '/?lang=fr')}">Français</a></li>
		</ul>
	</li>
</ul>