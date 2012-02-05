class KickstartWithBootstrapGrailsPlugin {
    // the plugin version
    def version = "0.4"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.7 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def author = "Joerg Rech"
    def authorEmail = "joerg.rech@gmail.com"
    def title = "Good looking web project setup with Bootstrap!"
    def description = '''\\
<h3>Introduction</h3>
<p>Kickstart is an extension for Grails in order to start your project with a good looking frontend. 
It provides adapted scaffolding templates for standard CRUD pages using the Bootstrap web page template by Twitter.</p>
<h3>Usage</h3>
<p>After installation you can call "grails kickstartWithBootstrap" which will copy several files into your project. 
It will overwrite only few files (e.g., in conf, src, and views) - you should use it only on fresh new Grails projects. 
</p>
<p>Afterwards create your domain classes (or copy them into the project) and generate contollers and views - they will
now use the Bootstrap framework!
</p>
<h3>Notes:</h3>
<p></p>
<ul>
<li>Currently, only tested with Grails 1.3.7!</li>
<li>Does only use plain Bootstrap (currently, without Less).</li>
<li>The plugin copies the files into your project - you can uninstall the plugin thereafter.</li>
<li>It does NOT use the Bootstrap plugin.</li>
</ul>
<h3>Terms of Use:</h3>
<p></p>
<ul>
<li>Bootstrap (from Twitter): Code licensed under the Apache License v2.0. Documentation licensed under CC BY 3.0. (@TwBootstrap , http://twitter.github.com/bootstrap/)</li>
<li>Kickstart Plugins: Code licensed under the Apache License v2.0. Documentation licensed under CC BY 3.0. Copyright 2011 Jörg Rech (@JoergRech, http://joerg-rech.com)</li>
</ul>

'''

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
