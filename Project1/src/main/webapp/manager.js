/**
 * 
 */
//function getRequest() {
//	console.log("request being sent");
//	let xhr = new XMLHttpRequest();
//	let req_id = document.getElementById("id").value;
//	xhr.onreadystatechange = function() {
//		if(xhr.readyState == 4 && xhr.status == 200) {
//			
//			let request = JSON.parse(xhr.responseText);
//			document.getElementById("result").innerHTML = request;
//		}
//	}
//	xhr.open("GET", "trms/manage/" + req_id, true);
//	xhr.send();
//}
//
//function getRequests() {
//	console.log("requests being sent");
//	let xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function() {
//		if(xhr.readyState == 4 && xhr.status == 200) {
//			let request = JSON.parse(xhr.responseText);
//			document.getElementById("result").innerHTML = request;
//		}
//	}
//	xhr.open("GET", "trms/manage", true);
//	xhr.send();
//}

window.onload = function(){
//	document.getElementById("getRequests").addEventListener("click", getRequests());
//	document.getElementById("getRequest").addEventListener("click", getRequest());
	$(document).on("click", "#getRequests", function() {
        jQuery.get("/Project1/trms/manage", function(responseText) { 
        	$("#Tim").text(responseText);
        });
	})
	$(document).on("click", "#getRequest", function() {
		let req_id = document.getElementById("id").value;
        jQuery.get("/Project1/trms/manage/"+req_id, function(responseText) { 
        	$("#Tim").text(responseText);
        });
	})

};