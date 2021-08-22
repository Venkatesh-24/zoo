/**
 * 
 */

var id = sessionStorage['id'];

$.ajax({
	url : '/ZOO/webapi/details/minDetail/' + id,
	type:'GET',
	success : function(data){
		var dataJSON = JSON.parse(data);
		console.log(dataJSON);
		var html = '';
		for(var x = 0; x < dataJSON.length; x++)
		{
			var key = dataJSON[x];
			var val = dataJSON[x];
		    //html +='<div>' + key + '   ' + val + '   ' + '<icon' + '<br></div>';
		}
		//document.querySelector('#mindetails').innerHTML = html;
	}
})