//Taschenrechner, Funktion eval() ist nicht erlaubt!
var Operand1="";
var rechenEingabe = [];

function Hinzufuegen(Zeichen){
	//alles als String einlesen
	//kleine Hilfestellung
	var rechnerausgabe = document.getElementById("ergebnis")

	rechenEingabe.push(Zeichen);
	Operand1 = 
	window.document.Taschenrechner.Hauptanzeige.value + Zeichen;
	window.document.Taschenrechner.Hauptanzeige.value = Operand1
	//kleine Hilfestellung
	rechnerausgabe.innerHTML = rechenEingabe.toString();
}

function Ergebnis(){
	//String bei Operatoren splitten
	//Bsp.Array = [1,+,5,/,2]
	var zwischenErgebnis = parseInt(rechenEingabe[0]);
	var operand22;
	if(rechenEingabe.length > 2 ){
		for(i = 2; i < rechenEingabe.length; i++){
			if(i % 2 == 0){
				operand22 = parseInt(rechenEingabe[i])		
			}
			switch (rechenEingabe[i-1]){
	        case "+":
	            zwischenErgebnis += operand22;
	            break;
	        case "-":
	        	zwischenErgebnis -= operand22;
	        	break;
	        case "*":
	        	zwischenErgebnis *= operand22;
	        	break;
	        case "/":
	        	zwischenErgebnis/= operand22
			}
		}  //Todo:Fehler abfangen
	}
	window.document.Taschenrechner.Hauptanzeige.value = zwischenErgebnis;
}

function Clear(){
	//Array leeren
	//Display/bzw. "Hauptanzeige.value" reset
}
