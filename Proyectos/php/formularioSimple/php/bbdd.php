<?php
// --- 1. CONFIGURACIÓN DE LA BASE DE DATOS (XAMPP) ---
$servidor = "localhost";
$usuario = "root";
$password = "";           // En XAMPP la contraseña suele estar vacía
$nombreBD = "formularios_simple";   

// Crear la conexión
$conexion = new mysqli($servidor, $usuario, $password, $nombreBD);

// Verificar si hubo error al conectar
if ($conexion->connect_error) {
    die("La conexión falló: " . $conexion->connect_error);
}

// --- 2. HACER LA CONSULTA (PEDIR DATOS) ---

$sql = "SELECT * FROM tabla_contactos"; 
$resultado = $conexion->query($sql);
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Datos</title>
    <link rel="stylesheet" href="../css/stylebbdd.css">
</head>
<body>

    <h1>Registros de la Base de Datos</h1>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Mensaje</th>
                <th>Acciones</th>
            </tr>
        </thead>
        
        <tbody>
            <?php
           

            if ($resultado->num_rows > 0) {
                while($fila = $resultado->fetch_assoc()) {
                    echo "<tr>";
                        echo "<td>" . $fila["id"] . "</td>";      
                        echo "<td>" . $fila["nombre"] . "</td>";
                        echo "<td>" . $fila["email"] . "</td>";
                        echo "<td>" . $fila["mensaje"] . "</td>";
                        
                        echo "<td style='text-align:center;'>";
                        echo "<a href='borrar.php?id=" . $fila["id"] . "' class='btn-borrar-tabla' onclick=\"return confirm('¿Estás seguro de que quieres borrar a este usuario?');\"> Borrar</a>";
                        echo "</td>";
                        // ------------------------------

                    echo "</tr>";
                }
            } else {
        
                echo "<tr><td colspan='5'>No hay datos guardados aún</td></tr>";
            }
            ?>
        </tbody>
    </table>

    <div style="text-align: center;">
        <a href="../index.html">⬅ Volver al formulario</a>
    </div>

</body>
</html>

<?php
$conexion->close();
?>