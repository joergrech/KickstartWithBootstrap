class KickstartWithBootstrapGrailsPlugin {
    // the plugin version
    def version = "0.7.0"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0.0 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
//            "grails-app/views/error.gsp"
    ]
	
	def license = "APACHE"
//	def organization = [ name: "SpringSource", url: "http://www.springsource.org/" ]
//	def developers = [
//			[ name: "Jörg Rech", email: "joerg.rech@gmail.com" ]
//		]
//	def issueManagement = [ system: "JIRA", url: "http://jira.grails.org/browse/GRAILSPLUGINS" ]
	def scm = [ url: "https://github.com/joergrech/KickstartWithBootstrap" ]

	// TODO Fill in these fields
    def author = "Joerg Rech"
    def authorEmail = "joerg.rech@gmail.com"
    def title = "Kickstart with Bootstrap - Good looking websites!"

    def description = "Kickstart is a plugin for Grails to start your project with a good looking frontend. It provides adapted scaffolding templates for standard CRUD pages using the Bootstrap web page template by Twitter."
    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/kickstart-with-bootstrap"

//    def doWithWebDescriptor = { xml ->
//        // TODO Implement additions to web.xml (optional), this event occurs before 
//    }
//
//    def doWithSpring = {
//        // TODO Implement runtime spring config (optional)
//    }
//
//    def doWithDynamicMethods = { ctx ->
//        // TODO Implement registering dynamic methods to classes (optional)
//    }
//

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
		def locales = []
	
		new File("./grails-app/i18n").eachFileRecurse {
			if (it.file && it =~ /messages.*\.properties/) {
				// Extract locale from filename using RegEx
				def matcher = it.name =~ /messages(.*)\.properties/
				def result = matcher[0][1]					// @see http://groovy.codehaus.org/Regular+Expressions
				if (result != null && result.size() == 3) {
					locales << result.substring(1, 3).toLowerCase()		// should be empty ("") and starts with "_" (e.g., "_de")
				} else if (result != null && result.size() == 6) {
					locales << result.substring(4, 6).toLowerCase()		// should be empty ("") and starts with country (e.g., "_en_US")
				}
			}
		}
		System.setProperty('grails.i18n.locales', locales.toString())
		// Note: The GrailsApplication instance is available in all of the lifecycle closures as the "application" variable.
		application.config.grails.i18n.locales = locales
    }
//
//    def onChange = { event ->
//        // TODO Implement code that is executed when any artefact that this plugin is
//        // watching is modified and reloaded. The event contains: event.source,
//        // event.application, event.manager, event.ctx, and event.plugin.
//    }
//
//    def onConfigChange = { event ->
//        // TODO Implement code that is executed when the project configuration changes.
//        // The event is the same as for 'onChange'.
//    }
}
