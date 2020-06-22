<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Ordinata Videogiochi</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm">
				<h2>Risultato ricerca:</h2>
				<br>
				<table border="1" cellpadding="2">
					<tr>
						<th>Titolo</th>
						<th>Classificazione PEGI</th>
						<th>Prezzo</th>
						<th>Categoria</th>
					</tr>
					<c:forEach items="${result}" var="videogioco">
						<tr>
							<td>${videogioco.titolo}</td>
							<td>${videogioco.pegi}</td>
							<td>${videogioco.prezzo}</td>
							<td>${videogioco.categoria}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<br>
		<a href="home">Torna alla home</a>
	</div>
</body>
</html>



