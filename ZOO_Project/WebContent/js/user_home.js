
var url = window.location.href;
if(sessionStorage["username"] === undefined)
{
	var queryString = url.split('?')[1];
	var params  = queryString.split('&');
	var paramMap = {};
	params.forEach( function(param) {
		paramMap[param.split('=')[0]] = param.split('=')[1];
	});
	console.log(paramMap);

	sessionStorage["userId"] = paramMap["userId"];
	sessionStorage["username"] = paramMap["username"];
	
}


console.log(sessionStorage);
document.querySelector('.name').textContent = sessionStorage["username"];


var userId = sessionStorage['userId'];
console.log(userId);

document.querySelector('.submit').addEventListener('click',function(e){
	
	document.getElementById('userId').value = userId;
	document.getElementById('from').value = 1;
	document.getElementById('limit').value = 5;
	
});

document.querySelector('.button').addEventListener('click',function(e){
	
	sessionStorage.clear();	
	console.log("SessionCleared");
	console.log();
	
});


