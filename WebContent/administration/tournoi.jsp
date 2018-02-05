<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Création de tournois</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<a href="../rest/administration/afficher"><- Retour</a>

	<h1>Créer des tournois</h1>

	<div class="col-md-offset-1 col-md-10">
		<form method="post" action="../rest/administration/tournoi/create">
			<fieldset>
				<legend>Création tournois</legend>
				<div class="form-group">
					<label for="jeu">Jeu</label> <input class="form-control"
						type="text" id="jeu" name="jeu" value="" size="50" maxlength="50" />
				</div>
				<div class="form-group">
					<label for="nbPlaces">Nombre de places</label> <input
						class="form-control" type="number" name="nbPlaces" value=""
						size="50" maxlength="200" />
				</div>
				<div class="form-group">
					<label for="date">Date</label> <input class="form-control"
						type="text" id="date" name="date" value="" size="50"
						maxlength="50" />
				</div>
			</fieldset>
			<div class="text-center">
				<input type="submit" value="Créer Tournoi" class="btn btn-primary" />
			</div>
		</form>
	</div>

</body>
</html>