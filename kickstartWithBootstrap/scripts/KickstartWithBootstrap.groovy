includeTargets << grailsScript("_GrailsInit")

/*
 * Main scripts
 */

target(kickstartWithBootstrap: "Installs the Kickstart scaffolding templates") {
	depends(checkVersion, parseArguments)
	
	println ( '\nInstalling scaffolding templates ...' )
	sourceDir = "${kickstartWithBootstrapPluginDir}/src/templates/scaffolding"
	targetDir = "${basedir}/src/templates/scaffolding"
	copyDir(sourceDir, targetDir, "\nOverwrite existing scaffolding templates\n  in ${targetDir}?", "overwrite.templates")
//	event "StatusUpdate", ["Kickstart templates installed successfully"]
	
	// copy views incl. about.gsp, ...
	println ( '\nReplacing exisiting views and installing new ones ...' )
	sourceDir = "${kickstartWithBootstrapPluginDir}/grails-app/views"
	targetDir = "${basedir}/grails-app/views"
	copyDir(sourceDir, targetDir, "\nOverwrite existing layouts & base GSPs (e.g., index.gsp)\n  in ${targetDir}?", "overwrite.layouts")
//	event "StatusUpdate", ["Kickstart layouts & views installed successfully"]
	
	// copy views incl. about.gsp, ...
	println ( '\nAdding the Home controller ...' )
	sourceDir = "${kickstartWithBootstrapPluginDir}/src/"
	targetDir = "${basedir}/grails-app/controllers/"
//	copyDir(sourceDir, targetDir, "\nOverwrite existing Home controller\n  in ${targetDir}?", "overwrite.home")
	copyFile(sourceDir+"HomeController.groovy",targetDir,		"\nOverwrite existing HomeController.groovy file\n  in ${targetDir}?", "overwrite.conf.urlmappings")
//	event "StatusUpdate", ["Kickstart layouts & views installed successfully"]
	
	// CHECK: Required or accessible via plugin?
//	println ( '\nInstalling taglib for Bootstrap ...' )
//	sourceDir = "${kickstartWithBootstrapPluginDir}/grails-app/taglib/kickstart"
//	targetDir = "${basedir}/grails-app/taglib/kickstart"
//	copyDir(sourceDir, targetDir, "\nOverwrite existing kickstart taglib\n  in ${targetDir}?", "overwrite.taglibs")
//	event "StatusUpdate", ["Kickstart taglib installed successfully"]
	
	// TODO: copy css, js, ...? Or available via plugin mechanism?
	println ( '\nInstalling css, js, and images for Bootstrap ...' )
	sourceDir = "${kickstartWithBootstrapPluginDir}/web-app/"
	targetDir = "${basedir}/web-app/"
	copyDir(sourceDir+"bootstrap", targetDir+"bootstrap",	"\nOverwrite existing bootstrap files\n  in ${targetDir}?", "overwrite.web-app.css")
	copyDir(sourceDir+"kickstart", targetDir+"kickstart",	"\nOverwrite existing kickstart files\n  in ${targetDir}?", "overwrite.web-app.images")
//	copyDir(sourceDir+"js",		targetDir+"js",		"\nOverwrite existing Javascript files?", "overwrite.web-app.js")
//	event "StatusUpdate", ["Kickstart web-app files installed successfully"]

	// TODO: integrate (or) copy URLMappings.groovy, KickstartFilters.groovy
	// TODO: copy css, js, ...? Or available via plugin mechanism?
	println ( '\nInstalling and changing conf files ...' )
	sourceDir = "${kickstartWithBootstrapPluginDir}/grails-app/conf/"
	targetDir = "${basedir}/grails-app/conf/"
//	copyDir(sourceDir+"kickstart/",targetDir+"kickstart",	"\nOverwrite existing Kickstart conf files\n  in ${targetDir}?", "overwrite.conf.kickstart")
	copyFile("${kickstartWithBootstrapPluginDir}/src/KickstartFilters.groovy",targetDir+"kickstart/",		"\nOverwrite existing URLMappings.groovy file\n  in ${targetDir}?", "overwrite.conf.urlmappings")
	copyFile(sourceDir+"UrlMappings.groovy",targetDir,		"\nOverwrite existing URLMappings.groovy file\n  in ${targetDir}?", "overwrite.conf.urlmappings")
	event "StatusUpdate", ["Kickstart installed successfully"]
}
setDefaultTarget kickstartWithBootstrap



/*
 *  Helper methods to copy files, etc. 
 */


private copyDir(String sourceDir, String targetDir, String confirmText, String confirmCode) {
	overwrite = false

	// only if layouts dir already exists in, ask to overwrite templates
	if (new File(targetDir).exists()) {
		if (!isInteractive || confirmInput(confirmText, confirmCode)) {
			overwrite = true
		}
	} else {
		ant.mkdir(dir: targetDir)
	}
	ant.copy( todir: "$targetDir", overwrite: overwrite) {
		fileset dir: "$sourceDir"
	}
}

private copyFile(String sourceFile, String targetDir, String confirmText, String confirmCode) {
	overwrite = false

	// only if layouts dir already exists in, ask to overwrite templates
	if (new File(targetDir).exists()) {
		if (!isInteractive || confirmInput(confirmText, confirmCode)) {
			overwrite = true
		}
	} else {
//		def targetDir = targetFile.substring(0, targetFile.lastIndexOf('/'))
//		println targetDir
		ant.mkdir(dir: targetDir)
	}
//	println "$sourceFile"
//	println "$targetDir"
	ant.copy(todir: "$targetDir", overwrite: overwrite) {
		fileset(file: "$sourceFile")
	}  
}
