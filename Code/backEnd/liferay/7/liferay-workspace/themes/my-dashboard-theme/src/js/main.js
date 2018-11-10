AUI().ready(

	/*
	This function gets loaded when all the HTML, not including the portlets, is
	loaded.
	*/

	function() {
	    // code for moment.js
        require(['moment'], function(moment) {
            console.log("Hey it works now !!!  " + moment().format());
        }, function(error) {
            console.error(error);
        });

        //Loading jQuery asynchronously
        require(['jquery'], function($) {
            $(window).scroll(function(e){
                parallax();
            });

            function parallax(){
                var scrolled = $(window).scrollTop();
                $('.bg').css('bottom',-(scrolled*0.1)+'px');
            }
        });

        //Loading tooltipster asynchronously
        require(['jquery','tooltipster'], function($, tooltipster ) {
            console.dir( $ ) // OK
            console.dir( tooltipster ) // OK
            $('#demo-image').tooltipster();
            $('#demo-span').tooltipster();
            $('#demo-span-click').tooltipster({trigger: 'click'});
            $('.tooltip').tooltipster({
                contentCloning: true
            });
            $('#demo-html').tooltipster({
                trigger: 'custom',
                triggerOpen: {
                    mouseenter: true
                },
                triggerClose: {
                    mouseleave: true
                },
                contentCloning: true
            });
        });

	}


);

Liferay.Portlet.ready(

	/*
	This function gets loaded after each and every portlet on the page.

	portletId: the current portlet's id
	node: the Alloy Node object of the current portlet
	*/

	function(portletId, node) {
	}
);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
	}
);

