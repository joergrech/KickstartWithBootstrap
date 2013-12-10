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
