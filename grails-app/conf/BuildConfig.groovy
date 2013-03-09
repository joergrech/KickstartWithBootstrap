grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        runtime ('org.lesscss:lesscss:1.3.3')
    }
	plugins {
        runtime	(":hibernate:$grailsVersion")	{ export = false }		// needed for testing the plugin as an app
        build	(":tomcat:$grailsVersion")		{ export = false }		// needed for testing the plugin as an app
		build	(":release:2.2.0")				{ export = false }		// needed for plugin deployment
		
        runtime	(":resources:1.1.6")			{ export = true }		// needed for Bootstrap's less files
		compile	(":lesscss-resources:1.3.1")	{ 						// needed for Bootstrap's less files
			excludes "lesscss"											// needed for Bootstrap's 2.3 changes
			export = true												// see: https://github.com/paulfairless/grails-lesscss-resources/issues/45
		}		

		runtime	(":jquery:1.8.3")				{ export = true }		// needed for Bootstrap's javascript
		compile (":font-awesome-resources:3.0")	{ export = true }		// needed for Bootstrap's image replacement
  	}
}
