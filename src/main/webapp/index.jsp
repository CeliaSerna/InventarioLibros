<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Inventario de libros</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<link rel="shortcut icon" href="<c:url value="img/favicon.png"></c:url>">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Rock+Salt&display=swap" rel="stylesheet">
<style>
    
    *{font-family: 'Rock Salt', cursive;
 	}
    input {
    font-size: 19px !IMPORTANT;
    }

</style>

</head>

<body>

<div class="container pt-4">
<h1>Inventario de libros</h1>
<form action="Controller" class="form-control" method="post">

<div class="row">
<div class="col-8">
<label for="nombre" class="label-group"></label>
<input type="text" class="form-control" placeholder="Nombre del libro" name="nombre" required value="${param.nombre}" >
</div>

<div class="col-4">
<label for="isbn" class="label-group"></label>
<input type="text" class="form-control" placeholder="ISBN" name="isbn" required value="${param.isbn}" pattern="[9]{1}[7]{1}[8]{1}[0-9]{10}">
</div>

</div>

<div class="row">
<div class="col-8">
<label for="autor" class="label-group"></label>
<input type="text" class="form-control" placeholder="Autor del libro" name="autor" required value="${param.autor}" pattern="[A-Za-zñÑáéíóúÁÉÍÓÚ., ]+">
</div>

<div class="col-4">
<label for="cantidad" class="label-group"></label>
<input type="number" class="form-control" placeholder="Cantidad" name="cantidad" required value="${param.cantidad}">
</div>

</div>
<div class="row pt-4">

<div class="col-4">

</div>
<div class="col">
<input type="submit" name="enviar" value="Registrar libro" class="btn btn-light">
</div>
</div>


</form>

<div class="container pt-4">
	<c:if test="${not empty mensaje}">
	
	<c:out value="${mensaje}" ></c:out>
	
	</c:if>
</div>
<div class="container pt-4">
	
<c:if test="${not empty libro}">
	<table class="table table-hover">
	
	<tr>
	<th>Id del libro</th>
	<th>Nombre del libro</th>
	<th>Autor del libro</th>
	<th>ISBN del libro</th>
	<th>Stock del libro</th>
	
	</tr>
	
	<c:forEach items="${libro}" var="libro">
	<tr>
	<td><c:out value="${libro.idLibro}"></c:out></td>  
 	<td><c:out value="${libro.nombre}"></c:out></td>
	<td><c:out value="${libro.autor}"></c:out></td>
	<td><c:out value="${libro.isbn}"></c:out></td>
	<td><c:out value="${libro.cantidad}"></c:out></td>
	</tr>
	
	</c:forEach>
	
	
	</table>
	
	</c:if>
</div>

</div>


</body>
</html>