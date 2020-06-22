<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Aggiungi un videogioco</title>
</head>
<body>
	<div class="container-fluid" align="center">
		<div class="row">
			<div class="col-sm">
				<h2>Aggiungi un videogioco</h2>
				<br>
				<form:form action="saveVideogioco" method="post"
					modelAttribute="videogioco">
					<table border="0" cellpadding="5">
						<tr>
							<td>Titolo:</td>
							<td><form:input path="titolo" /></td>
						</tr>
						<tr>
							<td>Classificazione PEGI:</td>
							<td><form:radiobuttons path="pegi" /></td>
						</tr>
						<tr>
							<td>Prezzo:</td>
							<td><form:input path="prezzo" /></td>
						</tr>
						<tr>
							<td>Categoria:</td>
							<td><form:radiobuttons path="categoria" /></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="Salva"></td>
						</tr>
					</table>
				</form:form>
				<br>
				<a href="home">Torna alla home</a>
			</div>
		</div>
	</div>
</body>
</html>