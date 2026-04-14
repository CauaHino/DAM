<?php

// Validar que el formulario se haya enviado
if ($_SERVER["REQUEST_METHOD"] == "POST") {

    // Recoger los datos del formulario
    $titulo = $_POST['titulo'] ?? ''; // El operador ?? evita errores si está vacío
    $autor = $_POST['autor'] ?? '';
    $ano_publicacion = $_POST['ano_publicacion'] ?? '';
    $disponible = isset($_POST['disponible']) ? 'disponible' : 'no_disponible';

    // Configuración de la base de datos
    $servidor = "localhost";
    $usuario = "caua";
    $password = "1234";
    $basedatos = "biblioteca";

    // 1. Conectar SOLAMENTE al servidor (sin especificar base de datos aún)
    $conexion = new mysqli($servidor, $usuario, $password, $basedatos);

    // Verificar la conexión
    if ($conexion->connect_error) {
        die("Conexión fallida al servidor: " . $conexion->connect_error);
    }

    $tituloSeguro = $conexion->real_escape_string($titulo);
    $autorSeguro = $conexion->real_escape_string($autor);
    $ano_publicacionSeguro = $conexion->real_escape_string($ano_publicacion);
    $disponibleSeguro = $conexion->real_escape_string($disponible);

    // Insertar los datos en la tabla
    $sqlInsertar = "INSERT INTO libros (titulo, autor, ano_publicacion, disponible) VALUES ('$tituloSeguro', '$autorSeguro', '$ano_publicacionSeguro', '$disponible')";

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