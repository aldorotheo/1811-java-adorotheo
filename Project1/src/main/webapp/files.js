/**
 * 
 */

function getFiles(){
	let xhr = new XMLHttpRequest();
	xhr.open("POST", "trms/request", true);
	let fd = new FormData();
	let files = document.getElementById("filess");
	for (var i = 0; i < files.files.length; i++) {
		console.log("IS IT?")
		fd.append( 'file', files.files[i] );
//		xhr.send(JSON.stringify(files[i]));
	};

	console.log(fd.entries());
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
		console.log("Yes");
		};
	};
	xhr.send( fd );
};

window.onload = function(){
	let form = document.getElementById("myForm")
	form.addEventListener("submit", getFiles);
//	$.post
//	$(document).on("submit", "#myForm", function() {
//        jQuery.post("/Project1/trms/request", getFiles);
//	});
};