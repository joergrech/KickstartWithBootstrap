<html>

<head>
	<title><g:message code="default.welcome.title" args="[meta(name:'app.name')]"/> </title>
	<meta name="layout" content="kickstart" />
</head>

<body>

	<section id="intro" class="first">
		<h1>Welcome to Grails using Kickstart with Bootstrap</h1>
		<p>Congratulations, you have successfully started your first
			Grails application with the Kickstart extension! At the moment this
			is the default page, feel free to modify it to either redirect to a
			controller or display whatever content you may choose. Below is a
			list of controllers that are currently deployed in this application,
			click on each to execute its default action:</p>
		<h2>Introduction</h2>
		<p>Kickstart is an extension for Grails in order to start your
			project with a good looking frontend. It is intended to be used in
			rapid application scenarios such as a Startup Weekend or a
			prototyping session with a customer. This plugin provides adapted
			scaffolding templates for standard CRUD pages using the Bootstrap web
			page template by Twitter. Additionally, Kickstart includes some
			general GSPs pages (e.g., about.gsp), a minimal logging/orientation
			Filter, and a language switcher.</p>
	</section>

	<section id="info">
		<div class="row-fluid">
	    	<div class="span4">
		    	<div class="center">
					<img class="" src="${resource(dir: 'images',file: 'bs-docs-twitter-github.png')}" />
					<h3>Bootstrap 2.1.1</h3>
				</div>
				<p>Kickstart uses <a href ="http://twitter.github.com/bootstrap/">Bootstrap</a> to render the web pages. Bootstrap is made by Mark Otto (@mdo) and Billy Gates (@fat).</p>
			</div>
	    	<div class="span4">
		    	<div class="center">
					<img class="" src="${resource(dir: 'images',file: 'Datepicker.png')}" />
					<h3>Datepicker for Bootstrap</h3>
				</div>
				<p>Kickstart uses the <a href ="https://github.com/eternicode/bootstrap-datepicker">Datepicker for Bootstrap</a> by Stefan Petre and Andrew Rowls</p>
			</div>
	    	<div class="span4">
		    	<div class="center">
					<img class="" src="${resource(dir: 'images',file: 'flags_preview_large.png')}" height="145"/>
					<h3>Language Selector</h3>
				</div>
				<p>Kickstart uses the <a href="http://www.famfamfam.com/lab/icons/flags/">FamFamFam flag icons</a> by Mark James.</p>
			</div>
	    </div>
	
		<div class="row">
	    	<div class="span4">
		    	<div class="center">
					<h3>Usage</h3>
				</div>
				<p>After installation you can call the script "grails
					kickstartWithBootstrap" which will copy several files into your
					project. It will overwrite only few files (e.g., in conf, src, and
					views) - '''you should use it only on fresh new Grails projects'''.
				</p>
				<p>Afterwards create your domain classes (or copy them into the
					project) and generate contollers and views - they will now use the
					Bootstrap framework!</p>
			</div>
	    	<div class="span4">
		    	<div class="center">
					<h3>Notes</h3>
				</div>
				<p></p>
				<ul>
					<li>Currently, it works with Grails 2.0 and 2.1!</li>
					<li>Does only use plain Bootstrap (currently, without Less).</li>
					<li>It does NOT use the Bootstrap plugin.</li>
					<li>I18N works only for English and German!</li>
				</ul>
			</div>
	    	<div class="span4">
		    	<div class="center">
					<h3>Terms of Use</h3>
				</div>
				<p></p>
				<ul>
					<li>Bootstrap (from Twitter): Code licensed under the Apache
						License v2.0. Documentation licensed under CC BY 3.0.
						(@TwBootstrap , http://twitter.github.com/bootstrap/)</li>
					<li>Kickstart Plugins: Code licensed under the Apache License
						v2.0. Documentation licensed under CC BY 3.0. Copyright 2011 Jörg
						Rech (@JoergRech, http://joerg-rech.com)</li>
				</ul>
			</div>
	    </div>

	</section>

</body>

</html>
