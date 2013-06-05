import org.apache.log4j.Level

// Settings for Kickstart plugin (if the plugin is run as an App)
kickstart.build.calculate	= true	// NOTE: this Config file needs to be compiled before the changes are recognized in the compileStart event!
kickstart.metrics.calculate	= true	// NOTE: this Config file needs to be compiled before changes are recognized!

// hide dbconsole resource files (css, js, etc.) from the resource plugin
grails.resources.adhoc.patterns = ['/dbconsole/**']

/** 
 * log4j configuration
 * Config info: @see http://grails.org/doc/latest/guide/conf.html#logging
 * Layout info: @see http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html
 * JDBC info:	@see http://dankomannhaupt.de/projects/jdbcappender/doc/org/apache/log4j/jdbcplus/JDBCAppender.html
 * Multi-File logging: http://stackoverflow.com/questions/1157159/log4j-in-grails-how-to-log-into-file
 * 
 * Levels: ALL < TRACE < DEBUG < INFO < WARN < ERROR < FATAL < OFF
 */
log4j = {
	appenders {
		console		name:			'stdout',
					threshold: 		Level.INFO,
					layout:			pattern(conversionPattern: '%m%n')
	}

	info	'grails.app.filters'
}
