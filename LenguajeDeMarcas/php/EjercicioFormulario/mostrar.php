<?php

  $servidor = 'localhost'; // Cambia esto solo si el cambio en phpMyAdmin no funciona
 $usuario = 'Administrador';
    $contraseña = 'admin';
    $base_datos = 'formulario_ejercicio';

$conexion = new mysqli($servidor, $usuario, $contraseña, $base_datos);
if ($conexion->connect_error) {
    die("La conexión falló: " . $conexion->connect_error);
}
$sql = "SELECT * FROM usuarios";
$resultado = $conexion->query($sql);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BBDD</title>
    <link rel="stylesheet" href="styleMostrar.css">
</head>
<body>
    <h1>Registros de la Base de Datos</h1>

    <div class="table-container">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Edad</th>
                    <th>Sexo</th>
                    <th>Roles</th>
                    <th>Mensaje</th>
                </tr>
            </thead>
            <tbody>
                <?php
                if ($resultado->num_rows > 0) {
                    while($fila = $resultado->fetch_assoc()) {
                        echo "<tr>";
                            echo "<td><strong>" . $fila["id"] . "</strong></td>";      
                            echo "<td>" . htmlspecialchars($fila["nombre"]) . "</td>";
                            echo "<td>" . $fila["edad"] . "</td>";
                            echo "<td>" . ucfirst($fila["sexo"]) . "</td>";
                            // Mostramos los roles como badges
                            echo "<td><span class='role-badge'>" . str_replace(',', '</span> <span class="role-badge">', $fila["roles"]) . "</span></td>";
                            echo "<td>" . htmlspecialchars($fila["mensaje"]) . "</td>";
                        echo "</tr>";
                    }
                } else {
                    echo "<tr><td colspan='6' style='text-align:center;'>No hay datos guardados aún</td></tr>";
                }
                ?>
            </tbody>
        </table>
    </div>

    <a href="index.php" class="btn-volver">← Volver al Formulario</a>
</body>
</html>