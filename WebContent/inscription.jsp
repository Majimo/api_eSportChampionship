<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="style.css" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script type="text/javascript" src="js/inscription.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<title>Inscription</title>
</head>
<body>
	<h1 id="titre">Inscription au tournois</h1>
	<!-- Formulaire d'inscription -->
	<div class="col-md-offset-1 col-md-10">
		<form method="post" onsubmit="return valider()"
			action="/Tournoi/rest/front/joueur/create">
			<fieldset id="inscription">
				<p>Vous pouvez vous inscrire aux tournois via ce formulaire.</p>
				<div class="form-group">
					<label for="nom">Nom<span class="requis">*</span></label><input
						type="text" id="nom" name="nom" value="${requestScope.joueur.nom}"
						size="50" maxlength="50" /><span class="erreur">${formulaire.erreurs.nom}</span>
					<br />
				</div>
				<div class="form-group">
					<label for="prenom">Prénom<span class="requis">*</span></label><input
						type="text" id="prenom" name="prenom"
						value="${requestScope.joueur.prenom}" size="50" maxlength="50" /><span
						class="erreur">${formulaire.erreurs.prenom}</span> <br />
				</div>
				<div class="form-group">
					<label for="pseudo">Pseudo<span class="requis">*</span></label><input
						type="text" id="pseudo" name="pseudo"
						value="${requestScope.joueur.pseudo}" size="50" maxlength="50" /><span
						class="erreur">${formulaire.erreurs.pseudo}</span> <br />
				</div>
				<div class="form-group">
					<label for="mail">Adresse mail<span class="requis">*</span></label>
					<input type="email" id="mail" name="mail"
						value="${requestScope.joueur.mail}" size="50" maxlength="50" /><span
						class="erreur">${formulaire.erreurs.email}</span> <br />
				</div>
				<div class="form-group">
					<label id="select">Tournois<SELECT id="listTournoi"
						name="tournoi" size="1" id="listTournoi"></SELECT></label> <br />
					<div class="text-center">
						<input type="submit" value="Inscription" class="sansLabel" /> <br />
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	<br />

</body>
<script type="text/javascript">
	window.onload = function() {
		executerRequete('rest/front/tournoi/afficher', '',
			listTournoi, err);
	}
	function valider() {
		if (document.formulaire.nom.value == "") {
			alert("Veuillez entrer votre nom !");
			valid = false;
			return valid;
		}
		if (document.formulaire.prenom.value == "") {
			alert("Veuillez entrer votre prénom !");
			valid = false;
			return valid;
		}
		if (document.formulaire.pseudo.value == "") {
			alert("Veuillez entrer votre pseudo !");
			valid = false;
			return valid;
		}
		if (document.formulaire.mail.value == "") {
			alert("Veuillez entrer votre mail !");
			valid = false;
			return valid;
		}
	}
</script>
</html>