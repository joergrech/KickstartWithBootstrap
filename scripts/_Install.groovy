//
// This script is executed by Grails after plugin was installed to project.
// This script is a Gant script so you can use all special variables provided
// by Gant (such as 'baseDir' which points on project base dir). You can
// use 'ant' to access a global instance of AntBuilder
//
// For example you can create directory under project tree:
//
//    ant.mkdir(dir:"${basedir}/grails-app/jobs")
//

/*
 * Main script to setup Kickstart on installation
 */

//event "StatusStart", ["Kickstart starting to install some files!"]
//
//// copy less files into project
//def sourceDir = "${pluginBasedir}/grails-app/conf/_UrlMappings.groovy"
//def targetDir = "${basedir}/grails-app/conf/UrlMappings.groovy"
//ant.copy(file: ("$sourceDir"), tofile:"$targetDir", overwrite:true)
//
//// copy less files into project
//sourceDir = "${pluginBasedir}/web-app/less"
//targetDir = "${basedir}/web-app/less"
//ant.mkdir(dir: targetDir)
//ant.copy(todir: "$targetDir", overwrite: true) { fileset dir:  "$sourceDir" }
//
//// inject plugin specific configs into Config.groovy
//def configFile = new File("${basedir}/grails-app/conf/Config.groovy")
//configFile.append("grails.config.defaults.locations = [KickstartPluginConfig]")
//
event "StatusFinal", ["To install Kickstart run the script 'kickstart' (e.g., on command line 'grails kickstart')!"]
