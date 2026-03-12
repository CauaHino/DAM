<?php

$host = 'mariadb-dam';
$username = 'root';
$password = 'root';
$database = 'gestionDAM';

$conn = new mysqli($host, $username, $password, $database);

if($conn -> connect_error){
    die('Error: no fue posible conectar con la DB ' . $conn->connect_error);
}
$conn->query('drop table if exists alumnos');

$sqlAlumnos = "create table alumnos(
                    id int primary key,
                    nombre varchar(30) not null,
                    edad int not null,
                    curso varchar(20)
                    )";

if($conn->query($sqlAlumnos) === true){
    echo "<!-- Tabla creada correctamente -->";
} else {
    die('Error al crear la tabla ' . $conn->error);
}

$xml = simplexml_load_file('solución_dam.xml');

if($xml === false){
    die('Error al cargar el XML');
};

foreach($xml -> alumno as $alumno){
    $alumnoID = (int)$alumno['id'];
    $alumnoNombre = $conn->real_escape_string((string)$alumno->nombre);
    $alumnoEdad = (int)$alumno->edad;
    $alumnoCurso = $conn->real_escape_string((string)$alumno->curso);

    $sqlInsert = "insert into alumnos (id, nombre, edad, curso) values
                    ($alumnoID, '$alumnoNombre', $alumnoEdad, '$alumnoCurso')";
    $conn->query($sqlInsert);
};

$conn->close();

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistemas de Gestion DAM</title>
    <link rel="stylesheet" href="">
</head>
<body>
    <div>
        <h1>Alumnos</h1>
        <table>
            <thead>
                <tr>
                    <th>id_alumno (PK)</th>
                    <th>nombre</th>
                    <th>edad</th>
                    <th>curso</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($xml->alumno as $alumno):?>
                <tr>
                    <td><?php echo $alumno['id']; ?></td>
                    <td><?php echo $alumno->nombre; ?></td>
                    <td><?php echo $alumno->edad; ?></td>
                    <td><?php echo $alumno->curso; ?></td>
                </tr>
                <?php endforeach; ?>
            </tbody>
        </table>

        <h1>Asignaturas</h1>
        <table>
            <thead>
                <tr>
                    <th>id_asignatura (PK)</th>
                    <th>nombre_asignatura</th>
                </tr>
            </thead>
            <tbody>
                    <?php foreach ($asignaturas as $asignatura):?>
                    <tr>
                        <td><?php echo $asignatura['id']; ?></td>
                        <td><?php echo $asignatura['nombre']; ?></td>
                    </tr>
                    <?php endforeach; ?>
            </tbody>
        </table>

        <h1>Matriculas</h1>
        <table>
            <thead>
                <tr>
                    <th>id_alumno</th>
                    <th>id_asignatura</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($matriculas as $matricula): ?>
                <tr>
                    <td><?php echo $matricula['alumno_id']; ?></td>
                    <td><?php echo $matricula['asignatura_id']; ?></td>
                    td
                </tr>
                <?php endforeach; ?>
            </tbody>
        </table>

        
    </div>
</body>
</html>