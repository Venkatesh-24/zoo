
document.querySelector('.signUp').addEventListener('click', function(){

	document.querySelector('.signUp-form').classList.remove('hidden');
	document.querySelector('.signIn-form').classList.add('hidden');

});


document.querySelector('.signIn').addEventListener('click', function(){

	document.querySelector('.signIn-form').classList.remove('hidden');
	document.querySelector('.signUp-form').classList.add('hidden');

});
