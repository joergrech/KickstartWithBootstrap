package kickstart

class KickstartFilters {

	def filters = {
		kickstartLogger() {
			before = {
				// Small "logging" filter for controller & actions
				if (log.infoEnabled) {
					log.info(!params.controller ? '/: ' + params : params.controller +"."+(params.action ?: "index")+": "+params)
				}
			}
		}
	}
}
