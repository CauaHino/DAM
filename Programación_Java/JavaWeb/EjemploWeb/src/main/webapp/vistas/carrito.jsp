<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Styles.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CARRITO</title>
</head>
<body>
	<h1>CARRITO DE COMPRA</h1>
	<c:set var="carrito" value="${sessionScope.carrito}"></c:set>
	<table border="1px">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Cantidad</th>
				<th>Precio</th>
				<th>Total</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="producto" items="${carrito.listaProductos}">
			<tr>
				<td><c:out value="${producto.idProducto}"></c:out> </td>	
				<td><c:out value="${producto.nombre}"></c:out> </td>
				<td><c:out value="${producto.cantidad}"></c:out> </td>
				<td><c:out value="${producto.precio}"></c:out> </td>
				<td><c:out value="${producto.precio * producto.cantidad}"></c:out> </td>
				<td>
					<a href="${pageContext.request.contextPath}/CarritoControlador?opcion=eliminar&idProducto=<c:out value="${producto.idProducto}"></c:out>">ELIMINAR</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/vistas/index.jsp">VOLVER</a>
</body>
</html>