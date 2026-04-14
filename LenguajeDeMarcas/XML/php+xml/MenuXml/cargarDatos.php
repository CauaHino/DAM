<?php

$archivo_xml = 'carta.xml';

// Paso 2: Verificar que el archivo existe y si no nos mostrará un mensaje de error
if (!file_exists($archivo_xml)) {
    echo '<tr><td colspan="5" style="color: red; text-align: center;">Error: No se encuentra el archivo datos.xml</td></tr>';

    //Terminamos la ejecución del PHP
    return;
}

$xml = simplexml_load_file($archivo_xml);

// Paso 4: Verificar que el XML se cargó correctamente
if ($xml === false){
    echo '<tr><td colspan="5" style="color: red; text-align: center;">Error: El archivo xml no es válido.xml</td></tr>';

    //Terminamos la ejecución del PHP
    return;
}

// Paso 5: Contador para llevar el control
$totalComidas = 0;

// Paso 6: Recorrer cada comida en el XML

foreach ($xml->comida as $comida) {
    $nombre = (string)$comida->nombre;
    $precio = (float)$comida->precio;
    $descripcion = (string)$comida->descripcion;
    $calorias = (string)$comida->calorias;
    
    
    // Incrementar el contador de libros
    $totalComidas++;
    
    // Mostrar los datos en una fila de la tabla
    echo "<tr>";
    echo "<td>$nombre</td>";
    echo "<td>$precio €</td>";
    echo "<td>$descripcion</td>";
    echo "<td>$calorias</td>";
    echo "</tr>";
}


// Paso 7: Si no hay comidas, mostrar un mensaje
if ($totalComidas === 0) {
    echo '<tr><td colspan="5" style="color: red; text-align: center;">No se encontraron comidas en el archivo XML.</td></tr>';
} else {
    echo "<tr><td colspan='5' style='text-align: right; font-weight: bold;'>Total de comidas: $totalComidas</td></tr>"; 
}