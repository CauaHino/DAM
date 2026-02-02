<?php

// Validar que el formulario se haya enviado
if ($_SERVER["REQUEST_METHOD"] == "POST") {

    // Recoger los datos del formulario
    $nombre = $_POST['nombre'] ?? ''; // El operador ?? evita errores si está vacío
    $email = $_POST['email'] ?? '';
    $mensaje = $_POST['mensaje'] ?? '';

    // Configuración de la base de datos
    $servidor = "localhost";
    $usuario = "root";
    $password = "";
    $basedatos = "formularios_simple";

    // 1. Conectar SOLAMENTE al servidor (sin especificar base de datos aún)
    $conexion = new mysqli($servidor, $usuario, $password, $basedatos);

    // Verificar la conexión
    if ($conexion->connect_error) {
        die("Conexión fallida al servidor: " . $conexion->connect_error);
    }

    // 4. Crear la tabla si no existe
    $sqlCrearTabla = "CREATE TABLE IF NOT EXISTS tabla_contactos (
        id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        nombre VARCHAR(100) NOT NULL,
        email VARCHAR(100) NOT NULL,
        mensaje TEXT NOT NULL,
        fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    )";

    if (!$conexion->query($sqlCrearTabla)) {
        die("Error creando la tabla: " . $conexion->error);
    }

    // Preparar y ejecutar la inserción de datos (Sanitización básica)
    $nombreSeguro = $conexion->real_escape_string($nombre);
    $emailSeguro = $conexion->real_escape_string($email);
    $mensajeSeguro = $conexion->real_escape_string($mensaje);

    // Insertar los datos en la tabla
    $sqlInsertar = "INSERT INTO tabla_contactos (nombre, email, mensaje) VALUES ('$nombreSeguro', '$emailSeguro', '$mensajeSeguro')";

    // Verificar si la inserción fue exitosa
    if ($conexion->query($sqlInsertar) === TRUE) {
        echo "<h3>Datos guardados correctamente.</h3>";
    } else {
        echo "Error: " . $sqlInsertar . "<br>" . $conexion->error;
    }

    // Cerrar la conexión
    $conexion->close();

} else {
    echo "Por favor, envía el formulario primero.";
}

// Redirigir de vuelta al formulario
echo "<br><a href='../index.html'>Volver al formulario</a>";
?>