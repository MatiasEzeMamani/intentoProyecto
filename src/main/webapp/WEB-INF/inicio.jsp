<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<h1>${titulo}</h1>
	<ul>
		<c:forEach items="${listaUsuarios}" var="usuario">
			<li>${usuario}</li>
		</c:forEach>
	</ul>
	<ol>
		<c:forEach items="${paises}" var="pais">
			<li>
				${pais.key}: ${pais.value}
				<c:if test="${pais.key == 'Mexico'}">
					<b>Mexico lindo y querido</b>
				</c:if>
			</li>
		</c:forEach>
	</ol>
</body>
</html>