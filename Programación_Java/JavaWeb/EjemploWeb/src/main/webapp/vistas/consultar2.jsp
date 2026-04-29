<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.Producto"%>
<!-- Para poder utilziar lenguaje jstl que permite el uso del if, bucles, etc -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Styles.css">
<title>CONSULTAR PRODUCTO</title>
</head>
<body>
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
		<c:forEach var="producto" items="${productos}">
			<tr>
				<td><c:out value="${producto.idProducto}"></c:out> </td>	
				<td><c:out value="${producto.nombre}"></c:out> </td>
				<td><c:out value="${producto.cantidad}"></c:out> </td>
				<td><c:out value="${producto.precio}"></c:out> </td>
				<td><c:out value="${producto.fechaCreacion}"></c:out> </td>
				<td><c:out value="${producto.fechaActualizacion}"></c:out> </td>
				<td>
					<a href="${pageContext.request.contextPath}/ProductoControlador?opcion=editar&idProducto=<c:out value="${producto.idProducto}"></c:out>">EDITAR</a>
					<a href="${pageContext.request.contextPath}/ProductoControlador?opcion=eliminar&idProducto=<c:out value="${producto.idProducto}"></c:out>">ELIMINAR</a>
					<a href="${pageContext.request.contextPath}/CarritoControlador?opcion=agregar&idProducto=<c:out value="${producto.idProducto}"></c:out>">AGREGAR</a>
				</td>
			</tr>
		</tbody>
	</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/vistas/index.jsp">VOLVER</a>
</body>
</html>