<%@page import="org.springframework.ui.Model"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/boostrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<title>Books API</title>
</head>
<body>
	<h1><c:out value="${libro.title}" /></h1>
	<p> Descripción: <c:out value="${libro.description}" /> </p>
	<p> Idioma: <c:out value="${libro.language}" /> </p>
	<p> N° de páginas: <c:out value="${libro.numberPages}" /> </p>
	<a href="">Editar libro</a>
	<form action="/books/${libro.id}" method="post">
		<input type="hidden" name="" value="delete" />
		<input type="submit" value="Borrar" />
	</form>
</body>
</html>