package kickstart

import groovy.time.TimeCategory

class KickstartFilters {
	Date start
	Date stop

    def filters = {
        all() {
            before = {
				// Small console "logging" filter
                println !params.controller ? '/: ' + params : params.controller +"."+(params.action ?: "index")+": "+params
				start = new Date()
			}
			after = {
				stop = new Date()
				println "... Total elapsed time: " + TimeCategory.minus( stop, start )
            }
            afterView = {
                
            }
        }
    }
}
