<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.Producto"%>
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
		<%
					ArrayList<Producto> productos = (ArrayList<Producto>)request.getAttribute("productos");
				if(productos != null){
					for(Producto p : productos){
				%>
		<tbody>
			<tr>
				<td><%= p.getIdProducto() %></td>	
				<td><%= p.getNombre() %></td>
				<td><%= p.getCantidad() %></td>
				<td><%= p.getPrecio() %></td>
				<td><%= p.getFechaCreacion() %></td>
				<td><%= p.getFechaActualizacion() != null ? p.getFechaActualizacion() : "" %></td>
				<td>
					<a href="${pageContext.request.contextPath}/ProductoControlador?opcion=editar&idProducto=<%=p.getIdProducto()%>">EDITAR</a>
					<a href="${pageContext.request.contextPath}/ProductoControlador?opcion=eliminar&idProducto=<%=p.getIdProducto()%>">ELIMINAR</a>
				</td>
			</tr>
		</tbody>
		<%	
					}
				}
				%>
	</table>
	<a href="${pageContext.request.contextPath}/vistas/index.jsp">VOLVER</a>
</body>
</html>