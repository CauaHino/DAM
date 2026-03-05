<?php

$host = 'mariadb-dam';
$username = 'root';
$password = 'root';
$database = 'biblioteca_db';

$conn = new mysqli($host, $username, $password, $database);

if($conn -> connect_error){
    die('Error: no fue posible conectar con la DB ' . $conn->connect_error);
}
$conn->query('drop table if exists biblioteca');

$sqlBiblioteca = "create table biblioteca(
                    id int auto_increment primary key,
                    titulo varchar(255) not null,
                    autor varchar(30) not null,
                    fechaNacimiento varchar(20),
                    anoPublicacion int not null
                    )";

if($conn->query($sqlBiblioteca)=== true){
    echo "<!-- Tabla creada correctamente -->";
} else {
    die('Error al crear la tabla ' . $conn->error);
}

$xml = simplexml_load_file('solución_ejercicio2.xml');

if($xml === false){
    die('Error al cargar el XML');
};

foreach($xml->libro as $libro){
    $titulo = $conn->real_escape_string((string)$libro->titulo);
    $autor = $conn->real_escape_string((string)$libro->autor);
    $fechaNacimiento = isset($libro->autor['fechaNacimiento']) ? $conn->real_escape_string((string)$libro->autor['fechaNacimiento']) : null;
    $anoPublicacion = (int)$libro->fechaPublicacion['año'];

    $sqlInsert = 'Insert into biblioteca (titulo, autor, fechaNacimiento, anoPublicacion) values
                    (?, ?, ?, ?)';

    $stmt = $conn->prepare($sqlInsert);
    $stmt->bind_param('sssi', $titulo, $autor, $fechaNacimiento, $anoPublicacion);

    if(!$stmt->execute()){
        echo 'Error al insertar libro ' . $stmt->error . '\n';
    }

    $stmt->close();
}

$conn->close();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistemas de Gestion Biblioteca</title>
    <link rel="stylesheet" href="">
</head>
<body>
    <div>
        <h1>BIBLIOTECA</h1>
        <table>
            <thead>
                <tr>
                    <th>Titulo</th>
                    <th>Autor</th>
                    <th>Fecha de Nacimiento</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($xml->libro as $libro):?>
                <tr>
                    <td><?php echo $libro->titulo; ?></td>
                    <td><?php echo $libro->autor . " ". $libro->autor['fechaNacimiento']; ?></td>
                    <td><?php echo $libro->fechaPublicacion['año']; ?></td>
                </tr>
                <?php endforeach; ?>
            </tbody>
        </table>        
    </div>
</body>
</html>
