
var url = window.location.href;

var queryString = url.split('?')[1];

var params  = queryString.split('&');

var paramMap = {};
params.forEach( function(param) {
	paramMap[param.split('=')[0]] = param.split('=')[1];
});
console.log(paramMap);

sessionStorage["userId"] = paramMap["userId"];
sessionStorage["username"] = paramMap["username"];

console.log(sessionStorage);
document.querySelector('.name').textContent = sessionStorage["username"];

