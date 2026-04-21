<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Styles.css">
<title>Insert title here</title>
</head>
<body>
	<h1>MENÚ PRINCIPAL</h1>
	<%
		String mensaje = (String)request.getAttribute("mensaje");
	
		if(mensaje != null) {
			
	%>
	<script type="text/javascript">
		function mostrarMensaje(mensaje){
			alert(mensaje);
		}
		
		mostrarMensaje('<%= mensaje %>')
		
		<% } %>
	</script>
	<!-- ${pageContext.request.contextPath} == /EjemploWeb -->
	<a href="${pageContext.request.contextPath}/ProductoControlador?opcion=crearTabla">Crear Tabla Producto</a><br/>
	<a href="${pageContext.request.contextPath}/vistas/insertar.jsp">INSERTAR PRODUCTO</a><br/>
	<a href="${pageContext.request.contextPath}/ProductoControlador?opcion=consultar">CONSULTAR TABLA</a><br/>
</body>
</html>