/**
 * 
 */
      $(function() {

        $.getJSON('JSONServlet', 
        	    function(response) {
    			  $('<option value="">&mdash; choose a style &mdash;</option>').appendTo('#bootChooserControl');
    			    $.each(response, function() {
          			  	$('<option value="' + this.productId + '">'+this.description+'</option>').
          			  	appendTo('#bootChooserControl');
    			      });
        	    });
        
		
      });



