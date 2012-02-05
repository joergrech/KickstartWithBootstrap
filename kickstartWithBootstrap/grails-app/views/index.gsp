<html>

<head>
    <title>Welcome to ${meta(name:'app.name')}</title>
    <meta name="layout" content="kickstart" />
</head>

<body>

<section id="intro" class="first">
	<h1>Welcome to Grails using Kickstart with Bootstrap</h1>
	<p>Congratulations, you have successfully started your first Grails application with the Kickstart extension! 
	At the moment this is the default page, feel free to modify it to either redirect to a controller or display 
	whatever content you may choose. Below is a list of controllers that are currently deployed in this application,
	click on each to execute its default action:</p>
	
	<h2>Introduction</h2>
	<p>Kickstart is an extension for Grails in order to start your project with a good looking frontend. 
	It provides adapted scaffolding templates for standard CRUD pages using the Bootstrap web page template by Twitter.</p>
	
	<h2>Notes:</h2>
	<p></p>
	<ul>
	<li>Currently, only tested with Grails 1.3.7!</li>
	<li>Does only use plain Bootstrap (currently, without Less).</li>
	<li>The plugin copies the files into your project - you can uninstall the plugin thereafter.</li>
	<li>It does NOT use the Bootstrap plugin.</li>
	</ul>
	
	<h2>Terms of Use:</h2>
	<p></p>
	<ul>
	<li>Bootstrap (from Twitter): Code licensed under the Apache License v2.0. Documentation licensed under CC BY 3.0. (@TwBootstrap , http://twitter.github.com/bootstrap/)</li>
	<li>Kickstart Plugins: Code licensed under the Apache License v2.0. Documentation licensed under CC BY 3.0. Copyright 2011 Jörg Rech (@JoergRech, http://joerg-rech.com)</li>
	</ul>
	
</section>

<section id="controller">
	<h2>Available Controllers:</h2>
	<div id="controllerList" class="dialog">
	    <ul data-role="listview" data-split-icon="gear" data-filter="true">
	        <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
	            <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName.substring(c.fullName.lastIndexOf('.')+1)}</g:link> (<small>${c.fullName}</small>)</li>
	        </g:each>
	    </ul>
	</div>
</section>
	
</body>

</html>
