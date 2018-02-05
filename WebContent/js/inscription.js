function err(status) {
	alert("erreur Traitement AjaxServlet :" + status);
}
function listTournoi(resultat) {
	json = JSON.parse(resultat);
	var j = json.tournoi;
	console.log(j);
	for (var i = 0; i < j.length; i++) {
		var option = document.createElement('option');
		option.value = j[i].id;
		option.innerHTML = j[i].jeu + ", le " + j[i].dateTournoi;

		document.getElementById("listTournoi").appendChild(option);
	}
}