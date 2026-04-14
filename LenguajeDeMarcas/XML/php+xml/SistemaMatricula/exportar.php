<?php
$host = 'mariadb-dam';
$username = 'root';
$password = 'root';
$database = 'gestionDAM';

$conn = new mysqli($host, $username, $password, $database);

if($conn->connect_error){
    die('Error: no fue posible conectar con la DB ' . $conn->connect_error);
}

// IMPORTANTE: Borrar primero la tabla con las Foreign Keys
$conn->query('DROP TABLE IF EXISTS matriculas');
$conn->query('DROP TABLE IF EXISTS alumnos');
$conn->query('DROP TABLE IF EXISTS asignaturas');

$sqlAlumnos = "CREATE TABLE alumnos(
                    id INT PRIMARY KEY,
                    nombre VARCHAR(30) NOT NULL,
                    edad INT NOT NULL,
                    curso VARCHAR(20)
                    )";
$conn->query($sqlAlumnos);

$sqlAsignaturas = "CREATE TABLE asignaturas (
    id_asignatura INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
)";
$conn->query($sqlAsignaturas);

$sqlMatriculas = "CREATE TABLE matriculas (
    id_alumno INT,
    id_asignatura INT,
    PRIMARY KEY (id_alumno, id_asignatura),
    FOREIGN KEY (id_alumno) REFERENCES alumnos(id),
    FOREIGN KEY (id_asignatura) REFERENCES asignaturas(id_asignatura)
)";
$conn->query($sqlMatriculas);

$xml = simplexml_load_file('solución_dam.xml');
if($xml === false){ die('Error al cargar el XML'); }

$asignaturas = []; 
$matriculas = [];    
$idAsignaturaContador = 1;    

// 1. Insertar Alumnos
foreach ($xml->alumno as $alumno) {
    $alumnoId = (int)$alumno['id'];
    $nombre = $conn->real_escape_string((string)$alumno->nombre);
    $edad = (int)$alumno->edad;
    $curso = $conn->real_escape_string((string)$alumno->curso);
    
    $conn->query("INSERT INTO alumnos (id, nombre, edad, curso) VALUES ($alumnoId, '$nombre', $edad, '$curso')");
}

// 2. Procesar Asignaturas y Matrículas
foreach($xml->alumno as $alumno) {
    $alumnoId = (int)$alumno['id'];
    foreach ($alumno->asignaturas->asignatura as $asignatura) {
        $nombreAsignatura = (string)$asignatura;
        $asignaturaId = null;

        // Buscar si la asignatura ya existe en nuestro array temporal
        foreach ($asignaturas as $item) {
            if ($item['nombre'] == $nombreAsignatura) {
                $asignaturaId = $item['id'];
                break;
            }
        }

        if ($asignaturaId === null) {
            $asignaturaId = $idAsignaturaContador++;
            $asignaturas[] = ['id' => $asignaturaId, 'nombre' => $nombreAsignatura];
            
            $nombreEscaped = $conn->real_escape_string($nombreAsignatura);
            $conn->query("INSERT INTO asignaturas (id_asignatura, nombre) VALUES ($asignaturaId, '$nombreEscaped')");
        }

        // Guardar para la inserción masiva de matrículas
        $matriculas[] = [
            'alumno_id' => $alumnoId, 
            'asignatura_id' => $asignaturaId
        ];
    }
}

// 3. Insertar Matrículas
foreach($matriculas as $m) {
    $aid = $m['alumno_id'];
    $asid = $m['asignatura_id'];
    $conn->query("INSERT INTO matriculas (id_alumno, id_asignatura) VALUES ($aid, $asid)");
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión DAM - Resultados</title>
    <style>
        table { border-collapse: collapse; width: 50%; margin-bottom: 20px; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background-color: #f4f4f4; }
    </style>
</head>
<body>
    <h1>Alumnos</h1>
    <table>
        <thead>
            <tr><th>ID</th><th>Nombre</th><th>Edad</th><th>Curso</th></tr>
        </thead>
        <tbody>
            <?php foreach ($xml->alumno as $al): ?>
            <tr>
                <td><?= $al['id'] ?></td>
                <td><?= $al->nombre ?></td>
                <td><?= $al->edad ?></td>
                <td><?= $al->curso ?></td>
            </tr>
            <?php endforeach; ?>
        </tbody>
    </table>

    <h1>Asignaturas</h1>
    <table>
        <thead>
            <tr><th>ID</th><th>Nombre</th></tr>
        </thead>
        <tbody>
            <?php foreach ($asignaturas as $as): ?>
            <tr>
                <td><?= $as['id'] ?></td>
                <td><?= $as['nombre'] ?></td>
            </tr>
            <?php endforeach; ?>
        </tbody>
    </table>

    <h1>Matrículas</h1>
    <table>
        <thead>
            <tr><th>ID Alumno</th><th>ID Asignatura</th></tr>
        </thead>
        <tbody>
            <?php foreach ($matriculas as $mat): ?>
            <tr>
                <td><?= $mat['alumno_id'] ?></td>
                <td><?= $mat['asignatura_id'] ?></td>
            </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
</body>
</html>