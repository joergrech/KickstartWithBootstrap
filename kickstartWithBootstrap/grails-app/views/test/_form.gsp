<%@ page import="kickstartwithbootstrapgrailsplugin.Test" %>


			<div class="control-group fieldcontain ${hasErrors(bean: testInstance, field: 'isGrailsUser', 'error')} ">
				<label for="isGrailsUser" class="control-label"><g:message code="test.isGrailsUser.label" default="Is Grails User" /></label>
				<div class="controls">
					<bs:checkBox name="isGrailsUser" value="${testInstance?.isGrailsUser}" />
					<span class="help-inline">${hasErrors(bean: testInstance, field: 'isGrailsUser', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: testInstance, field: 'birthday', 'error')} required">
				<label for="birthday" class="control-label"><g:message code="test.birthday.label" default="Birthday" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="birthday" precision="day"  value="${testInstance?.birthday}"  />
					<span class="help-inline">${hasErrors(bean: testInstance, field: 'birthday', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: testInstance, field: 'name', 'error')} ">
				<label for="name" class="control-label"><g:message code="test.name.label" default="Name" /></label>
				<div class="controls">
					<g:textField name="name" value="${testInstance?.name}"/>
					<span class="help-inline">${hasErrors(bean: testInstance, field: 'name', 'error')}</span>
				</div>
			</div>

