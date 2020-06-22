<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GameStop</title>
</head>
<body>
	<div align="center">
		<h1>GameStop</h1>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm">

				<br>

				<h4>
					<a href="nuovoVideogioco">Aggiungi un nuovo videogioco</a>
				</h4>

				<br>

				<h4>Cerca videogioco</h4>
				<form method="get" action="search">
					<input type="text" name="keyword" /> <input type="submit"
						value="Cerca" />
				</form>

				<br>

				<table border="1" cellpadding="5">
					<tr>
						<th>Titolo</th>
						<th>Classificazione PEGI</th>
						<th>Prezzo</th>
						<th>Categoria</th>
					</tr>
					<c:forEach items="${listaVideogiochi}" var="videogioco">
						<tr>
							<td>${videogioco.titolo}</td>
							<td>${videogioco.pegi}</td>
							<td>${videogioco.prezzo}</td>
							<td>${videogioco.categoria}</td>

							<td><a href="modificaVideogioco?id=${videogioco.id}">Modifica</a></td>
							<td><a href="cancellaVideogioco?id=${videogioco.id}">Elimina</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<br>
	<div class="container-fluid">
		<form method="post" action="ordina">
			<INPUT type="radio" name="command" value="1" /> Ordina per Titolo <br>
			<INPUT type="radio" name="command" value="2" /> Ordina per Prezzo <br>
			<INPUT type="radio" name="command" value="3" /> Ordina per Categoria <br> 
			<INPUT type="radio" name="command" value="4" /> Ordina per Classificazione <br> 
			<INPUT type="submit" value="Conferma" />
		</form>
	</div>
</body>
</html>