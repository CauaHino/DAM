<?php

$servidor = "mariadb-dam";
$usuario = "caua";
$password = "1234";
$nombreBD = "biblioteca";

$conexion = new mysqli($servidor, $usuario, $password, $nombreBD);
if ($conexion->connect_error) {
    die("La conexión falló: " . $conexion->connect_error);
}
$sql = "SELECT * FROM libros";
$resultado = $conexion->query($sql);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BIBLIOTECA</title>
    
      <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
      <style>
    :root {
        --glass-bg: rgba(255, 255, 255, 0.1);
        --glass-border: rgba(255, 255, 255, 0.2);
        --primary-gradient: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        --accent-color: #00d2ff;
    }

    body {
        font-family: 'Poppins', sans-serif;
        background: var(--primary-gradient);
        background-attachment: fixed;
        min-height: 100vh;
        margin: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        color: white;
    }

    h1 {
        font-weight: 600;
        text-shadow: 2px 2px 10px rgba(0,0,0,0.3);
        margin-bottom: 2rem;
        letter-spacing: 1px;
    }

    /* Contenedor con efecto Cristal */
    .table-container {
        background: var(--glass-bg);
        backdrop-filter: blur(15px);
        -webkit-backdrop-filter: blur(15px);
        border: 1px solid var(--glass-border);
        border-radius: 20px;
        padding: 30px;
        box-shadow: 0 25px 45px rgba(0,0,0,0.2);
        width: 90%;
        max-width: 1100px;
        overflow-x: auto; /* Para móviles */
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    th {
        text-align: left;
        padding: 20px;
        background: rgba(255, 255, 255, 0.05);
        color: var(--accent-color);
        text-transform: uppercase;
        font-size: 0.85rem;
        letter-spacing: 1.5px;
        border-bottom: 2px solid var(--glass-border);
    }

    td {
        padding: 18px 20px;
        border-bottom: 1px solid var(--glass-border);
        transition: all 0.3s ease;
    }

    /* Filas al pasar el ratón */
    tbody tr:hover {
        background: rgba(255, 255, 255, 0.1);
        transform: scale(1.01);
        box-shadow: 0 5px 15px rgba(0,0,0,0.1);
    }

    /* Estilos para los estados */
    .badge {
        padding: 6px 15px;
        border-radius: 50px;
        font-size: 0.8rem;
        font-weight: 600;
        display: inline-block;
        text-align: center;
        min-width: 60px;
    }

    .disponible-si {
        background: #27ae60;
        box-shadow: 0 0 15px rgba(39, 174, 96, 0.4);
    }

    .disponible-no {
        background: #e74c3c;
        box-shadow: 0 0 15px rgba(231, 76, 60, 0.4);
    }

    /* Código en negrita con color */
    .codigo-id {
        color: var(--accent-color);
        font-weight: bold;
    }

    /* Scrollbar personalizado para el contenedor */
    .table-container::-webkit-scrollbar {
        height: 8px;
    }
    .table-container::-webkit-scrollbar-thumb {
        background: var(--glass-border);
        border-radius: 10px;
    }
</style>

</head>
<body>
    <h1>Registros de los libros</h1>

    <div class="table-container">
        <table>
            <thead>
                <tr>
                    <th>CÓDIGO</th>
                    <th>TITULO</th>
                    <th>AUTOR</th>
                    <th>AÑO DE PUBLICACIÓN</th>
                    <th>DISPONIBLE</th>
                    <th>FECHA MODIFICACIÓN</th>
                </tr>
            </thead>
            <tbody>
                <?php
                if ($resultado->num_rows > 0) {
                    while($fila = $resultado->fetch_assoc()) {
                            echo "<tr>";
                            echo "<td class='codigo-id'>" . $fila["codigo"] . "</td>";      
                            echo "<td>" . htmlspecialchars($fila["titulo"]) . "</td>";
                            echo "<td>" . $fila["autor"] . "</td>";
                            echo "<td>" . $fila["ano_publicacion"] . "</td>";
                            $claseBadge = $fila["disponible"] ? "disponible-si" : "disponible-no";
                            $textoBadge = $fila["disponible"] ? "DISPONIBLE" : "PRESTADO";
                            echo "<td><span class='badge $claseBadge'>$textoBadge</span></td>";
                            echo "<td style='opacity: 0.7; font-size: 0.8rem;'>" . $fila["fecha"] . "</td>";
                            echo "</tr>";
                    }
                } else {
                    echo "<tr><td colspan='6' style='text-align:center;'>No hay datos guardados aún</td></tr>";
                }
                ?>
            </tbody>
        </table>
    </div>
</body>
</html>