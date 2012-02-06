package kickstart

class KickstartFilters {

    def filters = {
        all() {
            before = {

				// Small console "logging" filter
                println !params.controller ? '/: ' + params : params.controller +"."+(params.action ?: "index")+": "+params
            }
            after = {
                
            }
            afterView = {
                
            }
        }
    }
    
}
