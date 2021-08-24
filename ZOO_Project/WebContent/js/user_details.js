
document.querySelector('.submit').addEventListener('click',function(e){
	
	var url = window.location.href;
	var queryString = url.split('?')[1];
	var params = queryString.split('&');
	var userId = parseInt(params[0].split('=')[1]);
	var from = parseInt(params[1].split('=')[1]);
	var limit = parseInt(params[2].split('=')[1]);
	console.log(userId);
	console.log(from);
	console.log(limit);
	document.getElementById('userId').value = userId;
	document.getElementById('from').value = limit+1;
	document.getElementById('limit').value = limit+5;
	
});

