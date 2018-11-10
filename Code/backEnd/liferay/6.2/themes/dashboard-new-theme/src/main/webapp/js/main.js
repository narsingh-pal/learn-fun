$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
        $('#profilePicture').toggleClass('active');
    });
    
    $('#sidebarCollapse1').on('click', function () {
        $('#sidebar').toggleClass('active');
        $('#profilePicture').toggleClass('active');
        $(this).toggleClass('active');
    });
    
    $("#publicNavBar").autoHidingNavbar();
    
    //megamenu
    $(".dropdown").hover(
            function() { $('.dropdown-menu', this).stop().fadeIn("fast");
            },
            function() { $('.dropdown-menu', this).stop().fadeOut("fast");
        });
    
    
    
  
    $.force_appear();
    
    
});         
             
             
AUI().ready(

	/*
	This function gets loaded when all the HTML, not including the portlets, is
	loaded.
	*/

	function() {
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