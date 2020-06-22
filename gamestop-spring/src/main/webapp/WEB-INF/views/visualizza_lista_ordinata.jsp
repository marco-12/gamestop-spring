<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Ordinata Videogiochi</title>
</head>
<body>
	<div align="center">
		<h2>Product Manager</h2>
		<br>
		<table border="1" cellpadding="2">
			<tr>
				<th>ID</th>
				<th>Titolo</th>
				<th>Classificazione PEGI</th>
				<th>Prezzo</th>
				<th>Categoria</th>
			</tr>
			<c:forEach items="${listaVideogiochi}" var="videogioco">
				<tr>
					<td>${videogioco.id}</td>
					<td>${videogioco.titolo}</td>
					<td>${videogioco.pegi}</td>
					<td>${videogioco.prezzo}</td>
					<td>${videogioco.categoria}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>