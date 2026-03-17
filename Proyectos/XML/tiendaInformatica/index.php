<?php

$host = 'mariadb-dam';
$username = 'root';
$password = 'root';
$database = 'tiendaInformatica';

$conn = new mysqli($host, $username, $password);

if ($conn->connect_error) {
    die("Error de conexión a MySQL: " . $con->connect_error);
}

$sqlCreateDB = "CREATE DATABASE IF NOT EXISTS $database";
if ($conn->query($sqlCreateDB) === TRUE) {
    echo "<!-- Base de datos MySQL verificada/creada correctamente -->\n";
} else {
    die("Error creando la base de datos MySQL: " . $conn->error);
}

$conn->select_db($database);

$conn->query('drop table if exists tienda');

$sqlCreateTable = 'create table tienda(
                    tipo varchar(30),
                    marca varchar(30),
                    modelo varchar(30),
                    especificaciones varchar(300),
                    precio decimal(6,2)';

if($conn->query($sqlCreateTable)){
    echo "TABLA CREADA CON ÉXITO";
} else {
    echo "ERROR AL CREAR LA TABLA";
}

$xml = simplexml_load_file('tienda.xml');

if($xml === false){
     die('Error al cargar el XML'); 
}

$especificaciones = [];
