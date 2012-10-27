package kickstart

class KickstartFilters {

    def filters = {
        all() {
            before = {
				// Small "logging" filter for controller & actions
                println !params.controller ? '/: ' + params : params.controller +"."+(params.action ?: "index")+": "+params
				// Better logging: needs to be switched on in Config.groovy and is a little bit verbose
				//	log.info(!params.controller ? '/: ' + params : params.controller +"."+(params.action ?: "index")+": "+params)

				if (params.layout) 				session.layout	= params.layout
				if (params.skin)				session.skin 	= params.skin
//				if (!session.skin)				session.skin 	= "bootstrap"

				// Identify RTL (right-to-left) languages
				if (params.lang) {
					if (params.lang == "sa")	session.menuposition = "right"
					else 						session.menuposition = "left"
				}
			}
			after = {
            }
            afterView = {
            }
        }
    }
}
