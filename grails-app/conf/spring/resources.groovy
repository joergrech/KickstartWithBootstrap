import kickstart.CustomDateEditorRegistrar

beans = {
	customPropertyEditorRegistrar(CustomDateEditorRegistrar) {
		grailsApplication = ref("grailsApplication")
	}
}
