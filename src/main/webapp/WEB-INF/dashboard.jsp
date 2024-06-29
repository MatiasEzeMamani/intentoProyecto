<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<header class="d-flex justify-content-between align-items-center">
			<h1>¡Bienvenido a tu Dashboard!</h1>
			<a href="/nuevo" class="btn btn-success">Nuevo Usuario</a>
		</header>
		<table class="table border border-dark text-center">
			<thead class="bg-dark bg-gradient text-white">
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Salon</th>
					<th>Hobbies</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td>${usuario.nombre}</td>
						<td>${usuario.apellido}</td>
						<td>${usuario.email}</td>
						<td>${usuario.salon.nombre}</td>
						<td>
							<ul>
								<c:forEach items="${usuario.hobbies}" var="hobbie"> 
									<li class="list-inline">${hobbie.actividad}</li>
								</c:forEach>
							</ul>
						</td>
						<td class="align-middle">
							<div class="d-flex justify-content-between">
								<a href="/asignar/${usuario.id}" class="btn btn-info">Agregar Hobby</a>
								<a href="/editar/${usuario.id}" class="btn btn-warning"><i class="bi bi-pencil"></i></a>
								<form action="/borrar/${usuario.id}" method="post">
									<input type="hidden" name="_method" value="DELETE">
									<button type="submit" class="btn btn-danger">
										<i class="bi bi-trash"></i>
									</button>
								</form>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>