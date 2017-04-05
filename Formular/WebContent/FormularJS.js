//Variante 1: Replace existing content of p-Element
function replace(){
	var neuerText = document.getElementById("wert").value;
	
	document.getElementById("absatz").innerHTML = neuerText;
}

//Variante 2: Append new content
function append(){
	var neuerText = document.getElementById("wert").value;
	
	var neuerKnoten = document.createElement("h4");
	var knoteninhalt = document.createTextNode(neuerText);
	neuerKnoten.appendChild(knoteninhalt);
	document.getElementById("absatz").appendChild(neuerKnoten);
}