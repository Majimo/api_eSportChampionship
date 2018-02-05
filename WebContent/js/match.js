function err(status) {
	alert("erreur Traitement AjaxServlet :" + status);
}

function listMatch(resultat) {
	json = JSON.parse(resultat);
	var j = json.match;

	if (j.length === undefined) {
		var table = document.createElement('table');
		table.className = 'table table-striped';

		var tHead = document.createElement('thead');
		tHead.innerHTML = '<tr><th></th><th>Joueur 1</th><th></th><th>Joueur 2</th></tr>';
		table.appendChild(tHead);

		var tBody = document.createElement('tbody');
		table.appendChild(tBody);

		var trMatch = document.createElement('tr');

		var tdId = document.createElement('td');
		tdId.innerHTML = 1;
		var tdPseudo1 = document.createElement('td');
		tdPseudo1.innerHTML = j.j1Pseudo + '<a href="#" class="sansLabel btn btn-primary mb-3" style="float:right">Gagnant ?</a>';
		var tdVS = document.createElement('td');
		tdVS.innerHTML = 'VS';
		tdVS.style = 'font-size:1.5em;color:red;font-weight:bold';
		var tdPseudo2 = document.createElement('td');
		tdPseudo2.innerHTML = j.j2Pseudo + '<a href="#" class="sansLabel btn btn-primary mb-3" style="float:right">Gagnant ?</a>';

		trMatch.appendChild(tdId);
		trMatch.appendChild(tdPseudo1);
		trMatch.appendChild(tdVS);
		trMatch.appendChild(tdPseudo2);

		tBody.appendChild(trMatch);
		document.getElementById("listMatch").appendChild(table);
	} else {
		for (var i = 0; i < j.length; i++) {
			var table = document.createElement('table');
			table.className = 'table table-striped';

			var tHead = document.createElement('thead');
			tHead.innerHTML = '<tr><th></th><th>Joueur 1</th><th></th><th>Joueur 2</th></tr>';
			table.appendChild(tHead);

			var tBody = document.createElement('tbody');
			table.appendChild(tBody);

			for (var i = 0; i < j.length; i++) {

				var trMatch = document.createElement('tr');

				var tdId = document.createElement('td');
				tdId.innerHTML = i + 1;
				var tdPseudo1 = document.createElement('td');
				tdPseudo1.innerHTML = j[i].j1Pseudo + '<a href="#" class="sansLabel btn btn-primary mb-3" style="float:right">Gagnant ?</a>';
				var tdVS = document.createElement('td');
				tdVS.innerHTML = 'VS';
				tdVS.style = 'font-size:1.5em;color:red;font-weight:bold';
				var tdPseudo2 = document.createElement('td');
				tdPseudo2.innerHTML = j[i].j2Pseudo + '<a href="#" class="sansLabel btn btn-primary mb-3" style="float:right">Gagnant ?</a>';

				trMatch.appendChild(tdId);
				trMatch.appendChild(tdPseudo1);
				trMatch.appendChild(tdVS);
				trMatch.appendChild(tdPseudo2);

				tBody.appendChild(trMatch);
			}
			document.getElementById("listMatch").appendChild(table);		
	}
		console.log("affiché");
	}
}