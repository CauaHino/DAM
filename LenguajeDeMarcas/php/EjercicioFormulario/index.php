<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <form method="post" action="procesar.php" enctype="multipart/form-data">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>

        <label for="edad">Edad:</label>
        <input type="number" id="edad" name="edad" required>

        <label for="sexo">Sexo:</label>
        <select id="sexo" name="sexo" required>
            <option value="masculino">Masculino</option>
            <option value="femenino">Femenino</option>
        </select>

        <p>Roles</p>
        <div class="checkbox-group">
            <div class="checkbox-item">
                <input type="checkbox" id="rol1" name="roles[]" value="admin">
                <label for="rol1">Administrador</label>
            </div>
            <div class="checkbox-item">
                <input type="checkbox" id="rol2" name="roles[]" value="editor">
                <label for="rol2">Editor</label>
            </div>
            <div class="checkbox-item">
                <input type="checkbox" id="rol3" name="roles[]" value="usuario">
                <label for="rol3">Usuario</label>
            </div>
        </div>

        <label for="imagen">Imagen:</label>
        <input type="file" id="imagen" name="imagen" required>

        <label for="mensaje">Mensaje:</label>
        <textarea id="mensaje" cols="40" rows="10" name="mensaje" required></textarea>

        <button type="submit">Enviar</button>
    </form>
    <a href="mostrar.php">Ver registros guardados</a>
    
</body>
</html>