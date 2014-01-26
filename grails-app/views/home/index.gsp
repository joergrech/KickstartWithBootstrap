<html>

<head>
	<title><g:message code="default.welcome.title" args="[meta(name:'app.name')]"/> </title>
	<meta name="layout" content="kickstart" />
</head>

<body>

	<section id="intro" class="first">
		<h1>Welcome to Kickstart with Bootstrap 3.0.3 for Grails 2.3</h1>
		<p>
			Congratulations, you have successfully started your first
			Grails application with the Kickstart extension! At the moment this
			is the default page, feel free to modify it to either redirect to a
			controller or display whatever content you may choose.
		</p>
		<h2>Introduction</h2>
		<p>
			Kickstart is an extension for Grails in order to start your
			project with a good looking frontend. It is intended to be used in
			rapid application scenarios such as a Startup Weekend or a
			prototyping session with a customer. This plugin provides adapted
			scaffolding templates for standard CRUD pages using the Bootstrap web
			page template by Twitter. Additionally, Kickstart includes some
			general GSPs pages (e.g., about.gsp), a minimal logging/orientation
			Filter, and a language switcher.
		</p>
		<g:link class="btn btn-large btn-primary" controller="nextSteps">Next Steps</g:link>
	</section>

	<section id="info">
		<div class="row">
	    	<div class="col-md-4">
		    	<div class="center">
					<img class="frontpageImage" src="${resource(plugin: 'kickstart', dir: 'images/frontpage',file: 'bs-docs-twitter-github.png')}" />
					<h3>Bootstrap 3.0.3</h3>
				</div>
				<p>Kickstart uses <a href ="http://twitter.github.com/bootstrap/">Bootstrap</a> to render the web pages. 
				Bootstrap is made by Mark Otto (<a href="http://twitter.com/mdo">@mdo</a>) and Billy Gates (<a href="http://twitter.com/fat">@fat</a>).
				Bootstrap is designed to help people of all skill levels as a complete kit or to start something more complex.
				</p>
			</div>
	    	<div class="col-md-4">
		    	<div class="center">
					<img class="frontpageImage" src="${resource(plugin: 'kickstart', dir: 'images/frontpage',file: 'browser_logos.png')}" />
					<h3>Browser support</h3>
				</div>
				<p>Bootstrap is tested and supported in major modern browsers like Chrome 14, Safari 5+, Opera 11, Internet Explorer 7, and Firefox 5.</p>
			</div>
	    	<div class="col-md-4">
		    	<div class="center">
					<img class="frontpageImage" src="${resource(plugin: 'kickstart', dir: 'images/frontpage',file: 'html5css3js8.png')}"/>
					<h3>Tech Foundation</h3>
				</div>
				<p>Bootstrap is based on elements of HTML 5, CSS 3, Javascript 1.8, and jQuery 1.7 with progressively enhanced 
				components to enable a responsive design of the website.
				Kickstart is built using Groovy 2.x and Java 7 integrated into the Grails 2.3.x framework. 
				</p>
			</div>
	    </div>
	</section>

	<section id="info2">
		<div class="row">
	    	<div class="col-md-4">
		    	<div class="center">
					<img class="" src="${resource(plugin: 'kickstart', dir: 'images/frontpage',file: 'Datepicker.png')}" />
					<h3>Datepicker</h3>
				</div>
				<p>Kickstart uses the <a href ="https://github.com/eternicode/bootstrap-datepicker">Datepicker for Bootstrap</a> by Stefan Petre and Andrew Rowls</p>
			</div>
	    	<div class="col-md-4">
		    	<div class="center">
					<img class="" src="${resource(plugin: 'kickstart', dir: 'images/frontpage',file: 'flags_preview_large.png')}" />
					<h3>Language Selector</h3>
				</div>
				<p>Kickstart contains a language selector that uses the <a href="http://www.famfamfam.com/lab/icons/flags/">FamFamFam flag icons</a> by Mark James.
				It automatically detects which languages are available and offers them in a dropdown menu.</p>
			</div>
	    	<div class="col-md-4">
		    	<div class="center">
					<img class="" height="100" src="${resource(plugin: 'kickstart', dir: 'images/frontpage',file: 'empty.png')}" />
					<h3>Other Features</h3>
				</div>
				<p>Kickstart contains several pages as starting points for the average website such as an About Page, Contact Page, 404, etc.</p>
			</div>
	    </div>
	</section>

</body>

</html>
