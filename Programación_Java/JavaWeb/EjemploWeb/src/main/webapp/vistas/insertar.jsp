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
	<header>
		<h1>INSERTAR PRODUCTO</h1>
	</header>
	<div>
		<form action="${pageContext.request.contextPath}/ProductoControlador" method="post">
			<input type="hidden" name="opcion" value="insertar"/><br/>
				<label>Nombre:</label>
				<input type="text" name="nombre"/><br/>
				<label>Cantidad:</label>
				<input type="text" name="cantidad"/><br/>
				<label>Precio:</label>
				<input type="text" name="precio"/><br/>
				<input type="submit" name="INSERTAR"/> <br/>
		</form>
		<a href="index.jsp">VOLVER</a>
	</div>

</body>
</html>