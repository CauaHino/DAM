<?php
/**
 * SCRIPT PARA MOSTRAR PRODUCTOS DE TIENDA INFORMÁTICA DESDE BASE DE DATOS
 * Este script conecta con la base de datos MySQL y muestra los productos
 * en una tabla HTML con el formato solicitado
 */

// =========================================================================
// Configuración de la conexión a la base de datos MySQL
// =========================================================================
$host = 'mariadb-dam';
$username = 'root';
$password = 'root';
$database = 'tienda_informatica';;

// Crear conexión a MySQL
$conn = new mysqli($host, $username, $password, $database);

// Verificar conexión
if ($conn->connect_error) {
    die("Error de conexión a MySQL: " . $conn->connect_error);
}

// Consulta para obtener todos los productos ordenados por ID original
$sql = "SELECT tipo, marca, modelo, especificaciones, precio, stock 
        FROM productos 
        ORDER BY id_original";
$result = $conn->query($sql);

// Contar el total de productos
$totalProductos = 0;
if ($result) {
    $totalProductos = $result->num_rows;
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Productos - Tienda Informática</title>
</head>
<body>
    <h1>Tienda Informatica</h1>
    <p>Catalogo de productos - Base de datos MySQL</p>
    

    <?php if ($result && $totalProductos > 0): ?>
    <table border="1" cellpadding="8" cellspacing="0" id="tablaProductos">
        <thead>
            <tr>
                <th>Tipo</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Especificaciones</th>
                <th>Precio (€)</th>
                <th>Stock</th>
            </tr>
        </thead>
        <tbody>
            <?php 
            // Reiniciar el puntero del resultado
            $result->data_seek(0);
            
            while ($row = $result->fetch_assoc()): 
            ?>
            <tr>
                <td><?php echo htmlspecialchars($row['tipo']); ?></td>
                <td><strong><?php echo htmlspecialchars($row['marca']); ?></strong></td>
                <td><?php echo htmlspecialchars($row['modelo']); ?></td>
                <td><?php echo htmlspecialchars($row['especificaciones']); ?></td>
                <td><?php echo number_format($row['precio'], 2, ',', '.'); ?> €</td>
                <td><?php echo $row['stock']; ?> uds.</td>
            </tr>
            <?php endwhile; ?>
        </tbody>
    </table>
    <?php else: ?>
    <div>
        <p>No hay productos disponibles en la base de datos</p>
        <p>Ejecuta primero el script <strong>exportar.php</strong> para importar los datos</p>
        <br>
        <a href="exportar.php">Exportar productos</a>
    </div>
    <?php endif; ?>
    
    <hr>
    
    <div>

    

</body>
</html>

<?php
// Cerrar la conexion a MySQL
$conn->close();
?>