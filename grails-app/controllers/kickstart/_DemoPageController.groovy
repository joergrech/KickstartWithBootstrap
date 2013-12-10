package kickstart

class _DemoPageController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "create", params: params)
	}

	def list() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[_DemoPageInstanceList: session.demopage ? [session.demopage] :[], _DemoPageInstanceTotal: session.demopage ? 1 : 0]
	}

	def create() {
		[_DemoPageInstance: new _DemoPage(params)]
	}

	def save() {
		def _DemoPageInstance = new _DemoPage(params)
		_DemoPageInstance.clearErrors()
		_DemoPageInstance.validate()
		// store demopage in session (instead of in the database)
		session.demopage = _DemoPageInstance
		flash.message = message(code: 'default.created.message', args: [message(code: '_DemoPage.label', default: '_DemoPage'), _DemoPageInstance.id])
		redirect(action: "show", dp: _DemoPageInstance)
	}

	def show() {
		def _DemoPageInstance = session.demopage
		[_DemoPageInstance: _DemoPageInstance]
	}

	def edit() {
		def _DemoPageInstance = session.demopage
		_DemoPageInstance?.clearErrors()
		_DemoPageInstance?.validate()
		[_DemoPageInstance: _DemoPageInstance]
	}

	def update() {
		def _DemoPageInstance = session.demopage
		if (!_DemoPageInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: '_DemoPage.label', default: '_DemoPage'), params.id])
			redirect(action: "list")
			return
		}

		if (params.version) {
			def version = params.version.toLong()
			if (_DemoPageInstance.version > version) {
				_DemoPageInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: '_DemoPage.label', default: '_DemoPage')] as Object[],
						  "Another user has updated this _DemoPage while you were editing")
				render(view: "edit", model: [_DemoPageInstance: _DemoPageInstance])
				return
			}
		}

		_DemoPageInstance.properties = params

		session.demopage = _DemoPageInstance

		flash.message = message(code: 'default.updated.message', args: [message(code: '_DemoPage.label', default: '_DemoPage'), _DemoPageInstance.id])
		redirect(action: "show", id: _DemoPageInstance.id)
	}

	def delete() {
		session.demopage = null
		flash.message = message(code: 'default.deleted.message', args: [message(code: '_DemoPage.label', default: '_DemoPage'), params.id])
		redirect(action: "list")
	}
}
