<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h2>Calculadora Simple</h2>
        
        <form method="post" action="">
            <input type="number" name="num1" placeholder="Número 1" required>
            <input type="number" name="num2" placeholder="Número 2" required>
            <select name="operacion" required>
                <option value="sumar">Sumar</option>
                <option value="restar">Restar</option>
                <option value="multiplicar">Multiplicar</option>
                <option value="dividir">Dividir</option>
            </select>
            <button type="submit">Calcular</button>

            <?php
            if ($_SERVER["REQUEST_METHOD"] == "POST") {
                if (isset($_POST['num1'], $_POST['num2'], $_POST['operacion'])) {
                    $num1 = $_POST['num1'];
                    $num2 = $_POST['num2'];
                    $operacion = $_POST['operacion'];
                    $resultado = 0;
                    $error = "";

                    switch ($operacion) {
                        case "sumar": $resultado = $num1 + $num2; break;
                        case "restar": $resultado = $num1 - $num2; break;
                        case "multiplicar": $resultado = $num1 * $num2; break;
                        case "dividir":
                            if ($num2 != 0) $resultado = $num1 / $num2;
                            else $error = "Error: División por cero.";
                            break;
                    }

                    if ($error) {
                        echo "<p class='error'>$error</p>";
                    } else {
                        echo "<h3>Resultado: $resultado</h3>";
                    }
                }
            }
            ?>
        </form>
    </div>
</body>
</html>