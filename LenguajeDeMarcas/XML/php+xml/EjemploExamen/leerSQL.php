<?php
$host = 'localhost';
$username = 'root';
$password = '';
$database = 'logistica_transporte';

$conn = new mysqli($host, $username, $password, $database);

if ($conn->connect_error) {
    die("Error de conexión: " . $conn->connect_error);
}

// Consulta combinando rutas con la info del camión
$sql = "SELECT r.id_ruta, c.marca, c.modelo, r.origen, r.destino, r.kilometros, r.tipo_carga 
        FROM rutas r 
        INNER JOIN camiones c ON r.matricula_camion = c.matricula";
$result = $conn->query($sql);
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Logística - Control de Rutas</title>
    <style>
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th { background-color: #f2f2f2; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        tr:nth-child(even) { background-color: #fafafa; }
    </style>
</head>
<body>
    <h1>Gestión de Flota de Transportes</h1>
    <p>Listado de rutas realizadas y vehículos asignados</p>

    <?php if ($result && $result->num_rows > 0): ?>
    <table>
        <thead>
            <tr>
                <th>ID Ruta</th>
                <th>Vehículo</th>
                <th>Origen</th>
                <th>Destino</th>
                <th>Distancia</th>
                <th>Carga</th>
            </tr>
        </thead>
        <tbody>
            <?php while($row = $result->fetch_assoc()): ?>
            <tr>
                <td><?php echo $row['id_ruta']; ?></td>
                <td><strong><?php echo $row['marca'] . " " . $row['modelo']; ?></strong></td>
                <td><?php echo $row['origen']; ?></td>
                <td><?php echo $row['destino']; ?></td>
                <td><?php echo $row['kilometros']; ?> km</td>
                <td><?php echo $row['tipo_carga']; ?></td>
            </tr>
            <?php endwhile; ?>
        </tbody>
    </table>
    <?php else: ?>
        <p>No hay datos. <a href="exportar.php">Ejecutar exportación</a></p>
    <?php endif; ?>

</body>
</html>
<?php $conn->close(); ?>