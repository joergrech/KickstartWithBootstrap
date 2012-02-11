class KickstartWithBootstrapGrailsPlugin {
    // the plugin version
    def version = "0.5.2"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.7 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
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
    def installation = '''\\
{code}
grails install-plugin KickstartWithBootstrap
{code}
'''
    def description = '''\\
\
h2. Introduction
Kickstart is an extension for Grails in order to start your project with a good looking frontend. 
It provides adapted scaffolding templates for standard CRUD pages using the Bootstrap web page template by Twitter.
'''
/*
h2. Usage

After installation you can call "grails kickstartWithBootstrap" which will copy several files into your project. 
It will overwrite only few files (e.g., in conf, src, and views) - *you should use it only on fresh new Grails project*. 

Afterwards create your domain classes (or copy them into the project) and generate contollers and views - they will now use the Bootstrap framework!

h2. Notes

* Currently, only tested with Grails 1.3.7 projects!
* Does only use plain Bootstrap (currently, without Less).
* The plugin copies the files into your project - you can uninstall the plugin thereafter.
* It does NOT use the Bootstrap plugin.

h2. Terms of Use
* [Bootstrap|http://twitter.github.com/bootstrap/] (from Twitter): Code licensed under the Apache License v2.0. Documentation licensed under CC BY 3.0. (Follow [@TwBootstrap|http://twitter.com/twbootstrap])
* [Kickstart Plugins|https://github.com/joergrech/KickstartWithBootstrap]: Code licensed under the Apache License v2.0. Documentation licensed under CC BY 3.0. Copyright 2011 [Joerg Rech|http://joerg-rech.com] (Follow [@JoergRech|http://twitter.com/joergrech])

 */
    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/kickstartWithBootstrap"

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before 
    }

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
