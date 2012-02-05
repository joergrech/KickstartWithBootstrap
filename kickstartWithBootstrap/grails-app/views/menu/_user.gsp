<%--Based on Twitter's User account menu--%>
<ul class="nav">
	<li id="user-dropdown" data-global-action="t1me"
		class="me dropdown session js-session new open">
		<a id="user-dropdown-toggle" href="#" class="dropdown-toggle js-dropdown-toggle js-hover"> 
			<span class="new-wrapper">
				<i class="nav-me"></i>
				<i class="nav-new"></i>
			</span>
		</a>
		<ul class="dropdown-menu dropdown-menu-dark">
			<li data-name="profile" class="current-user">
				<a class="account-summary account-summary-small" href="/joergrech">
					<div class="content">
						<div data-screen-name="joergrech" data-user-id="48456213" class="account-group js-mini-current-user">
							<img data-user-id="48456213" alt="Jörg Rech"
								src="https://twimg0-a.akamaihd.net/profile_images/1412435167/joerg_small_normal.jpg"
								class="avatar size32"> 
							<b class="fullname">Jörg Rech</b> 
							<small class="metadata">View my profile page</small>
						</div>
					</div>
				</a>
			</li>

			<li class="divider"></li>

			<li data-name="messages" class="messages">
				<a href="/#!/" class="js-dm-dialog"> 
					<span class="js-direct-message-count count new">2</span> Direct messages
				</a>
			</li>

			<li data-name="lists">
				<a href="/joergrech/lists">Lists</a>
			</li>
			
			<li class="divider"></li>

			<li><a href="//support.twitter.com">Help</a></li>

			<li><a class="js-keyboard-shortcut-trigger" href="#">Keyboard shortcuts</a></li>

			<li class="divider"></li>

			<li><a href="/settings/account">Settings</a></li>

			<li>
				<a href="#" id="signout-button" class="js-signout-button">
					Sign out
				</a>
				<form method="POST" action="/logout" id="signout-form" class="dropdown-link-form signout-form">
					<input type="hidden" class="authenticity_token" name="authenticity_token" value="6f32a47a9aa00892f11d5423e52b8ae7acf49ccf"> 
					<input type="hidden" class="js-reliability-event" name="reliability_event">
					<input type="hidden" name="scribe_log">
				</form></li>

		</ul>
	</li>
</ul>