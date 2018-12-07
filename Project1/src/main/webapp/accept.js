/**
 * 
 */
window.onload=function(){
	$(document).on("click", "#getRequest", function() {
		let req_id = document.getElementById("id").value;
        jQuery.get("/Project1/trms/manage/"+req_id, function(responseText) { 
        	$("#Tim").empty();
        	$("#Tim").append(`<thead>
  <tr>
  <th class="head">Request ID</th>
  <th class="head">Employee ID</th>
  <th class="head">Start Date</th>
  <th class="head">Start Time</th>
  <th class="head">Location</th>
  <th class="head">Description</th>
  <th class="head">Amount</th>
  <th class="head">Format</th>
  <th class="head">Event</th>
  <th class="head">Justification</th>
  <th class="head">Time Missed</th>
  <th class="head">Final Grade</th>
  <th class="head">Status</th>
  <th class="head">Urgency</th>
  </tr>
  </thead>
  <tbody>`)
    		var parser = JSON.parse(responseText);
    		$("#Tim").append('<tr>');
        	for(var i = 0; i < parser.length; i++) {
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
        	}
        	$("#Tim").append("</tr>");
        	$("#Tim").append("</tbody>")
        	$("#Tim").append("</table>")
        });
	})
}