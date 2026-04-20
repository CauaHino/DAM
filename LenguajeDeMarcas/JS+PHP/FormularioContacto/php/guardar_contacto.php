<?php
require 'config.php';

$nombre = $_POST['nombre'] ?? '';
$email    = $_POST['email']    ?? '';
$telefono = $_POST['telefono'] ?? '';
$asunto   = $_POST['asunto']   ?? '';
$mensaje  = $_POST['mensaje']  ?? '';
$fecha_actual = date('Y-m-d H:i:s');

$query = 'INSERT INTO mensajes_contacto (nombre, email, telefono, asunto, mensaje, fecha_creacion) values (?, ?, ?, ?, ?, ?)';

$stmt = $conn->prepare($query);
$stmt->bind_param("ssssss", $nombre, $email, $telefono, $asunto, $mensaje, $fecha_actual);

if($stmt->execute()){
    echo 'Mensaje insertada con éxito!';
} else {
    echo 'ERROR al insertar en la tabla mensajes_contacto' . $stmt->error;
}
echo "<br/><a href='../index.html'>VOLVER AL FORMULARIO</a>";
$stmt->close();
?>