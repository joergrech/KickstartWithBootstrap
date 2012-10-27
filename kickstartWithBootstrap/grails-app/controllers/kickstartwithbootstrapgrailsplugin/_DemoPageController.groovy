package kickstartwithbootstrapgrailsplugin

import org.springframework.dao.DataIntegrityViolationException

/**
 * _DemoPageController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class _DemoPageController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [_DemoPageInstanceList: _DemoPage.list(params), _DemoPageInstanceTotal: _DemoPage.count()]
    }

    def create() {
        [_DemoPageInstance: new _DemoPage(params)]
    }

    def save() {
        def _DemoPageInstance = new _DemoPage(params)
        if (!_DemoPageInstance.save(flush: true)) {
            render(view: "create", model: [_DemoPageInstance: _DemoPageInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: '_DemoPage.label', default: '_DemoPage'), _DemoPageInstance.id])
        redirect(action: "show", id: _DemoPageInstance.id)
    }

    def show() {
        def _DemoPageInstance = _DemoPage.get(params.id)
        if (!_DemoPageInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: '_DemoPage.label', default: '_DemoPage'), params.id])
            redirect(action: "list")
            return
        }

        [_DemoPageInstance: _DemoPageInstance]
    }

    def edit() {
        def _DemoPageInstance = _DemoPage.get(params.id)
        if (!_DemoPageInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: '_DemoPage.label', default: '_DemoPage'), params.id])
            redirect(action: "list")
            return
        }

        [_DemoPageInstance: _DemoPageInstance]
    }

    def update() {
        def _DemoPageInstance = _DemoPage.get(params.id)
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

        if (!_DemoPageInstance.save(flush: true)) {
            render(view: "edit", model: [_DemoPageInstance: _DemoPageInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: '_DemoPage.label', default: '_DemoPage'), _DemoPageInstance.id])
        redirect(action: "show", id: _DemoPageInstance.id)
    }

    def delete() {
        def _DemoPageInstance = _DemoPage.get(params.id)
        if (!_DemoPageInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: '_DemoPage.label', default: '_DemoPage'), params.id])
            redirect(action: "list")
            return
        }

        try {
            _DemoPageInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: '_DemoPage.label', default: '_DemoPage'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: '_DemoPage.label', default: '_DemoPage'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
