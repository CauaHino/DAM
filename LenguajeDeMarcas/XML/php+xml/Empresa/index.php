<?php

$host = 'mariadb-dam';
$username = 'root';
$password = 'root';
$database = 'empresa';

$conn = new mysqli($host, $username, $password);

if ($conn->connect_error) {
    die("Error de conexión a MySQL: " . $conn->connect_error);
}

$sqlCreateDB = "CREATE DATABASE IF NOT EXISTS $database";
if ($conn->query($sqlCreateDB) === TRUE) {
    echo "\n";
} else {
    die("Error creando la base de datos MySQL: " . $conn->error);
}

$conn->select_db($database);

$conn->query("DROP TABLE IF EXISTS empresa");

$sqlEmpresa = "CREATE TABLE empresa (
    id_cliente VARCHAR(50) PRIMARY KEY,
    estado VARCHAR(100) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    fechaNacimiento VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    codigoPostal INT NOT NULL
)";

if ($conn->query($sqlEmpresa) === TRUE) {
    echo "\n";
} else {
    echo "Error creando tabla empresa en MySQL: " . $conn->error . "\n";
}

$xml = simplexml_load_file('clientes.xml');

foreach ($xml->cliente as $cliente) {
    $clienteId = $conn->real_escape_string((string)$cliente['id']);
    $estado = $conn->real_escape_string((string)$cliente['estado']);

    $datosPersonales = $cliente->datos_personales;

    $nombre = $conn->real_escape_string((string)$datosPersonales->nombre);
    $fechaNacimiento = $conn->real_escape_string((string)$datosPersonales->fecha_nacimiento);
    $email = $conn->real_escape_string((string)$cliente->contacto->email);
    $codigoPostal = (int)$cliente->contacto->direccion->codigo_postal;

    $sqlInsertClientes = "INSERT INTO empresa (id_cliente, estado, nombre, fechaNacimiento, email, codigoPostal)
                            VALUES ('$clienteId', '$estado', '$nombre', '$fechaNacimiento', '$email', $codigoPostal)";

    if (!$conn->query($sqlInsertClientes)) {
        echo "Error insertando cliente $clienteId: " . $conn->error . "\n";
    }
}

$conn->close();
echo "\n";
?>

<?php
$host = 'mariadb-dam';
$username = 'root';
$password = 'root';
$database = 'empresa';

$conn = new mysqli($host, $username, $password, $database);

if ($conn->connect_error) {
    die("Error de conexión: " . $conn->connect_error);
}

$result = $conn->query("SELECT * FROM empresa");

if ($result->num_rows > 0) {
    echo "<table border='1' cellpadding='10'>";
    echo "<tr>
            <th>ID Cliente</th>
            <th>Estado</th>
            <th>Nombre</th>
            <th>Fecha Nacimiento</th>
            <th>Email</th>
            <th>Código Postal</th>
          </tr>";
    
    while ($row = $result->fetch_assoc()) {
        echo "<tr>";
        echo "<td>" . htmlspecialchars($row['id_cliente']) . "</td>";
        echo "<td>" . htmlspecialchars($row['estado']) . "</td>";
        echo "<td>" . htmlspecialchars($row['nombre']) . "</td>";
        echo "<td>" . htmlspecialchars($row['fechaNacimiento']) . "</td>";
        echo "<td>" . htmlspecialchars($row['email']) . "</td>";
        echo "<td>" . htmlspecialchars($row['codigoPostal']) . "</td>";
        echo "</tr>";
    }
    
    echo "</table>";
} else {
    echo "No hay datos en la tabla.";
}

$conn->close();
?>