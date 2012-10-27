// Settings for the resources and less-css plugins to "compile" less files into css
grails.resources.modules = {
	/* Skin Definitions */
	'bootstrap'		{
		dependsOn	'jquery'
		resource url: [dir: 'bootstrap/js',		file: 'bootstrap.min.js']
		resource url: [dir: 'less/bootstrap',	file: 'bootstrap.less']
		resource url: [dir: 'less/bootstrap',	file: 'responsive.less']
		resource url: "less/dummy.css" // empty css: see https://github.com/paulfairless/grails-lesscss-resources/issues/25
	}
	'bootstrap_skinA'	{
		dependsOn	'jquery'
		resource url: [dir: 'bootstrap/js',			file: 'bootstrap.min.js']
		resource url: [dir: 'less/bootstrap_skinA', file: 'bootstrap.less']
		resource url: [dir: 'less/bootstrap_skinA', file: 'responsive.less']
		resource url: "less/dummy.css" // empty css: see https://github.com/paulfairless/grails-lesscss-resources/issues/25
	}
	'bootstrap_utils'	{
		dependsOn	'jquery'
//		resource url: [dir: 'FontAwesome/css',		file: 'font-awesome.css']
		resource url: [dir: 'datepicker/js',		file: 'bootstrap-datepicker.js']
		resource url: [dir: 'kickstart/js',			file: 'kickstart.js']
		resource url: [dir: 'kickstart/js',			file: 'checkboxes.js']
		resource url: [dir: 'datepicker/css',		file: 'datepicker.css']
		resource url: [dir: 'kickstart/css',		file: 'docs.css']
		resource url: [dir: 'kickstart/css',		file: 'kickstart.css']
		resource url: "less/dummy.css" // empty css: see https://github.com/paulfairless/grails-lesscss-resources/issues/25
	}
}
