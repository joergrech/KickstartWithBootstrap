import java.text.SimpleDateFormat

/** 
 * A script that increments the build number before every compile and stores the build number within the
 * application.properties file. The property can be accessed via the app's metadata "app.version.build", e.g., 
 * in views via <g:meta name="app.version.build"> or ${grailsApplication.metadata['app.version.build']}.
 *
 * Note: the build number will not be correct if multiple persons develop and use a versioning system
 * 
 * @author: Joerg Rech
 * 
 * Based on scripts by Kevin Gill	
 * @see http://www.wthr.us/2010/07/08/adding-an-auto-incrementing-build-number-to-a-grails-application/
 * and Steve Berczuk
 * @ http://steveberczuk.blogspot.com/2011/05/displaying-build-numbers-in-grails-apps.html
 */
eventCompileStart = { kind ->
	// retrieve previous build number and increment or start with 1
	def buildNumber = metadata.'app.version.build'
	if (!buildNumber)
		buildNumber = 1
	else
		buildNumber = Integer.valueOf(buildNumber) + 1

	// store new build number in metadata of app
	metadata.'app.version.build' = buildNumber.toString()
	
	// capture date and profile of build
	def formatter = new SimpleDateFormat("MMM dd, yyyy")
	def buildDate = formatter.format(new Date(System.currentTimeMillis()))
	metadata.'app.version.build.date' = buildDate
	metadata.'app.version.build.env' = grailsEnv
	
	// alternative build numbers
	def build = System.getProperty("build.number", "CUSTOM")

	def revision = null
	def proc
	try { // Git build number
		proc = "git rev-parse --short HEAD".execute()
//		proc = "git shortlog | grep -E \'^[ ]+\\w+\' | wc -l".execute()
		proc.waitFor()
		revision = revision ?: proc.in.text.replace('\n', '')
//		proc = "git rev-parse --short HEAD".execute()
//		proc.waitFor()
//		metadata.'app.version.build.git' = proc.in.text.replace('\n', '').trim()
	} catch (Exception e) {	println e}

	try { // Mercurial build number
		proc = "hg id -i -n -b -t".execute()
		proc.waitFor()
		revision = revision ?: proc.in.text.replace('\n', '').trim()
	} catch (Exception e) {	}

	try { // Subversion build number
		proc = "svnversion".execute()
		proc.waitFor()
		revision = revision ?: proc.in.text.replace('\n', '').trim()
	} catch (Exception e) {	}
	metadata.'app.version.revision' = revision ?: "N/A"
	
	// Save / persist metadata
	metadata.persist()
}

/**
* A script that calculates some project metrics before every compile and stores the build number within the
* application.properties file. The metrics can be accessed via the app's metadata "'app.stats.'+name+'.<metric>'", e.g.,
* in views via ${grailsApplication.metadata['app.stats.Domain_Classes.loc']}
*
* Metrics:
* - Lines of Code (LOC)
* - Number of files
*
* @author: Joerg Rech
*/
eventCompileStart = { kind ->
	// Calculate the loc / stats of the grails system using "grails stats"
	def stats = []
	def out = "cmd /c grails stats".execute().text
	out.split("\n").each { line ->
		if (line =~ /^[\s]*\|[A-Za-z\s]*\|[0-9\s]*\|[0-9\s]*.*$/) {
			def tokenSplit = line.split("\\|")
//			println tokenSplit
			def files = tokenSplit[2].trim()
			def loc	= tokenSplit[3].trim()
			def name  = tokenSplit[1].trim().replace(' ', '_')
			
			def filesID = 'app.stats.'+name+'.files'
			def locID	= 'app.stats.'+name+'.loc'
			metadata.put(filesID, files)
			metadata.put(locID,	loc)
			
			stats << [tokenSplit[1].trim(), tokenSplit[2].trim(), tokenSplit[3].trim()]
		}
	}
	metadata.persist()
//	println stats
	
	println "Compilation Started on Build #${buildNumber}"
//	binding.variables.each { println it.key }
}

eventCompileEnd	= {}

/** 
 * called before "grails war"
 */
eventWarStart 	= {
	def appName			= metadata.'app.name'
	def versionNumber	= metadata.'app.version'
	def buildNumber		= metadata.'app.buildNumber'
	println "WAR packaging started on ${appName} version ${versionNumber} build ${buildNumber}"
}
eventWarEnd 	= {}
