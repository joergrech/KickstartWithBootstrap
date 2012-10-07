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
//    def doWithApplicationContext = { applicationContext ->
//        // TODO Implement post initialization spring config (optional)
//    }
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
