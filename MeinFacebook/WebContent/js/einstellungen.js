function modifySettings(parameter){
	var neuerWert = window.prompt("Aktualisiere MiniFacebook mit deiner Eingabe:", document.getElementById(parameter).value);
	document.getElementById(parameter).value = neuerWert;
	alert("MiniFacebook ist jetzt wieder aktuell.");
}