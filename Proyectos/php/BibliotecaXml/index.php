<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leer XML con PHP</title>
    <!-- Mismo CSS que antes -->
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Catálogo de Libros</h1>
    <p>Datos cargados desde XML usando PHP</p>
    
    
    <!-- Contenedor de la tabla (visible cuando hay datos) -->
    <div id="contenedor-tabla">
        <table id="tabla-libros">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Año</th>
                    <th>Precio</th>
                </tr>
            </thead>
            <tbody id="cuerpo-tabla">
                <?php
                include 'cargarDatos.php';
                ?>
            </tbody>
        </table>
    </div>
</body>
</html>