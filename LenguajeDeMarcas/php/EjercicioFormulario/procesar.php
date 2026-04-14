<?php
    $nombre = $_REQUEST['nombre'];
    $edad = $_REQUEST['edad'];
    $sexo = $_REQUEST['sexo'];
    $roles = $_REQUEST['roles'];
    $mensaje = $_REQUEST['mensaje'];

    $imagen = $_FILES['imagen'];
    $patch = $_SERVER['DOCUMENT_ROOT'] . '/EjercicioFormulario/imagenes/' . '/' . $imagen['name'];    

    move_uploaded_file($imagen['tmp_name'], $patch);

    $servidor = 'localhost'; // Cambia esto solo si el cambio en phpMyAdmin no funciona
    $usuario = 'Administrador';
    $contraseña = 'admin';
    $base_datos = 'formulario_ejercicio';

    $conexion = new mysqli($servidor, $usuario, $contraseña, $base_datos);
    if ($conexion->connect_error) {
        die('Error de conexión: ' . $conexion->connect_error);
    }

    $nombreSeguro = $conexion->real_escape_string($nombre);
    $edadSeguro = (int)$edad;
    $sexoSeguro = $conexion->real_escape_string($sexo);
    $rolesSeguro = $conexion->real_escape_string(implode(',', $roles));
    $mensajeSeguro = $conexion->real_escape_string($mensaje);

    $sqlInsertar = "INSERT INTO usuarios (nombre, edad, sexo, roles, mensaje) VALUES ('$nombreSeguro', $edadSeguro, '$sexoSeguro', '$rolesSeguro', '$mensajeSeguro')";
    if ($conexion->query($sqlInsertar) === TRUE) {
        echo "<h3>Datos guardados correctamente.</h3>";
    } else {
        echo "Error: " . $sqlInsertar . "<br>" . $conexion->error;
    }

    $conexion->close();
?>