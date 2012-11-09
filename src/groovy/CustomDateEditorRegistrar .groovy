import java.text.SimpleDateFormat

import org.codehaus.groovy.grails.commons.ApplicationHolder
import org.springframework.beans.PropertyEditorRegistrar
import org.springframework.beans.PropertyEditorRegistry
import org.springframework.beans.propertyeditors.CustomDateEditor
import org.springframework.context.i18n.LocaleContextHolder
import org.codehaus.groovy.grails.web.binding.StructuredDateEditor

public class CustomDateEditorRegistrar implements PropertyEditorRegistrar {
	
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		def messageSource = ApplicationHolder.application.mainContext.getBean('messageSource')
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
		registry.registerCustomEditor(Date, new StructuredDateEditor(new SimpleDateFormat(dateFormat), true))
	}
}
