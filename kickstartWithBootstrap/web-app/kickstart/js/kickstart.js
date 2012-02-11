if (typeof jQuery !== 'undefined') {
	$(document).ready(function() {
		/**
		 * Dropdown logic for topbar nav (bootstrap)
		 */
		$("body").bind("click", function (e) {
			$('.dropdown-toggle, .menu').parent("li").removeClass("open");
		});
		$(".dropdown-toggle, .menu").click(function (e) {
			var $li = $(this).parent("li").toggleClass('open');
			return false;
		}); 

		/**
		 * Grails 2.0.0 Spinner
		 */ 
		(function($) {
			$('#spinner').ajaxStart(function() {
				$(this).fadeIn();
			}).ajaxStop(function() {
				$(this).fadeOut();
			});
		})(jQuery);
	});
}

// Grails 1.3.7 Spinner
//var Ajax;
//if (Ajax && (Ajax != null)) {
//	Ajax.Responders.register({
//	  onCreate: function() {
//        if($('spinner') && Ajax.activeRequestCount>0)
//          Effect.Appear('spinner',{duration:0.5,queue:'end'});
//	  },
//	  onComplete: function() {
//        if($('spinner') && Ajax.activeRequestCount==0)
//          Effect.Fade('spinner',{duration:0.5,queue:'end'});
//	  }
//	});
//}
