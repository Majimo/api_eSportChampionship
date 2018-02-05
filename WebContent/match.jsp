<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../style.css" />
<script type="text/javascript" src="js/match.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Match</title>
</head>
<body>

<div class="col-md-offset-2 col-md-8">
	<div id="listMatch"></div>
</div>

</body>
<script type="text/javascript">
	window.onload = function() {
		executerRequete('rest/front/match/afficher/liste/${param.id }', '',
				listMatch, err);
	}
</script>
</html>