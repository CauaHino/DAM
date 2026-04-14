<?php
/**
 * SCRIPT DE EXPORTACIÓN DE TIENDA INFORMÁTICA A BASE DE DATOS
 * Este script procesa un archivo XML con productos de una tienda de informática
 * y los almacena en una base de datos relacional MySQL
 */

// =========================================================================
// Configuración de la conexión a la base de datos MySQL en XAMPP
// =========================================================================
$host = 'mariadb-dam';
$username = 'root';      // Usuario por defecto de XAMPP
$password = 'root';          // Contraseña por defecto de XAMPP (vacía)
$database = 'tienda_informatica';

// Crear conexión a MySQL
$conn = new mysqli($host, $username, $password);

// Verificar conexión
if ($conn->connect_error) {
    die("Error de conexión a MySQL: " . $conn->connect_error);
}

// Crear la base de datos si no existe
$sqlCreateDB = "CREATE DATABASE IF NOT EXISTS $database";
if ($conn->query($sqlCreateDB) === TRUE) {
    echo "<!-- Base de datos MySQL verificada/creada correctamente -->\n";
} else {
    die("Error creando la base de datos MySQL: " . $conn->error);
}

// Seleccionar la base de datos
$conn->select_db($database);

// Eliminar tabla existente para evitar duplicados
$conn->query("DROP TABLE IF EXISTS productos");

// =========================================================================
// Crear la tabla en MySQL con la estructura solicitada
// =========================================================================
$sqlProductos = "CREATE TABLE productos (
    id_original VARCHAR(10) PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    especificaciones TEXT NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL
)";

if ($conn->query($sqlProductos) === TRUE) {
    echo "<!-- Tabla 'productos' creada en MySQL correctamente -->\n";
} else {
    echo "Error creando tabla productos en MySQL: " . $conn->error . "\n";
}

// =========================================================================
// Cargar el archivo XML
// =========================================================================
$xml = simplexml_load_file('tienda.xml');

if ($xml === false) {
    die("Error al cargar el archivo XML");
}

// =========================================================================
// Procesar cada tipo de producto y insertar en la base de datos
// =========================================================================
$contador = 0;

// Procesar PORTÁTILES
foreach ($xml->PRODUCTOS->PORTATIL as $portatil) {
    $id_original = $conn->real_escape_string((string)$portatil['id']);
    $tipo = 'Portátil';
    $marca = $conn->real_escape_string((string)$portatil->MARCA);
    $modelo = $conn->real_escape_string((string)$portatil->MODELO);
    
    // Construir especificaciones: PROCESADOR | RAM | ALMACENAMIENTO
    $procesador = (string)$portatil->PROCESADOR;
    $ram = (string)$portatil->RAM;
    $almacenamiento = (string)$portatil->ALMACENAMIENTO;
    $especificaciones = $conn->real_escape_string("$procesador | $ram | $almacenamiento");
    
    $precio = (float)$portatil->PRECIO;
    $stock = (int)$portatil->STOCK;
    
    $sqlInsert = "INSERT INTO productos (id_original, tipo, marca, modelo, especificaciones, precio, stock) 
                  VALUES ('$id_original', '$tipo', '$marca', '$modelo', '$especificaciones', $precio, $stock)";
    
    if ($conn->query($sqlInsert)) {
        $contador++;
    } else {
        echo "Error insertando portátil: " . $conn->error . "\n";
    }
}

// Procesar COMPONENTES
foreach ($xml->PRODUCTOS->COMPONENTE as $componente) {
    $id_original = $conn->real_escape_string((string)$componente['id']);
    $tipo = 'Componente - ' . (string)$componente->TIPO;
    $marca = $conn->real_escape_string((string)$componente->MARCA);
    $modelo = $conn->real_escape_string((string)$componente->MODELO);
    
    // Para componentes, la especificación es la CAPACIDAD
    $especificaciones = $conn->real_escape_string((string)$componente->CAPACIDAD);
    
    $precio = (float)$componente->PRECIO;
    $stock = (int)$componente->STOCK;
    
    $sqlInsert = "INSERT INTO productos (id_original, tipo, marca, modelo, especificaciones, precio, stock) 
                  VALUES ('$id_original', '$tipo', '$marca', '$modelo', '$especificaciones', $precio, $stock)";
    
    if ($conn->query($sqlInsert)) {
        $contador++;
    } else {
        echo "Error insertando componente: " . $conn->error . "\n";
    }
}

// Procesar PERIFÉRICOS
foreach ($xml->PRODUCTOS->PERIFERICO as $periferico) {
    $id_original = $conn->real_escape_string((string)$periferico['id']);
    $tipo = 'Periférico - ' . (string)$periferico->TIPO;
    $marca = $conn->real_escape_string((string)$periferico->MARCA);
    $modelo = $conn->real_escape_string((string)$periferico->MODELO);
    
    // Para periféricos, la especificación es la CONEXION
    $especificaciones = $conn->real_escape_string((string)$periferico->CONEXION);
    
    $precio = (float)$periferico->PRECIO;
    $stock = (int)$periferico->STOCK;
    
    $sqlInsert = "INSERT INTO productos (id_original, tipo, marca, modelo, especificaciones, precio, stock) 
                  VALUES ('$id_original', '$tipo', '$marca', '$modelo', '$especificaciones', $precio, $stock)";
    
    if ($conn->query($sqlInsert)) {
        $contador++;
    } else {
        echo "Error insertando periférico: " . $conn->error . "\n";
    }
}

// Procesar MONITORES
foreach ($xml->PRODUCTOS->MONITOR as $monitor) {
    $id_original = $conn->real_escape_string((string)$monitor['id']);
    $tipo = 'Monitor';
    $marca = $conn->real_escape_string((string)$monitor->MARCA);
    $modelo = $conn->real_escape_string((string)$monitor->MODELO);
    
    // Construir especificaciones: TAMAÑO | RESOLUCION | FRECUENCIA
    $tamano = (string)$monitor->TAMAÑO;
    $resolucion = (string)$monitor->RESOLUCION;
    $frecuencia = (string)$monitor->FRECUENCIA;
    $especificaciones = $conn->real_escape_string("$tamano | $resolucion | $frecuencia");
    
    $precio = (float)$monitor->PRECIO;
    $stock = (int)$monitor->STOCK;
    
    $sqlInsert = "INSERT INTO productos (id_original, tipo, marca, modelo, especificaciones, precio, stock) 
                  VALUES ('$id_original', '$tipo', '$marca', '$modelo', '$especificaciones', $precio, $stock)";
    
    if ($conn->query($sqlInsert)) {
        $contador++;
    } else {
        echo "Error insertando monitor: " . $conn->error . "\n";
    }
}

// Cerrar la conexión a MySQL
$conn->close();

// Mensaje de confirmación
echo "<!-- $contador productos exportados correctamente a MySQL en la base de datos '$database' -->\n";
// =========================================================================
?>

