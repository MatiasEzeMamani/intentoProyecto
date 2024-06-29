<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Asignar Hobbies</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Asignar hobbies a: ${usuario.nombre}</h1>
		<h2>Hobbies</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Actividad</th>
					<th>Accioness</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${hobbies}" var="hobby">
					<tr>
						<th>${hobby.actividad}</th>
						<th>
							<c:if test="${usuario.hobbies.contains(hobby)}">
								<a href="/quitarHobby/${usuario.id}/${hobby.id}" class="btn btn-danger">Quitar Hobby</a>
							</c:if>	
							<c:if test="${not usuario.hobbies.contains(hobby)}">
								<a href="/asignarHobby/${usuario.id}/${hobby.id}" class="btn btn-info">Asignar Hobby</a>
							</c:if>
						</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>