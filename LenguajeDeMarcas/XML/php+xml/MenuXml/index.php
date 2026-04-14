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
    <h1>Menu Restaurante</h1>
    <p>Datos cargados desde XML usando PHP</p>
    <button id="btn-anadir" onclick="window.location.href='anadir.php'">Añadir Comida</button>
    
    
    <!-- Contenedor de la tabla (visible cuando hay datos) -->
    <div id="contenedor-tabla">
        <table id="menu-table">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Descripción</th>
                    <th>Calorías</th>
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