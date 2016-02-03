<%=packageName ? "package ${packageName}\n\n" : ''%>

import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.test.mixin.*
import spock.lang.*

@TestFor(${className}Controller)
@Mock(${className})
class ${className}ControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params['name'] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The response is correct"
            response.status == OK.value
            response.text == ([] as JSON).toString()
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            // Make sure the domain class has at least one non-null property
            // or this test will fail.
            def ${propertyName} = new ${className}()
            controller.save(${propertyName})

        then:"The response status is NOT_ACCEPTABLE"
            response.status == NOT_ACCEPTABLE.value

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            ${propertyName} = new ${className}(params)

            controller.save(${propertyName})

        then:"The response status is CREATED and the instance is returned"
            response.status == CREATED.value
            response.text == (${propertyName} as JSON).toString()
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"The response status is NOT_FOUND"
            response.status == NOT_FOUND.value

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def ${propertyName} = new ${className}()
            controller.update(${propertyName})

        then:"The response status is NOT_ACCEPTABLE"
            response.status == NOT_ACCEPTABLE.value

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            ${propertyName} = new ${className}(params).save(flush: true)
            controller.update(${propertyName})

        then:"The response status is OK and the updated instance is returned"
            response.status == OK.value
            response.text == (${propertyName} as JSON).toString()
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A NOT_FOUND is returned"
            response.status == NOT_FOUND.value

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def ${propertyName} = new ${className}(params).save(flush: true)

        then:"It exists"
            ${className}.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(${propertyName})

        then:"The instance is deleted"
            ${className}.count() == 0
            response.status == NO_CONTENT.value
    }
}
