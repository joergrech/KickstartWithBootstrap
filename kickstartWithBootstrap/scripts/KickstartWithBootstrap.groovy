includeTargets << grailsScript("_GrailsInit")

/*
 * Main scripts
 */
def code = "confirm.kickstart"
def confirmCount = 0
def confirmed = false
def hasChanged = false

target(kickstartWithBootstrap: "Installs the Kickstart scaffolding templates and other files") {
	depends(checkVersion, parseArguments)
	
	// Note: The following files are accessible via the plugin (and are not copied):
	// * Taglib for Bootstrap
	// * Bootstrap files
	// * Kickstart files
	// * Datepicker files for Bootstrap
	
	sourceDir = "${kickstartWithBootstrapPluginDir}/src/templates/"
	targetDir = "${basedir}/src/templates/"
	copy(sourceDir, targetDir, "scaffolding templates", code)

	sourceDir = "${kickstartWithBootstrapPluginDir}/grails-app/views"
	targetDir = "${basedir}/grails-app/views"
	copy(sourceDir, targetDir, "layouts & base GSPs", code)
	
	sourceDir = "${kickstartWithBootstrapPluginDir}/src/"
	targetDir = "${basedir}/grails-app/controllers/"
	copy(sourceDir+"HomeController.groovy",targetDir, "HomeController.groovy", code)

	sourceDir = "${kickstartWithBootstrapPluginDir}/web-app/"
	targetDir = "${basedir}/web-app/"
//	copy(sourceDir+"bootstrap",  targetDir+"bootstrap",		"bootstrap files",  code)
//	copy(sourceDir+"kickstart",  targetDir+"kickstart",		"kickstart files",  code)
//	copy(sourceDir+"datepicker", targetDir+"datepicker",	"datepicker files", code)

	sourceDir = "${kickstartWithBootstrapPluginDir}/grails-app/conf/"
	targetDir = "${basedir}/grails-app/conf/"
	copy("${kickstartWithBootstrapPluginDir}/src/UrlMappings.groovy",		targetDir,				"URLMappings.groovy",		code)
	copy("${kickstartWithBootstrapPluginDir}/src/KickstartFilters.groovy",	targetDir+"kickstart/",	"KickstartFilters.groovy",	code)
	copy("${kickstartWithBootstrapPluginDir}/src/resources.groovy",			targetDir+"spring/",	"resources.groovy", 		code)

	event "StatusUpdate", ["Kickstart installed successfully!"]

}
setDefaultTarget kickstartWithBootstrap


/*
 *  Helper methods to copy files, etc. 
 */
copy = {String source, String target, String confirmText, String confirmCode ->
	def overwrite = confirmed ? true : false
	def newCode = confirmCode + confirmCount++
	def input = ""
	
	// only if dir already exists in, ask to overwrite it
	if (new File(target).exists()) {
		if (isInteractive && !overwrite) 						input = grailsConsole.userInput("Overwrite ${confirmText}?", ["y","n","a"] as String[])
		if (!isInteractive || input == "y" || input == "a" )	overwrite = true
	} else {
		ant.mkdir(dir: target)
		overwrite = true	// nothing to overwrite but will be copied (state this in the event message)
	}
	if (input == "a") confirmed = true
	
	if (new File(source).isDirectory()) ant.copy(todir: "$target", overwrite: overwrite) { fileset dir:  "$source" }
	else 								ant.copy(todir: "$target", overwrite: overwrite) { fileset file: "$source" }  

	event "StatusUpdate", ["... ${confirmText} ${overwrite ? '' : 'not '}installed!"]
}
