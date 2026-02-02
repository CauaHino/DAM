<?php
// 1. CONEXIÓN (Pon tus datos reales aquí)
$servidor = "localhost";
$usuario = "root";
$password = "";
$base_datos = "formularios_simple";
$tabla = "tabla_contactos";           

$conn = new mysqli($servidor, $usuario, $password, $base_datos);

if ($conn->connect_error) {
    die("Error de conexión: " . $conn->connect_error);
}

// 2. VERIFICAR SI RECIBIMOS UN ID
if (isset($_GET['id'])) {
    $id = $_GET['id'];

    // 3. BORRAR EL REGISTRO
    // Usamos prepare para seguridad
    $sql = "DELETE FROM $tabla WHERE id = ?";
    
    if ($stmt = $conn->prepare($sql)) {
        $stmt->bind_param("i", $id);
        $stmt->execute();
        $stmt->close();
    }
}

// 4. REDIRECCIONAR AUTOMÁTICAMENTE A LA LISTA
// Esto hace que vuelvas a la tabla y veas que ya no está el registro
header("Location: bbdd.php");
exit();
?>