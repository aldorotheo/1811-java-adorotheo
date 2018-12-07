/**
 * 
 */

window.onload = function(){

	jQuery.get("/Project1/trms/manage", function(responseText) {
		$("#Tim").empty();
		var parser = JSON.parse(responseText);
    	for(var i = 0; i < parser.length; i++) {
    		$("#Tim").append('<tr>');
    		$("#Tim").append("<td>"+parser[i].req_id+"</td>");
    		$("#Tim").append("<td>"+parser[i].emp_id+"</td>");
    		$("#Tim").append("<td>"+new Date(parser[i].s_date).toDateString()+"</td>");
    		$("#Tim").append("<td>"+parser[i].s_time+"</td>");
    		$("#Tim").append("<td>"+parser[i].s_location+"</td>");
    		$("#Tim").append("<td>"+parser[i].description+"</td>");
    		$("#Tim").append("<td>"+parser[i].s_cost+"</td>");
    		$("#Tim").append("<td>"+parser[i].g_format+"</td>");
    		$("#Tim").append("<td>"+parser[i].ev_type+"</td>");
    		$("#Tim").append("<td>"+parser[i].just+"</td>");
    		$("#Tim").append("<td>"+parser[i].t_missed+"</td>");
    		$("#Tim").append("<td>"+parser[i].finalg+"</td>");
    		$("#Tim").append("<td>"+parser[i].status+"</td>");
    		$("#Tim").append("<td>"+parser[i].urgency+"</td>");
    		$("#Tim").append("</tr>");
    	}
    });
	jQuery(window).on("load", function() {
		console.log("something is happening");
	    jQuery.get("/Project1/trms/manage", function(responseText) { 
	    	$("#Tim").empty();
			var parser = JSON.parse(responseText);
			for(var i = 0; i < parser.length; i++) {
	    		$("#Tim").append('<tr>');
	    		$("#Tim").append("<td>"+parser[i].req_id+"</td>");
	    		$("#Tim").append("<td>"+parser[i].emp_id+"</td>");
	    		$("#Tim").append("<td>"+new Date(parser[i].s_date).toDateString()+"</td>");
	    		$("#Tim").append("<td>"+parser[i].s_time+"</td>");
	    		$("#Tim").append("<td>"+parser[i].s_location+"</td>");
	    		$("#Tim").append("<td>"+parser[i].description+"</td>");
	    		$("#Tim").append("<td>"+parser[i].s_cost+"</td>");
	    		$("#Tim").append("<td>"+parser[i].g_format+"</td>");
	    		$("#Tim").append("<td>"+parser[i].ev_type+"</td>");
	    		$("#Tim").append("<td>"+parser[i].just+"</td>");
	    		$("#Tim").append("<td>"+parser[i].t_missed+"</td>");
	    		$("#Tim").append("<td>"+parser[i].finalg+"</td>");
	    		$("#Tim").append("<td>"+parser[i].status+"</td>");
	    		$("#Tim").append("<td>"+parser[i].urgency+"</td>");
	    		$("#Tim").append("</tr>");
	    	}
	    });
	})

	$(document).on("click", "#getRequests", function() {
        jQuery.get("/Project1/trms/manage", function(responseText) { 
        	$("#Tim").empty();
    		var parser = JSON.parse(responseText);
    		for(var i = 0; i < parser.length; i++) {
        		$("#Tim").append('<tr>');
        		$("#Tim").append("<td>"+parser[i].req_id+"</td>");
        		$("#Tim").append("<td>"+parser[i].emp_id+"</td>");
        		$("#Tim").append("<td>"+new Date(parser[i].s_date).toDateString()+"</td>");
        		$("#Tim").append("<td>"+parser[i].s_time+"</td>");
        		$("#Tim").append("<td>"+parser[i].s_location+"</td>");
        		$("#Tim").append("<td>"+parser[i].description+"</td>");
        		$("#Tim").append("<td>"+parser[i].s_cost+"</td>");
        		$("#Tim").append("<td>"+parser[i].g_format+"</td>");
        		$("#Tim").append("<td>"+parser[i].ev_type+"</td>");
        		$("#Tim").append("<td>"+parser[i].just+"</td>");
        		$("#Tim").append("<td>"+parser[i].t_missed+"</td>");
        		$("#Tim").append("<td>"+parser[i].finalg+"</td>");
        		$("#Tim").append("<td>"+parser[i].status+"</td>");
        		$("#Tim").append("<td>"+parser[i].urgency+"</td>");
        		$("#Tim").append("</tr>");
        	}
        });
	})
	$(document).on("click", "#getEmpRequests", function() {
        jQuery.get("/Project1/trms/manage/emp", function(responseText) { 
        	$("#Tim").empty();
    		var parser = JSON.parse(responseText);
    		for(var i = 0; i < parser.length; i++) {
        		$("#Tim").append('<tr>');
        		$("#Tim").append("<td>"+parser[i].req_id+"</td>");
        		$("#Tim").append("<td>"+parser[i].emp_id+"</td>");
        		$("#Tim").append("<td>"+new Date(parser[i].s_date).toDateString()+"</td>");
        		$("#Tim").append("<td>"+parser[i].s_time+"</td>");
        		$("#Tim").append("<td>"+parser[i].s_location+"</td>");
        		$("#Tim").append("<td>"+parser[i].description+"</td>");
        		$("#Tim").append("<td>"+parser[i].s_cost+"</td>");
        		$("#Tim").append("<td>"+parser[i].g_format+"</td>");
        		$("#Tim").append("<td>"+parser[i].ev_type+"</td>");
        		$("#Tim").append("<td>"+parser[i].just+"</td>");
        		$("#Tim").append("<td>"+parser[i].t_missed+"</td>");
        		$("#Tim").append("<td>"+parser[i].finalg+"</td>");
        		$("#Tim").append("<td>"+parser[i].status+"</td>");
        		$("#Tim").append("<td>"+parser[i].urgency+"</td>");
        		$("#Tim").append("</tr>");
        	}
        });
	})
	$(document).on("click", "#getRequest", function() {
		let req_id = document.getElementById("id").value;
        jQuery.get("/Project1/trms/manage/"+req_id, function(responseText) { 
        	$("#Tim").empty();
    		var parser = JSON.parse(responseText);
    		for(var i = 0; i < parser.length; i++) {
        		$("#Tim").append('<tr>');
        		$("#Tim").append("<td>"+parser[i].req_id+"</td>");
        		$("#Tim").append("<td>"+parser[i].emp_id+"</td>");
        		$("#Tim").append("<td>"+new Date(parser[i].s_date).toDateString()+"</td>");
        		$("#Tim").append("<td>"+parser[i].s_time+"</td>");
        		$("#Tim").append("<td>"+parser[i].s_location+"</td>");
        		$("#Tim").append("<td>"+parser[i].description+"</td>");
        		$("#Tim").append("<td>"+parser[i].s_cost+"</td>");
        		$("#Tim").append("<td>"+parser[i].g_format+"</td>");
        		$("#Tim").append("<td>"+parser[i].ev_type+"</td>");
        		$("#Tim").append("<td>"+parser[i].just+"</td>");
        		$("#Tim").append("<td>"+parser[i].t_missed+"</td>");
        		$("#Tim").append("<td>"+parser[i].finalg+"</td>");
        		$("#Tim").append("<td>"+parser[i].status+"</td>")
        		$("#Tim").append("<td>"+parser[i].urgency+"</td>");
        		$("#Tim").append("</tr>");
        	}
        });
	})

};