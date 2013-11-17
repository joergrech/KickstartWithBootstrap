import kickstart.CustomDateEditorRegistrar

// Place your Spring DSL code here
beans = {
	customPropertyEditorRegistrar(CustomDateEditorRegistrar) {
		grailsApplication = ref("grailsApplication")
	}
}
