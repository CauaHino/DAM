<?php

$xml = simplexml_load_file("solución_ejercicio2.xml");


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

