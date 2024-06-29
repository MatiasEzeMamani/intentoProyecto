<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="col-6">
			<form action="/registro" method="POST" >
				<h1>Usuario</h1>
				<p class="text-danger text-lg">${error}</p>
				<div>
					<label for="nombreid">Nombre:</label>
					<input type="text" name="nombre" class="form-control" id="nombreid" >
					<p class="text-danger">${errorNombre}</p>
				</div>
				<div>
					<label for="emailid">E-mail:</label>
					<input type="email" name="email" class="form-control" id="emailid" >
					<p class="text-danger">${errorEmail}</p>
				</div>
				<input type="submit" class="btn btn-success mt-3" value="Enviar" >
			</form>
		</div>
	</div>
</body>
</html>