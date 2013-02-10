// Settings for the resources and less-css plugins to "compile" less files into css

grails.resources.modules = {

	if (grails.util.Environment.current == grails.util.Environment.PRODUCTION) {
		/* Skin Definitions without less (only necessary for PAAS deployment, eg., for CloudFoundry) */
		'bootstrap' {
			dependsOn 'jquery'
			resource url: [dir: 'bootstrap/js',			file: 'bootstrap.min.js']
			resource url: [dir: 'bootstrap/css',		file: 'bootstrap.css']
			resource url: [dir: 'bootstrap/css',		file: 'bootstrap-responsive.css']
		}
		// TODO: link a second static/compiled skin or remove the switch entries in layouts/Kickstart.gsp and /_menu/_config.gsp
		'bootstrap_skinA'	{
			dependsOn	'jquery'
			resource url: [dir: 'bootstrap/js',			file: 'bootstrap.min.js']
			resource url: [dir: 'bootstrap/css',		file: 'bootstrap.css']
			resource url: [dir: 'bootstrap/css',		file: 'bootstrap-responsive.css']
		}
	}
	else {
		/* Skin Definitions with less */
		'bootstrap'     {
			dependsOn   'jquery'
			resource url: [dir: 'bootstrap/js',			file: 'bootstrap.min.js']
			resource url: [dir: 'less/bootstrap',		file: 'bootstrap.less']
			resource url: [dir: 'less/bootstrap',		file: 'responsive.less']
			resource url: "less/dummy.css" // empty css: see https://github.com/paulfairless/grails-lesscss-resources/issues/25
		}
		'bootstrap_skinA'   {
			dependsOn   'jquery'
			resource url: [dir: 'bootstrap/js',			file: 'bootstrap.min.js']
			resource url: [dir: 'less/bootstrap_skinA',	file: 'bootstrap.less']
			resource url: [dir: 'less/bootstrap_skinA',	file: 'responsive.less']
			resource url: "less/dummy.css" // empty css: see https://github.com/paulfairless/grails-lesscss-resources/issues/25
		}
	}

	// Utility resources (must be loaded after bootstrap skin resources)
	// Duplication necessary as switching skins causes new skin to be loaded after utilities!
	'bootstrap_utils' {
		dependsOn 'jquery, bootstrap'
		// resource url: [dir: 'FontAwesome/css',			file: 'font-awesome.css'] // see http://fortawesome.github.com/Font-Awesome/#integration
		resource url: [dir: 'datepicker/js',			file: 'bootstrap-datepicker.js']
		resource url: [dir: 'kickstart/js',				file: 'kickstart.js']
		resource url: [dir: 'kickstart/js',				file: 'checkboxes.js']
		resource url: [dir: 'datepicker/css',			file: 'datepicker.css']
		resource url: [dir: 'kickstart/css',			file: 'docs.css']
		resource url: [dir: 'kickstart/css',			file: 'kickstart.css']
		resource url: "less/dummy.css" // empty css: see https://github.com/paulfairless/grails-lesscss-resources/issues/25
	}
	'bootstrap_skinA_utils' {
		dependsOn 'jquery, bootstrap_skinA'
		// resource url: [dir: 'FontAwesome/css',			file: 'font-awesome.css'] // see http://fortawesome.github.com/Font-Awesome/#integration
		resource url: [dir: 'datepicker/js',			file: 'bootstrap-datepicker.js']
		resource url: [dir: 'kickstart/js',				file: 'kickstart.js']
		resource url: [dir: 'kickstart/js',				file: 'checkboxes.js']
		resource url: [dir: 'datepicker/css',			file: 'datepicker.css']
		resource url: [dir: 'kickstart/css',			file: 'docs.css']
		resource url: [dir: 'kickstart/css',			file: 'kickstart.css']
		resource url: "less/dummy.css" // empty css: see https://github.com/paulfairless/grails-lesscss-resources/issues/25
	}
}
