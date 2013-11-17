<%@ page import="kickstart._DemoPage" %>

			<div class="${hasErrors(bean: _DemoPageInstance, field: 'name', 'error')} ">
				<label for="name" class="control-label"><g:message code="_DemoPage.name.label" default="Name" /></label>
				<div>
					<g:textField class="form-control" name="name" value="${_DemoPageInstance?.name}"/>
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'name', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myDate', 'error')} ">
				<label for="myDate" class="control-label"><g:message code="_DemoPage.myDate.label" default="My Date" /></label>
				<div>
					<bs:datePicker class="form-control" name="myDate" precision="day" value="${_DemoPageInstance?.myDate}" noSelection="['': '']" />
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myDate', 'error')}</span>
				</div>
			</div>
			
<%--			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myDate', 'error')} ">--%>
<%--				<label for="myDate2" class="control-label"><g:message code="_DemoPage.myDate2.label" default="My Date2" /></label>--%>
<%--				<div class="row">--%>
<%--					<bs:customDatePicker class="form-control col-xs-2" name="myDate2" value="${_DemoPageInstance?.myDate2}" noSelection="['':'-Choose-']"/>--%>
<%--					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myDate2', 'error')}</span>--%>
<%--				</div>--%>
<%--			</div>--%>
			
			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myBoolean', 'error')} ">
				<label for="myBoolean" class="control-label"><g:message code="_DemoPage.myBoolean.label" default="My Boolean" /></label>
				<div>
					<bs:checkBox class="form-control" name="myBoolean" value="${_DemoPageInstance?.myBoolean}" />
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myBoolean', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myInt', 'error')} required">
				<label for="myInt" class="control-label"><g:message code="_DemoPage.myInt.label" default="My Int" /><span class="required-indicator">*</span></label>
				<div>
					<g:field class="form-control" type="number" name="myInt" required="" value="${_DemoPageInstance.myInt}"/>
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myInt', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myShort', 'error')} required">
				<label for="myShort" class="control-label"><g:message code="_DemoPage.myShort.label" default="My Short" /><span class="required-indicator">*</span></label>
				<div>
					<g:field class="form-control" type="number" name="myShort" required="" value="${_DemoPageInstance.myShort}"/>
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myShort', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myLong', 'error')} required">
				<label for="myLong" class="control-label"><g:message code="_DemoPage.myLong.label" default="My Long" /><span class="required-indicator">*</span></label>
				<div>
					<g:field class="form-control" type="number" name="myLong" required="" value="${_DemoPageInstance.myLong}"/>
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myLong', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myFloat', 'error')} required">
				<label for="myFloat" class="control-label"><g:message code="_DemoPage.myFloat.label" default="My Float" /><span class="required-indicator">*</span></label>
				<div>
					<g:field class="form-control" type="number" name="myFloat" step="any" required="" value="${_DemoPageInstance.myFloat}"/>
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myFloat', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myDouble', 'error')} required">
				<label for="myDouble" class="control-label"><g:message code="_DemoPage.myDouble.label" default="My Double" /><span class="required-indicator">*</span></label>
				<div>
					<g:field class="form-control" type="number" name="myDouble" step="any" required="" value="${_DemoPageInstance.myDouble}"/>
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myDouble', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myByte', 'error')} required">
				<label for="myByte" class="control-label"><g:message code="_DemoPage.myByte.label" default="My Byte" /><span class="required-indicator">*</span></label>
				<div>
					<g:field class="form-control" type="number" name="myByte" required="" value="${_DemoPageInstance.myByte}"/>
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myByte', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myChar', 'error')} required">
				<label for="myChar" class="control-label"><g:message code="_DemoPage.myChar.label" default="My Char" /><span class="required-indicator">*</span></label>
				<div>
					<g:field class="form-control" type="number" name="myChar" required="" value="${_DemoPageInstance.myChar}"/>
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myChar', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myByteArray', 'error')} ">
				<label for="myByteArray" class="control-label"><g:message code="_DemoPage.myByteArray.label" default="My Byte Array" /></label>
				<div>
					<input class="" type="file" id="myByteArray" name="myByteArray" />
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myByteArray', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myInteger', 'error')} ">
				<label for="myInteger" class="control-label"><g:message code="_DemoPage.myInteger.label" default="My Integer" /></label>
				<div>
					<g:field class="form-control" type="number" name="myInteger" value="${_DemoPageInstance.myInteger}"/>
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myInteger', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myTimeZone', 'error')} ">
				<label for="myTimeZone" class="control-label"><g:message code="_DemoPage.myTimeZone.label" default="My Time Zone" /></label>
				<div>
					<g:timeZoneSelect class="form-control" name="myTimeZone" value="${_DemoPageInstance?.myTimeZone}"  noSelection="['': '']" />
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myTimeZone', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myLocale', 'error')} ">
				<label for="myLocale" class="control-label"><g:message code="_DemoPage.myLocale.label" default="My Locale" /></label>
				<div>
					<g:localeSelect class="form-control" name="myLocale" value="${_DemoPageInstance?.myLocale}"  noSelection="['': '']" />
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myLocale', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myCurrency', 'error')} ">
				<label for="myCurrency" class="control-label"><g:message code="_DemoPage.myCurrency.label" default="My Currency" /></label>
				<div>
					<g:currencySelect class="form-control" name="myCurrency" value="${_DemoPageInstance?.myCurrency}"  noSelection="['': '']" />
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myCurrency', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: _DemoPageInstance, field: 'myEnum', 'error')} required">
				<label for="myEnum" class="control-label"><g:message code="_DemoPage.myEnum.label" default="My Enum" /><span class="required-indicator">*</span></label>
				<div>
					<g:select class="form-control" name="myEnum" from="${kickstart._DemoPage$Suit?.values()}" keys="${kickstart._DemoPage$Suit.values()*.name()}" required="" value="${_DemoPageInstance?.myEnum?.name()}"/>
					<span class="help-inline">${hasErrors(bean: _DemoPageInstance, field: 'myEnum', 'error')}</span>
				</div>
			</div>

