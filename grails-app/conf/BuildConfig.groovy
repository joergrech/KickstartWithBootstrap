grails.project.class.dir		= "target/classes"
grails.project.test.class.dir	= "target/test-classes"
grails.project.test.reports.dir	= "target/test-reports"

//grails.project.fork = [
//    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
//    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
//
//    // configure settings for the test-app JVM, uses the daemon by default
//    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
//    // configure settings for the run-app JVM
//    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
//    // configure settings for the run-war JVM
//    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
//    // configure settings for the Console UI JVM
//    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
//]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
    }
	plugins {
//		runtime	(":hibernate:$grailsVersion")		{ export = false }		// needed for testing the plugin as an app
//		build	(":tomcat:$grailsVersion")			{ export = false }		// needed for testing the plugin as an app
//		build	(":rest-client-builder:1.0.3")		{ export = false }		// needed for plugin deployment
		build	(":release:2.2.1")					{ export = false }		// needed for plugin deployment
		
		runtime	(":jquery:1.8.3")					{ export = true }		// needed for the Bootstrap datepicker
//		runtime	(":jquery:1.10.2")					{ export = true }		// WARN: does not work with Bootstrap Datepicker !
        runtime	(":resources:1.2")					{ export = true }		// needed for Bootstrap's less files
		
		compile	(":lesscss-resources:1.3.3")		{ export = true }		// needed for Bootstrap's less files

		compile (":font-awesome-resources:3.2.1.2")	{ export = true }		// needed for Bootstrap's image replacement
  	}
}
