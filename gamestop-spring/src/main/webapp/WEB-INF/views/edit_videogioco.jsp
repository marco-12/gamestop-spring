<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Videogioco</title>
</head>
<body>
	<div align="center">
		<h2>Edit Videogioco</h2>
		<form:form action="saveVideogioco" method="post" modelAttribute="videogioco">
			<table border="0" cellpadding="5">
				<tr>
					<td>ID:</td>
					<td>${videogioco.id}<form:hidden path="id" />
					</td>
				</tr>
				<tr>
					<td>Titolo:</td>
					<td><form:input path="nome" /></td>
				</tr>
				<tr>
					<td>Classificazione PEGI:</td>
					<td><form:input path="pegi" /></td>
				</tr>
				<tr>
					<td>Prezzo:</td>
					<td><form:input path="prezzo" /></td>
				</tr>
				<tr>
					<td>Categoria:</td>
					<td><form:input path="categoria" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			</table>
		</form:form>
		<a href="/">Torna alla home</a>
	</div>
</body>
</html>