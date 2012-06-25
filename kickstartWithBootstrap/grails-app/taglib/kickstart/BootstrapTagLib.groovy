package kickstart

import org.springframework.web.servlet.support.RequestContextUtils as RCU;
import java.text.DateFormatSymbols

class BootstrapTagLib {
	static namespace = "bs"

	def paginate = {
		attrs ->
		def writer = out
		if (attrs.total == null) {
			throwTagError("Tag [paginate] is missing required attribute [total]")
		}

		def messageSource	= grailsAttributes.messageSource
		def locale			= RCU.getLocale(request)

		def total			= attrs.int('total') ?: 0
		def action			= (attrs.action ? attrs.action : (params.action ? params.action : "list"))
		def offset			= params.int('offset') ?: 0
		def max				= params.int('max')
		def maxsteps		= (attrs.int('maxsteps') ?: 10)

		if (!offset)offset	= (attrs.int('offset') ?: 0)
		if (!max)	max		= (attrs.int('max') ?: 10)

		def linkParams = [:]
		if (attrs.params)	linkParams.putAll(attrs.params)
		linkParams.offset = offset - max
		linkParams.max = max
		if (params.sort)	linkParams.sort		= params.sort
		if (params.order)	linkParams.order	= params.order

		def linkTagAttrs = [action:action]
		if (attrs.controller)		linkTagAttrs.controller = attrs.controller
		if (attrs.id != null)		linkTagAttrs.id = attrs.id
		if (attrs.fragment != null)	linkTagAttrs.fragment = attrs.fragment
		linkTagAttrs.params = linkParams

		// determine paging variables
		def steps 		= maxsteps > 0
		int currentstep	= (offset / max) + 1
		int firststep	= 1
		int laststep	= Math.round(Math.ceil(total / max))

		// display previous link when not on firststep
		def disabledPrev = (currentstep > firststep) ? "" : "disabled"
		//		linkTagAttrs.class = 'prevLink'
		//		linkParams.offset = offset - max
		writer << "<ul>"
		writer << "<li class='prev ${disabledPrev}'>"
		writer << link(linkTagAttrs.clone()) {
			(attrs.prev ?: messageSource.getMessage('paginate.prev', null, messageSource.getMessage('default.paginate.prev', null, 'Previous', locale), locale))
		}
		writer << "</li>"

		// display steps when steps are enabled and laststep is not firststep
		if (steps && laststep > firststep) {
			linkTagAttrs.class = 'step'

			// determine begin and endstep paging variables
			int beginstep	= currentstep - Math.round(maxsteps / 2) + (maxsteps % 2)
			int endstep		= currentstep + Math.round(maxsteps / 2) - 1
			if (beginstep < firststep) {
				beginstep = firststep
				endstep = maxsteps
			}
			if (endstep > laststep) {
				beginstep = laststep - maxsteps + 1
				if (beginstep < firststep) {
					beginstep = firststep
				}
				endstep = laststep
			}

			// display firststep link when beginstep is not firststep
			if (beginstep > firststep) {
				linkParams.offset = 0
				writer << "<li>"
				writer << link(linkTagAttrs.clone()) {firststep.toString()}
				writer << "</li>"
				writer << '<li class="disabled"><a href="#">…</a></li>'
			}

			// display paginate steps
			(beginstep..endstep).each { i ->
				if (currentstep == i) {
					writer << "<li class='active'><a href='#'>"+i.toString()+"</a></li>"
				}
				else {
					linkParams.offset = (i - 1) * max
					writer << "<li>"
					writer << link(linkTagAttrs.clone()) {i.toString()}
					writer << "</li>"
				}
			}

			// display laststep link when endstep is not laststep
			if (endstep < laststep) {
				linkParams.offset = (laststep -1) * max
				writer << '<li class="disabled"><a href="#">…</a></li>'
				writer << "<li>"
				writer << link(linkTagAttrs.clone()) { laststep.toString() }
				writer << "</li>"
			}
		}

		// display next link when not on laststep
		def disabledNext = (currentstep < laststep) ? "" : "disabled"
		linkParams.offset = (currentstep)*max
		writer << "<li class='next ${disabledNext}'>"
		writer << link(linkTagAttrs.clone()) {
			(attrs.next ? attrs.next : messageSource.getMessage('paginate.next', null, messageSource.getMessage('default.paginate.next', null, 'Next', locale), locale))
		}
		writer << "</li>"
		writer << "</ul>"
	}

	
	/**
	* A simple date picker that renders a date as selects.<br/>
	* This is just an initial hack - can be widely improved!
	* e.g. &lt;g:datePicker name="myDate" value="${new Date()}" /&gt;
	*
	* @emptyTag
	*
	* @attr name REQUIRED The name of the date picker field set
	* @attr value The current value of the date picker; defaults to now if not specified
	* @attr precision The desired granularity of the date to be rendered
	* @attr noSelection A single-entry map detailing the key and value to use for the "no selection made" choice in the select box. If there is no current selection this will be shown as it is first in the list, and if submitted with this selected, the key that you provide will be submitted. Typically this will be blank.
	* @attr years A list or range of years to display, in the order specified. i.e. specify 2007..1900 for a reverse order list going back to 1900. If this attribute is not specified, a range of years from the current year - 100 to current year + 100 will be shown.
	* @attr relativeYears A range of int representing values relative to value. For example, a relativeYears of -2..7 and a value of today will render a list of 10 years starting with 2 years ago through 7 years in the future. This can be useful for things like credit card expiration dates or birthdates which should be bound relative to today.
	* @attr id the DOM element id
	* @attr disabled Makes the resulting inputs and selects to be disabled. Is treated as a Groovy Truth.
	* @attr readonly Makes the resulting inputs and selects to be made read only. Is treated as a Groovy Truth.
	*/
	Closure datePicker = { attrs ->
		def out = out // let x = x ?
		def xdefault = attrs['default']
		if (xdefault == null) {
			xdefault = new Date()
		}
		else if (xdefault.toString() != 'none') {
			if (xdefault instanceof String) {
				xdefault = DateFormat.getInstance().parse(xdefault)
			}
			else if (!(xdefault instanceof Date)) {
				throwTagError("Tag [datePicker] requires the default date to be a parseable String or a Date")
			}
		}
		else {
			xdefault = null
		}
		def years = attrs.years
		def relativeYears = attrs.relativeYears
		if (years != null && relativeYears != null) {
			throwTagError 'Tag [datePicker] does not allow both the years and relativeYears attributes to be used together.'
		}
	
		if (relativeYears != null) {
			if (!(relativeYears instanceof IntRange)) {
				// allow for a syntax like relativeYears="[-2..5]". The value there is a List containing an IntRage.
				if ((!(relativeYears instanceof List)) || (relativeYears.size() != 1) || (!(relativeYears[0] instanceof IntRange))){
					throwTagError 'The [datePicker] relativeYears attribute must be a range of int.'
				}
				relativeYears = relativeYears[0]
			}
		}
		def value = attrs.value
		if (value.toString() == 'none') {
			value = null
		}
		else if (!value) {
			value = xdefault
		}
		def name = attrs.name
		def id = attrs.id ?: name
	
		def noSelection = attrs.noSelection
		if (noSelection != null) {
			noSelection = noSelection.entrySet().iterator().next()
		}
	
		final PRECISION_RANKINGS = ["year": 0, "month": 10, "day": 20, "hour": 30, "minute": 40]
		def precision = (attrs.precision ? PRECISION_RANKINGS[attrs.precision] :
			(grailsApplication.config.grails.tags.datePicker.default.precision ?
				PRECISION_RANKINGS["${grailsApplication.config.grails.tags.datePicker.default.precision}"] :
				PRECISION_RANKINGS["minute"]))
	
		def day
		def month
		def year
		def hour
		def minute
		def dfs = new DateFormatSymbols(RCU.getLocale(request))
	
		def c = null
		if (value instanceof Calendar) {
			c = value
		}
		else if (value != null) {
			c = new GregorianCalendar()
			c.setTime(value)
		}
	
		if (c != null) {
			day = c.get(GregorianCalendar.DAY_OF_MONTH)
			month = c.get(GregorianCalendar.MONTH)
			year = c.get(GregorianCalendar.YEAR)
			hour = c.get(GregorianCalendar.HOUR_OF_DAY)
			minute = c.get(GregorianCalendar.MINUTE)
		}
	
		if (years == null) {
			def tempyear
			if (year == null) {
				// If no year, we need to get current year to setup a default range... ugly
				def tempc = new GregorianCalendar()
				tempc.setTime(new Date())
				tempyear = tempc.get(GregorianCalendar.YEAR)
			}
			else {
				tempyear = year
			}
			if (relativeYears) {
				if (relativeYears.reverse) {
					years = (tempyear + relativeYears.toInt)..(tempyear + relativeYears.fromInt)
				} else {
					years = (tempyear + relativeYears.fromInt)..(tempyear + relativeYears.toInt)
				}
			} else {
				years = (tempyear - 100)..(tempyear + 100)
			}
		}
		
		booleanToAttribute(attrs, 'disabled')
		booleanToAttribute(attrs, 'readonly')
		
		out.println "	<input id=\"${id}\" name=\"${name}\" class=\"date\" size=\"16\" type=\"text\" value=\"${month ? month + '/': ''}${day ? day + '/': ''}${year ? year + '' : ''}\" data-date-format=\"mm/dd/yyyy\"/>"
//		out.println "<div class=\"input-append date\">"
//		out.println "	<input id=\"${id}\" name=\"${name}\" class=\"\" size=\"16\" type=\"text\" value=\"${day ? day + '-': ''}${month ? month + '-': ''}${year ? year + '-': ''}\" data-date-format=\"dd-mm-yyyy\"/>"
//		out.println "	<span class=\"add-on\"><i class=\"icon-th\"></i></span>"
//		out.println "</div>"
		
	}
	
	/**
	* Some attributes can be defined as Boolean values, but the html specification
	* mandates the attribute must have the same value as its name. For example,
	* disabled, readonly and checked.
	*/
	private void booleanToAttribute(def attrs, String attrName) {
		def attrValue = attrs.remove(attrName)
		// If the value is the same as the name or if it is a boolean value,
		// reintroduce the attribute to the map according to the w3c rules, so it is output later
		if (Boolean.valueOf(attrValue) ||
		   (attrValue instanceof String && attrValue?.equalsIgnoreCase(attrName))) {
			attrs.put(attrName, attrName)
		} else if (attrValue instanceof String && !attrValue?.equalsIgnoreCase('false')) {
			// If the value is not the string 'false', then we should just pass it on to
			// keep compatibility with existing code
			attrs.put(attrName, attrValue)
		}
	}

}
