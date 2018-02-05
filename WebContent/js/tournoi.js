function err(status) {
	alert("erreur Traitement AjaxServlet :" + status);
}

function listTournoi(resultat) {
	json = JSON.parse(resultat);
	var j = json.tournoi;
	for (var i = 0; i < j.length; i++) {
		var tr = document.createElement('div');
		tr.id = j[i].id;
		tr.className = 'col-md-4';

		var tdJeu = document.createElement('div');
		tdJeu.innerHTML = j[i].jeu;
		tdJeu.className = 'h3';
		
		var tdArbreCreate = document.createElement('div');
		tdArbreCreate.innerHTML = '<a href="#" onclick="executerRequete(\'../rest/administration/tournoi/arbre/generer/'
			+ j[i].id
			+ '\', \'\', arbreCreate, err);" class="sansLabel btn btn-primary mb-1">Créer Arbre</a>';

		var tdArbreAffiche = document.createElement('div');
		tdArbreAffiche.innerHTML = '<a target="_blank" href="../rest/front/match/afficher/' + j[i].id + '" class="sansLabel btn btn-primary mb-3">Afficher Arbre</a>';

		var tdListe = document.createElement('div');
		tdListe.innerHTML = '<a href="#" onclick="executerRequete(\'../rest/administration/tournoi/afficher/joueurs/'
				+ j[i].id
				+ '\', \'\',listJoueur, err);" class="sansLabel btn btn-primary mb-3">Liste des Joueurs</a>';

		var listJoueur = document.createElement('div');
		listJoueur.id = 'listJoueur' + j[i].id;
		listJoueur.className = 'mb-4';
		listJoueur.innerHTML = '';

		tr.appendChild(tdJeu);
		tr.appendChild(tdArbreCreate);
		tr.appendChild(tdArbreAffiche);
		tr.appendChild(tdListe);
		tr.appendChild(listJoueur);

		document.getElementById("tableTournoi").appendChild(tr);
	}
}

function arbreCreate(){
	alert("L'arbre a bien été créé !");
}

function listJoueur(resultat) {
	json = JSON.parse(resultat);
	if (json == null) {
		alert("Pas de joueurs inscrits sur ce tournoi");
	} else {
		var j = json.joueur;

		if (j.length === undefined) {
			document.getElementById("listJoueur" + j.idTournoi).innerHTML = "";
			console.log("effacement");
			alert("Pas assez de joueurs pour faire un tournoi dans ce jeu");
			
			var table = document.createElement('table');
			table.className = 'table table-striped';

			var tHead = document.createElement('thead');
			tHead.innerHTML = '<tr><th>Pseudo</th><th>Nom - Prénom</th></tr>';
			tHead.className = 'thead-inverse';
			table.appendChild(tHead);
			
			var tBody = document.createElement('tbody');
			table.appendChild(tBody);

			var trJoueur = document.createElement('tr');
			
			var tdPseudo = document.createElement('td');
			tdPseudo.innerHTML = j.pseudo;
			var tdNom = document.createElement('td');
			tdNom.innerHTML = j.nom + " " + j.prenom;
			
			trJoueur.appendChild(tdPseudo);
			trJoueur.appendChild(tdNom);

			tBody.appendChild(trJoueur);
			
			console.log("affiché");
			document.getElementById("listJoueur" + j.idTournoi).appendChild(table);
		} else {
			document.getElementById("listJoueur" + j[0].idTournoi).innerHTML = "";
			console.log("effacement");
			var table = document.createElement('table');
			table.className = 'table table-striped';

			var tHead = document.createElement('thead');
			tHead.innerHTML = '<tr><th>Pseudo</th><th>Nom - Prénom</th></tr>';
			tHead.className = 'thead-inverse';
			table.appendChild(tHead);
			
			var tBody = document.createElement('tbody');
			table.appendChild(tBody);
			
			for (var i = 0; i < j.length; i++) {

				var trJoueur = document.createElement('tr');
				
				var tdPseudo = document.createElement('td');
				tdPseudo.innerHTML = j[i].pseudo;
				var tdNom = document.createElement('td');
				tdNom.innerHTML = j[i].nom + " " + j[i].prenom;
				
				trJoueur.appendChild(tdPseudo);
				trJoueur.appendChild(tdNom);

				tBody.appendChild(trJoueur);
			}
			document.getElementById("listJoueur" + j[0].idTournoi)
					.appendChild(table);
			console.log("affiché");
		}
	}
}