/* 
 * Funktions-Aufruf bei onclick, gibt Name des Feldes mit
 * 1. Prompt öffnen mit der Aufforderung: "Bitte aktualisiere das Feld"
 * 2. Eingabewert wird als neuen Wert zurück in feldname.value geschrieben
 */


function changeSettings(feldname){
	var neuerWert = window.prompt("Bitte gebe hier deine gewuenschte Aktualisierung ein", document.getElementById(feldname).value);
	document.getElementById(feldname).value = neuerWert;
}