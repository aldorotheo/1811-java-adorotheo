/**
 * 
 */

window.onload = function(){

	jQuery.post("/Project1/trms/message/unread", function(responseText) { 
    	$("#Tim").empty();
		var parser = JSON.parse(responseText);
		for(var i = 0; i < parser.length; i++) {
    		$("#Tim").append('<tr>');
    		$("#Tim").append("<td>"+parser[i].messageID+"</td>");
    		$("#Tim").append("<td>"+parser[i].senderID+"</td>");
    		$("#Tim").append("<td>"+parser[i].message+"</td>");
    		$("#Tim").append("</tr>");
    	}
    });
	jQuery(window).on("load", function() {
		jQuery.post("/Project1/trms/message/unread", function(responseText) { 
        	$("#Tim").empty();
    		var parser = JSON.parse(responseText);
    		for(var i = 0; i < parser.length; i++) {
    			$("#Tim").append('<tr>');
        		$("#Tim").append("<td>"+parser[i].messageID+"</td>");
        		$("#Tim").append("<td>"+parser[i].senderID+"</td>");
        		$("#Tim").append("<td>"+parser[i].message+"</td>");
        		$("#Tim").append("</tr>");

        	}
        });
	})

	$(document).on("click", "#getMessages", function() {
        jQuery.post("/Project1/trms/message", function(responseText) { 
        	$("#Tim").empty();
    		var parser = JSON.parse(responseText);
    		for(var i = 0; i < parser.length; i++) {
    			$("#Tim").append('<tr>');
        		$("#Tim").append("<td>"+parser[i].messageID+"</td>");
        		$("#Tim").append("<td>"+parser[i].senderID+"</td>");
        		$("#Tim").append("<td>"+parser[i].message+"</td>");
        		$("#Tim").append("</tr>");

        	}
        });
	})
}