<?php

$host = 'mariadb-dam';
$username = 'root';
$password = 'root';
$database = 'transporte';

$conn = new mysqli($host, $username, $password);

if ($conn->connect_error) {
    die("Error de conexión: " . $conn->connect_error);
}

$sqlCreateDB = "CREATE DATABASE IF NOT EXISTS $database";

if ($conn->query($sqlCreateDB) === TRUE) {
    echo "<!-- Base de datos MySQL verificada/creada correctamente -->\n";
} else {
    die("Error creando la base de datos MySQL: " . $conn->error);
}

$conn->select_db($database);

$conn->query("DROP TABLE IF EXISTS camiones");

$sqlCreateTable = 'CREATE TABLE camiones (
                    matricula varchar(10) primary key,
                    estado varchar(20) not null,
                    año_fabricacion int,
                    marca varchar(50), 
                    modelo varchar(50),
                    color varchar(30),
                    potencia varchar(20),
                    peso_maximo varchar(20),
                    capacidad_carga varchar(20),
                    numero_ejes int,
                    ultima_revision_fecha date,
                    ultimo_km int,
                    proxima_revision_fecha date
                    );';

if ($conn->query($sqlCreateTable) === TRUE) {
    echo "<!-- Tabla 'camiones' creada en MySQL correctamente -->\n";
} else {
    echo "Error creando tabla camiones en MySQL: " . $conn->error . "\n";
}

$xml = simplexml_load_file('transporte.xml');

if ($xml === false) {
    die("Error al cargar el archivo XML");
}

$c_camiones = 0;

foreach ($xml->camion as $camion) {

    $datosTecnicos = $camion->datos_tecnicos;
    $dimensiones = $camion->dimensiones;
    $mantenimiento = $camion->mantenimiento;

    $mat = $conn->real_escape_string((string)$camion['matricula']);
    $estado = $conn->real_escape_string((string)$camion['estado']);
    $anoFabricacion = (int)$camion['año_fabricacion'];

    $marca = $conn->real_escape_string((string)$datosTecnicos->marca);
    $modelo = $conn->real_escape_string((string)$datosTecnicos->modelo);
    $color = $conn->real_escape_string((string)$datosTecnicos->color);
    $potencia = $conn->real_escape_string((string)$datosTecnicos->potencia);

    $pesoMax = $conn->real_escape_string((string)$dimensiones->peso_maximo);
    $carga = $conn->real_escape_string((string)$dimensiones->capacidad_carga);
    $numEjes = (int)$dimensiones->numero_ejes;


    $ultimaRevision = $conn->real_escape_string((string)$mantenimiento->ultima_revision['fecha']);
    $ultimoKm = (int)$mantenimiento->ultima_revision->kilometraje;
    $proximaRevision = $conn->real_escape_string((string)$mantenimiento->proxima_revision['fecha']);


    $sql = "INSERT INTO camiones(matricula, estado, año_fabricacion, marca, modelo, color, potencia, peso_maximo,
                                capacidad_carga, numero_ejes, ultima_revision_fecha, ultimo_km, proxima_revision_fecha) 
    VALUES ('$mat', '$estado', $anoFabricacion, '$marca', '$modelo', '$color',
                                        '$potencia', '$pesoMax', '$carga', $numEjes, '$ultimaRevision', 
                                        '$ultimoKm', '$proximaRevision')";
    if ($conn->query($sql)) $c_camiones++;
}

$conn->close();
?>

<?php
$host = 'mariadb-dam';
$username = 'root';
$password = 'root';
$database = 'transporte';

$conn = new mysqli($host, $username, $password, $database);

if ($conn->connect_error) {
    die("Error de conexión: " . $conn->connect_error);
}

$result = $conn->query("SELECT * FROM camiones");

if ($result->num_rows > 0) {
    echo "<table border='1' cellpadding='10'>";
    echo "<tr>
            <th>Matricula</th>
            <th>Estado</th>
            <th>Año de Fabricacion</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Color</th>
            <th>Potencia</th>
            <th>Peso Maximo</th>
            <th>Capacidad de Carga</th>
            <th>Numero de Ejes</th>
            <th>Fecha de Ultima Revisión</th>
            <th>Ultimo KM</th>
            <th>Fecha de Proxima Revisión</th>
          </tr>";
    
    while ($row = $result->fetch_assoc()) {
        echo "<tr>";
        echo "<td>" . htmlspecialchars($row['matricula']) . "</td>";
        echo "<td>" . htmlspecialchars($row['estado']) . "</td>";
        echo "<td>" . htmlspecialchars($row['año_fabricacion']) . "</td>";
        echo "<td>" . htmlspecialchars($row['marca']) . "</td>";
        echo "<td>" . htmlspecialchars($row['modelo']) . "</td>";
        echo "<td>" . htmlspecialchars($row['color']) . "</td>";
        echo "<td>" . htmlspecialchars($row['potencia']) . "</td>";
        echo "<td>" . htmlspecialchars($row['peso_maximo']) . "</td>";
        echo "<td>" . htmlspecialchars($row['capacidad_carga']) . "</td>";
        echo "<td>" . htmlspecialchars($row['numero_ejes']) . "</td>";
        echo "<td>" . htmlspecialchars($row['ultima_revision_fecha']) . "</td>";
        echo "<td>" . htmlspecialchars($row['ultimo_km']) . "</td>";
        echo "<td>" . htmlspecialchars($row['proxima_revision_fecha']) . "</td>";
        echo "</tr>";
    }
    
    echo "</table>";
} else {
    echo "No hay datos en la tabla.";
}


echo $c_camiones;
$count = $conn->query("select count(*) from camiones where estado ='activo';");
echo $count;
$count = $conn->query("select count(*) from camiones where estado ='mantenimiento';");
echo $count;
$count = $conn->query("select count(*) from camiones where estado ='inactivo';");
echo $count;
$suma = $conn->query("select sum(potencia) from camiones");
echo $suma;
$suma = $conn->query("select sum(capacidad_carga) from camiones");
echo $suma;
$suma = $conn->query("select sum(ultimo_km) from camiones");
echo $suma;
$suma = $conn->query("select avg(ultimo_km) from camiones");
echo $suma;

$conn->close();
?>