<?php

    $xml = simplexml_load_file("solucion_dam.xml");

    $asignaturas = [];
    $matriculas = [];
    $idAsignatura =  1;
    
    foreach($xml->alumno as $alumno){
        $alumnoId = (string)$alumno['Id'];

        foreach($alumno->asignaturas->asignatura as $asignatura){
            $asignaturaNombre = (string)$asignatura;

            $asignaturaExistente = false;
            $asignaturaId = null;

            foreach($asignaturas as $key => $value){
                if($value['nombre'] == $asignaturaNombre){
                    $asignaturaExistente = True;
                    $asignaturaId = $value['id'];
                    break;
                }
            }

            if (!$asignaturaExistente){
                $asignaturas[] = [
                    'id' => $idAsignatura,
                    'nombre' => $asignaturaNombre
                ];
                $asignaturaId = $idAsignatura;
                $idAsignatura++;
            }

            $matriculas[] = [
                'alumno_id' => $alumnoId,
                'asignatura_id' => $asignaturaId
            ];
        }
    }

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