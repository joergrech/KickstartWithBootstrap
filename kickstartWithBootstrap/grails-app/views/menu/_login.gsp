				<ul class="nav">
					<li class="dropdown login">
						<a class="dropdown-toggle" href="#">Login</a>
						<ul class="dropdown-menu login">
							<li>
							<form id='LoginForm' class="navbar-form form-stacked" action="${session.postURL ?: resource(file:'j_spring_security_check')}" method='post' >
							<fieldset class="textbox">
								<legend><g:message code="page.index.login" default="Login"/></legend>
								<div class="clearfix">
									<label for="j_username"><g:message code="label.email" default="Email"/></label>
									<div class="input">
										<input id="Username" name="j_username" type="text" class="">
									</div>
								</div>
						  
								<div class="clearfix">
									<label for="j_password"><g:message code="label.password"/></label>
									<div class="input">
										<input id="Password" name="j_password" type="password" class="">
									</div>
								</div>

						  		<div class="clearfix">
							  		<span class="input-prepend">
								  		<span class="add-on"><g:message code="label.remember"/></span>
									</span>
							  		<span class="input-append">
					                	<label class="add-on"><input type="checkbox" checked="checked" value="" id="" name="_spring_security_remember_me"></label>
									</span>

								</div>
						  
								<div class="">
						        	<input class="primary btn left noHover" type="submit" value="${message(code:'label.login')}"/>
						        </div>
							</fieldset>
							<div class="">
								<g:link controller="userAccount" action="forgotPassword"><g:message code="label.forgotPassword"/></g:link>
					        </div>
							</form>
							</li>

							<li class="buttonInDropdown">
							<div class="">
								<g:if test="${!connectedToFB}">
									<fb:login-button perms="user_about_me,email,user_interests,user_hometown,user_location,user_birthday,user_education_history,publish_stream" 
											onlogin="location.href = '/login/index';" >
										<g:message code="auth.login.facebook"/>
									</fb:login-button>
								</g:if>
								<g:else>
									<a href="/login/index" class="btn primary noHover"><g:message code="auth.login.facebook"/></a>
								</g:else>
							</div>
							</li>
						</ul>
					</li>
				</ul>
