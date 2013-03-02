package kickstart

class KickstartFilters {

    def filters = {
        all() {
            before = {
				// Small "logging" filter for controller & actions
				log.info(!params.controller ? '/: ' + params : params.controller +"."+(params.action ?: "index")+": "+params)
			}
			after = {
            }
            afterView = {
            }
        }
    }
}
