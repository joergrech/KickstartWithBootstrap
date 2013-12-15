<div class="modal fade" id="RegisterModal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
	    	<g:form controller="login" action="register" class="form-horizontal" method="post" name="register_form">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">x</button>
					<h3><g:message code="security.register.title"/></h3>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label class="col-lg-2 control-label" for="firstname">${message(code: 'security.firstname.label', default: 'Firstname')}</label>
						<div   class="col-lg-10">
							<input class="form-control" name="firstname" id="firstname" type="text" placeholder="${message(code: 'security.firstname.label', default: 'Firstname')}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label" for="lastname">${message(code: 'security.lastname.label', default: 'Lastname')}</label>
						<div   class="col-lg-10">
							<input class="form-control" name="lastname" id="lastname" type="text" placeholder="${message(code: 'security.lastname.label', default: 'Lastname')}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label" for="email">${message(code: 'security.email.label', default: 'Email')}</label>
						<div   class="col-lg-10">
							<input class="form-control" name="email" id="email" type="text" placeholder="${message(code: 'security.email.label', default: 'Email')}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label" for="password">${message(code: 'security.password.label', default: 'Password')}</label>
						<div   class="col-lg-10">
							<input class="form-control" name="password" id="password" type="password" placeholder="${message(code: 'security.password.label', default: 'Password')}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label" for="confirmpasswd">${message(code: 'security.password.confirm.label', default: 'Confirm')}</label>
						<div   class="col-lg-10">
							<input class="form-control" name="confirmpasswd" id="confirmpasswd" type="password" placeholder="${message(code: 'security.password.confirm.label', default: 'Confirm')}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-10 checkbox" for="agreement">
							<input class="col-lg-3" type="checkbox" value="" name="agreement" id="agreement" >
							${message(code: 'security.agreement.label', default: 'I have read and agree with the Terms of Use.')}
						</label>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary"><g:message code="security.register.label"/></button>
				</div>
			</g:form>
		</div>
	</div>
</div>
