<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../style.css" />
<script type="text/javascript" src="../js/tournoi.js"></script>
<script type="text/javascript" src="../js/ajax.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Administration</title>
</head>
<body>

	<h1>Administration des tournois</h1>

	<div class="col-md-offset-1 col-md-10" style="text-align: center; padding-top: 33px;">
		<div id="tableTournoi" class="row center"></div>
	</div>

	<h4><a href="tournoi.jsp" style="margin-top: 90px; margin-left: 80rem;" class="btn btn-warning">Créer tournoi</a></h4>

</body>
<script type="text/javascript">
	window.onload = function() {
		executerRequete('../rest/administration/tournoi/afficher', '',
				listTournoi, err);
	}
</script>
</html>