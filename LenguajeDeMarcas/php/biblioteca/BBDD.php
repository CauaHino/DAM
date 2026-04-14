<?php

$servidor = "localhost";
$usuario = "caua";
$password = "1234";
$nombreBD = "biblioteca";

$conexion = new mysqli($servidor, $usuario, $password, $nombreBD);  

if ($conexion->connect_error) {
    die("La conexión falló: " . $conexion->connect_error);
}
$sqlCrearTabla = "CREATE TABLE IF NOT EXISTS libros (
        codigo INT AUTO_INCREMENT PRIMARY KEY,
        titulo VARCHAR(255) NOT NULL,
        autor VARCHAR(255) NOT NULL,
        ano_publicacion YEAR NOT NULL,
        disponible BOOLEAN NOT NULL,
        fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    )";

    if (!$conexion->query($sqlCrearTabla)) {
        die("Error creando la tabla: " . $conexion->error);
    }
     return $conexion;
?>


