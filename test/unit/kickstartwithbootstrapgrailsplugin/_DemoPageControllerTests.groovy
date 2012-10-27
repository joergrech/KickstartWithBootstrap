package kickstartwithbootstrapgrailsplugin



import org.junit.*
import grails.test.mixin.*

/**
 * _DemoPageControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(_DemoPageController)
@Mock(_DemoPage)
class _DemoPageControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/_DemoPage/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model._DemoPageInstanceList.size() == 0
        assert model._DemoPageInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model._DemoPageInstance != null
    }

    void testSave() {
        controller.save()

        assert model._DemoPageInstance != null
        assert view == '/_DemoPage/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/_DemoPage/show/1'
        assert controller.flash.message != null
        assert _DemoPage.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/_DemoPage/list'


        populateValidParams(params)
        def _DemoPage = new _DemoPage(params)

        assert _DemoPage.save() != null

        params.id = _DemoPage.id

        def model = controller.show()

        assert model._DemoPageInstance == _DemoPage
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/_DemoPage/list'


        populateValidParams(params)
        def _DemoPage = new _DemoPage(params)

        assert _DemoPage.save() != null

        params.id = _DemoPage.id

        def model = controller.edit()

        assert model._DemoPageInstance == _DemoPage
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/_DemoPage/list'

        response.reset()


        populateValidParams(params)
        def _DemoPage = new _DemoPage(params)

        assert _DemoPage.save() != null

        // test invalid parameters in update
        params.id = _DemoPage.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/_DemoPage/edit"
        assert model._DemoPageInstance != null

        _DemoPage.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/_DemoPage/show/$_DemoPage.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        _DemoPage.clearErrors()

        populateValidParams(params)
        params.id = _DemoPage.id
        params.version = -1
        controller.update()

        assert view == "/_DemoPage/edit"
        assert model._DemoPageInstance != null
        assert model._DemoPageInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/_DemoPage/list'

        response.reset()

        populateValidParams(params)
        def _DemoPage = new _DemoPage(params)

        assert _DemoPage.save() != null
        assert _DemoPage.count() == 1

        params.id = _DemoPage.id

        controller.delete()

        assert _DemoPage.count() == 0
        assert _DemoPage.get(_DemoPage.id) == null
        assert response.redirectedUrl == '/_DemoPage/list'
    }
}
