<?php
$host = 'localhost';
$username = 'root';
$password = '';
$database = 'logistica_transporte';

$conn = new mysqli($host, $username, $password);

if ($conn->connect_error) {
    die("Error de conexión: " . $conn->connect_error);
}

// Crear BD y tablas
$conn->query("CREATE DATABASE IF NOT EXISTS $database");
$conn->select_db($database);

$conn->query("DROP TABLE IF EXISTS rutas");
$conn->query("DROP TABLE IF EXISTS camiones");

// Tabla de Camiones
$sqlCamiones = "CREATE TABLE camiones (
    matricula VARCHAR(20) PRIMARY KEY,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    potencia VARCHAR(20),
    capacidad_carga VARCHAR(20),
    estado VARCHAR(20)
)";

// Tabla de Rutas
$sqlRutas = "CREATE TABLE rutas (
    id_ruta VARCHAR(10) PRIMARY KEY,
    matricula_camion VARCHAR(20),
    origen VARCHAR(100),
    destino VARCHAR(100),
    kilometros INT,
    tipo_carga VARCHAR(50),
    FOREIGN KEY (matricula_camion) REFERENCES camiones(matricula)
)";

$conn->query($sqlCamiones);
$conn->query($sqlRutas);

$xml = simplexml_load_file('transporte.xml');
if ($xml === false) die("Error al cargar XML");

$c_camiones = 0;
$c_rutas = 0;

// 1. Procesar Camiones
foreach ($xml->camion as $camion) {
    $mat = $conn->real_escape_string((string)$camion['matricula']);
    $estado = $conn->real_escape_string((string)$camion['estado']);
    $marca = $conn->real_escape_string((string)$camion->datos_tecnicos->marca);
    $modelo = $conn->real_escape_string((string)$camion->datos_tecnicos->modelo);
    $potencia = $conn->real_escape_string((string)$camion->datos_tecnicos->potencia);
    $carga = $conn->real_escape_string((string)$camion->dimensiones->capacidad_carga);

    $sql = "INSERT INTO camiones VALUES ('$mat', '$marca', '$modelo', '$potencia', '$carga', '$estado')";
    if ($conn->query($sql)) $c_camiones++;
}

// 2. Procesar Rutas
foreach ($xml->rutas->ruta as $ruta) {
    $id = $conn->real_escape_string((string)$ruta['id']);
    $mat_asig = $conn->real_escape_string((string)$ruta->camion_asignado['matricula']);
    $origen = $conn->real_escape_string((string)$ruta->recorrido->origen->ciudad);
    $destino = $conn->real_escape_string((string)$ruta->recorrido->destino->ciudad);
    $km = (int)$ruta->recorrido->kilometros;
    $tipo_carga = $conn->real_escape_string((string)$ruta->carga->tipo);

    $sql = "INSERT INTO rutas VALUES ('$id', '$mat_asig', '$origen', '$destino', $km, '$tipo_carga')";
    if ($conn->query($sql)) $c_rutas++;
}

$conn->close();
echo "Exportación finalizada: $c_camiones camiones y $c_rutas rutas guardadas.";
?>