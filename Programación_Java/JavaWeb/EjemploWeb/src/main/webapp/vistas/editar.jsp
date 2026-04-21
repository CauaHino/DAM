<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.Producto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Styles.css">
<title>CONSULTAR PRODUCTO</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/ProductoControlador" method="post">
		<table border="1px">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Cantidad</th>
					<th>Precio</th>
					<th>Fecha Creación</th>
					<th>Fecha Actualización</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
			<c:set var="producto" value="${producto}"></c:set>
				<tr>
					<td>
						<input type="hidden" name="opcion" value="editar">
						<input type="text" name="idProducto" value=<c:out value="${producto.idProducto}"></c:out> readonly="readonly">
					</td>					
					
					<td>
						<input type="text" name="nombre" value=${producto.nombre}>
					</td>
					
					<td>
						<input type="text" name="cantidad" value="${producto.cantidad}">
					</td>
					
					<td>
						<input type="text" name="precio" value="${producto.precio}">
					</td>
					
					<td>${producto.fechaCreacion}</td>
					
					<td>${producto.fechaActualizacion}</td>
					
					<td>
						<button type="submit" value="editar">EDITAR</button>
				</tr>
			</tbody>
		</table>
		</form>
	<a href="${pageContext.request.contextPath}/vistas/index.jsp">VOLVER</a>
</body>
</html>