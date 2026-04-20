<?php
$conexion = new mysqli("mariadb-dam", "root", "root");

$conexion->query("CREATE DATABASE contactos_db");
$conexion->select_db("contactos_db");
$conexion->query("CREATE USER 'administrador'@'localhost' IDENTIFIED BY '123456'");
$conexion->query("GRANT ALL PRIVILEGES ON contactos_db.* TO 'administrador'@'localhost'");
$conexion->query("CREATE TABLE mensajes_contacto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    asunto VARCHAR(50) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL
)");

echo "Instalado correctamente";
?>