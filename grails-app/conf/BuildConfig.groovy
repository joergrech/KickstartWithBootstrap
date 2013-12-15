grails.project.work.dir = 'target'

grails.project.dependency.resolution = {

	inherits	'global'
	log			'warn'

	repositories {
		grailsCentral()
		mavenLocal()
		mavenCentral()
	}

	dependencies {
	}

	plugins {
		build	":release:3.0.1",					{ export = false }
		build	":rest-client-builder:1.0.3",		{ export = false }

		runtime	":jquery:1.8.3"											// needed for the Bootstrap datepicker
//		runtime	":jquery:1.10.2.2"										// WARN: does not work with Bootstrap Datepicker !
		runtime	":resources:1.2"										// needed for Bootstrap's less files

		compile	":lesscss-resources:1.3.3"								// needed for Bootstrap's less files
		compile ":font-awesome-resources:3.2.1.2"						// needed for Bootstrap's image replacement
	}
}
