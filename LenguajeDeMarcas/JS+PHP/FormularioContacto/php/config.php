<?php

$host = 'mariadb-dam';
$username = 'root';
$password = 'root';
$database = 'contactos_db';

$conn = new mysqli($host, $username, $password, $database);

if($conn->connect_error){
    die('Error: no fue posible conectar con la DB ' . $conn->connect_error);
}
?>
