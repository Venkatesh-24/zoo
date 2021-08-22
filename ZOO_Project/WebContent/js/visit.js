
var sum = 0;
var anotherPay = NaN;
var animalList = document.querySelectorAll('.animal');
animalList = Array.from(animalList);


selectAnimals(true);

function selectAnimals(val) {

	
	animalList.forEach(function(cur){
		cur.disabled = val;
	});

}


document.querySelector('.pay').addEventListener('click',function(){

	var fareEntered = parseInt(document.querySelector('.fare').value);
	console.log('outside',fareEntered);

	//console.log(Number.isNaN(fareEntered));

	
	if(!Number.isNaN(fareEntered) && fareEntered !== anotherPay)
	{
	//	document.querySelector('.fare').value = NaN;
	//	document.querySelector('.fare').disabled = true;
	//	document.querySelector('.pay').disabled = true;
		selectAnimals(false);
		console.log('Inside', fareEntered);
	//	console.log('h');
	}
	anotherPay = fareEntered;

});

document.querySelector('.animalsPresent').addEventListener('click',function(event){

	console.log('anotherPay',anotherPay);

	var fareEntered = parseInt(document.querySelector('.fare').value);
	console.log('farePay', fareEntered);

	var str = event.target.id;
//	console.log(str);
	var splitArr = str.split('_');

	var cost = parseInt(splitArr[2]);	

	if(str && anotherPay !== fareEntered)
	{
		document.getElementById(str).checked = false;
		selectAnimals(true);
	}

	else
	{
		if(str && document.getElementById(str).checked)
		{	
			sum = sum + cost;
			console.log('add sum is', sum);
		//	console.log(fareEntered);

			if(sum > fareEntered)
			{
				alert("Sorry Your Fare Amount is insufficient");
				document.getElementById(str).checked = false;
				sum = sum - cost;
			}
		}
		else if(str && !document.getElementById(str).checked)
		{
			sum = sum - parseInt(splitArr[2]);
			console.log('del sum is', sum);
		}
	}

});
console.log(sessionStorage);

		
document.querySelector('.userId').value = sessionStorage['userId'];




