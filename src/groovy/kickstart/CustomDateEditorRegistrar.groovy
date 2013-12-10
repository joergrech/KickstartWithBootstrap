package kickstart

import java.text.SimpleDateFormat

import org.codehaus.groovy.grails.web.binding.StructuredDateEditor
import org.springframework.beans.PropertyEditorRegistrar
import org.springframework.beans.PropertyEditorRegistry
import org.springframework.context.i18n.LocaleContextHolder

class CustomDateEditorRegistrar implements PropertyEditorRegistrar {
	def grailsApplication

	void registerCustomEditors(PropertyEditorRegistry registry) {
		def messageSource = grailsApplication.mainContext.messageSource
 		String dateFormat = messageSource.getMessage("default.date.datepicker.format",null,null,LocaleContextHolder.locale )
		if (!dateFormat) { // if date.datepicker.format is not used use date.format but remove characters not used by datepicker
			dateFormat = messageSource.getMessage("default.date.format",null,'mm/dd/yyyy',LocaleContextHolder.locale )\
				.replace('z', '').replace('Z', '')\
				.replace('h', '').replace('H', '')\
				.replace('k', '').replace('K', '')\
				.replace('w', '').replace('W', '')\
				.replace('s', '').replace('S', '')\
				.replace('m', '').replace('a', '').replace('D', '').replace('E', '').replace('F', '').replace('G', '').replace(':', '')\
				.replace('MMM', 'MM').replace('ddd', 'dd')\
				.trim()
				// do not convert to lowercase
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat)
		StructuredDateEditor sde = new StructuredDateEditor(simpleDateFormat, true)
		// NOTE: to catch problems with invalid dates (e.g., too long "01/02/20135" or short "01/02/600"
		// use the following two lines instead [SEE issue #31 on github])
//		simpleDateFormat.setLenient(false)
//		StructuredDateEditor sde = new StructuredDateEditor(simpleDateFormat, true, dateFormat.length())

		registry.registerCustomEditor(Date, sde)
	}
}
