import kickstart.CustomDateEditorRegistrar

class KickstartWithBootstrapGrailsPlugin {

	def title           = "Kickstart with Bootstrap - Good looking websites!"
	def version         = "1.1.0"
	def license         = "APACHE"
	def description     = """\
Kickstart is a plugin for Grails to start your project with a good looking frontend. \
It provides adapted scaffolding templates for standard CRUD pages using the Bootstrap \
frontend framework initiated by Twitter."""

    def grailsVersion  = "2.3 > * "
	def pluginExcludes  = [
		'web-app/WEB-INF/**'
	]

	def developers      = [
		[ name: "Jörg Rech", email: "joerg.rech@gmail.com" ]
	]
	def documentation   = "http://grails.org/plugin/kickstart-with-bootstrap"
	def scm             = [ url: "https://github.com/joergrech/KickstartWithBootstrap" ]
	def issueManagement = [ url: "https://github.com/joergrech/KickstartWithBootstrap/issues", system: "GitHub" ]

	def doWithSpring = {
		customPropertyEditorRegistrar(CustomDateEditorRegistrar) {
			grailsApplication = ref("grailsApplication")
		}
	}

	def doWithApplicationContext = { applicationContext ->
		// Collect all *.properties files in the I18N directory and build list of "available" locales
		def locales = []
		def i18nDir

		try {
			if (application.isWarDeployed()) {
				def filePath = "grails-app/i18n"
				i18nDir = application.parentContext.getResource("${File.separator}WEB-INF${File.separator}${filePath}")?.getFile()
			} else {
				i18nDir = new File(System.properties['base.dir'] + "/grails-app/i18n")
			}
			if (i18nDir != null && i18nDir.exists()) {
				i18nDir.eachFileRecurse {
					if (it.file && it =~ /messages.*\.properties/) {
						// Extract locale from filename using RegEx
						def matcher = it.name =~ /messages(.*)\.properties/
						def result = matcher[0][1]            // @see http://groovy.codehaus.org/Regular+Expressions
						if (result != null && result.size() == 3) {
							locales << result.substring(1, 3).toLowerCase()    // should be empty ("") and starts with "_" (e.g., "_de")
						} else if (result != null && result.size() == 6) {
							locales << result.substring(4, 6).toLowerCase()    // should be empty ("") and starts with country (e.g., "_en_US")
						} else {
							// executed if the default "locale" - messages.properties is found
						}
					}
				}
			} else {
				// add a minimum of locales
				locales << "en"
				locales << "de"
			}
			log.info "| Kickstart found ${locales.size()} locales usable in the language selector (excluding the default \"locale\" messages.properties)."
		} catch (Exception e) {
			log.warn "WARNING: could not find the directory to the project's I18N files! The Language Switcher might not work correctly!"
			log.warn e.getMessage()
			// add a minimum of locales
			locales << "en"
			locales << "de"
		}
		application.config.grails.i18n.locales = locales
		System.setProperty('grails.i18n.locales', locales.toString())
	}
}
