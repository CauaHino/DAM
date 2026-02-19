<?php
$archivoXml = 'carta.xml';
$mensaje = '';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Verificar que todos los campos existen
    $camposRequeridos = ['nombre', 'precio', 'descripcion', 'calorias'];
    foreach ($camposRequeridos as $campo) {
        if (!isset($_POST[$campo]) || $_POST[$campo] === '') {
            die("Error: el campo '$campo' es obligatorio.");
        }
    }

    $nombre      = htmlspecialchars(trim($_POST['nombre']));
    $precio      = floatval($_POST['precio']);
    $descripcion = htmlspecialchars(trim($_POST['descripcion']));
    $calorias    = intval($_POST['calorias']);

    if (file_exists($archivoXml)) {
        $xml = simplexml_load_file($archivoXml);
    } else {
        $xml = new SimpleXMLElement('<carta/>');
    }

    $comida = $xml->addChild('comida');
    $comida->addChild('nombre',      $nombre);
    $comida->addChild('precio',      $precio);
    $comida->addChild('descripcion', $descripcion);
    $comida->addChild('calorias',    $calorias);

    $dom = new DOMDocument('1.0', 'UTF-8');
    $dom->preserveWhiteSpace = false;
    $dom->formatOutput       = true;
    $dom->loadXML($xml->asXML());
    $dom->save($archivoXml);

    $mensaje = "Comida añadida correctamente.";
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Añadir Comida</title>
</head>
<body>

    <?php if ($mensaje): ?>
        <p style="color: green;"><?= $mensaje ?></p>
    <?php endif; ?>

    <form method="post" action="">
        <table id="anadir-comida">
            <tr>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Descripción</th>
                <th>Calorías</th>
            </tr>
            <tr>
                <td><input type="text" name="nombre" required></td>
                <td><input type="number" name="precio" step="0.01" required></td>
                <td><input type="text" name="descripcion" required></td>
                <td><input type="number" name="calorias" required></td>
            </tr>
            <tr>
                <td colspan="4">
                    <button type="submit">Añadir comida</button>
                    <button type="button" onclick="window.location.href='index.php'">Volver al menú</button>
                </td>
            </tr>
        </table>
    </form>

</body>
</html>