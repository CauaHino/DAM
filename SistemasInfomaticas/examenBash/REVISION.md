# Corrección examen UT3
## Apartado 1
### Estructura (1 punto)
OK
#### Nota: 1

### Operaciones (1,5 puntos)
| Ítem | Descripción del ítem                                                                      | Valor   | Corrección                                                                                 | Obtenido |
| ---- | ----------------------------------------------------------------------------------------- | ------- | ------------------------------------------------------------------------------------------ | -------- |
| 1    | Crear el directorio `backup` dentro de `core/go/auth` desde `/` usando ruta relativa      | 0,15    | No partes desde `/` como indica el enunciado.                                              | 0,00     |
| 2    | Crear `mirror.rs` en `core/go/api` desde `core/rust/physics` usando ruta relativa         | 0,15    | Sintaxis incorrecta (`touch ../../go/api mirror.rs`). No se crea el archivo correctamente. | 0,00     |
| 3    | Copiar todos los `.rs` de `core/rust/physics` a `core/go/api` usando solo rutas relativas | 0,20    | Correcto (aunque `-r` no es necesario).                                                    | 0,20     |
| 4    | Mover `NOTES.txt` a `core/rust/physics` usando ruta absoluta                              | 0,15    | No usas ruta absoluta en el origen como se exige.                                          | 0,00     |
| 5    | Renombrar `physics` como `physics_old` sin salir de `core/rust`                           | 0,20    | Correcto                                                                                   | 0,20     |
| 6    | Copiar únicamente los `.go` de `core/go/api` a `core/go/auth`                             | 0,20    | Correcto (aunque `-r` no es necesario).                                                    | 0,20     |
| 7    | Borrar solo los archivos `.cache` de `core/rust/physics_old`                              | 0,15    | Correcto (aunque `-rf` es más agresivo de lo necesario).                                   | 0,15     |
| 8    | Mover los archivos de `auth` que empiecen por `t` a `core/go/api`                         | 0,15    | No implementado.                                                                           | 0,00     |
| 9    | Eliminar el directorio `api` y todo su contenido usando ruta absoluta                     | 0,15    | Correcto                                                                                   | 0,15     |
|      | **NOTA**                                                                                  | **1,5** |                                                                                            | **0,90** |



## Apartado 2 (2,5 puntos)
| Ítem | Descripción del ítem                                            | Valor    | Corrección                                                                              | Obtenido |
| ---- | --------------------------------------------------------------- | -------- | --------------------------------------------------------------------------------------- | -------- |
| 1    | Borrar pantalla y mostrar encabezado exactamente como se indica | 0,10     | Correcto                                                                                | 0,10     |
| 2    | Solicitar nombre de directorio correctamente                    | 0,20     | Correcto                                                                                | 0,20     |
| 3    | Comprobar existencia del directorio con `-d`                    | 0,40     | La comprobación está bien planteada, pero falta `;` antes de `then` (error de sintaxis) | 0,30     |
| 4    | Crear directorio solo si no existe                              | 0,30     | Correcto                                                                                | 0,30     |
| 5    | Mostrar mensaje exactamente como se pide cuando existe          | 0,15     | El mensaje no es exactamente literal al enunciado                                       | 0,10     |
| 6    | Capturar correctamente la opción del usuario                    | 0,15     | Correcto                                                                                | 0,15     |
| 7    | Opción C vuelve correctamente al punto 2                        | 0,25     | Funciona relanzando el script, pero no es estructura ideal                              | 0,20     |
| 8    | Opción B borra y muestra mensaje esperando tecla                | 0,30     | Borra correctamente, pero no espera tecla como se pide                                  | 0,20     |
| 9    | Opción R renombra correctamente usando `mv`                     | 0,40     | Correcto uso de `mv`, aunque falta esperar tecla al final                               | 0,35     |
| 10   | Opción S confirma salida y actúa correctamente                  | 0,25     | Correctamente planteado                                                                 | 0,25     |
|      | **Nota**                                                        | **2,50** |                                                                                         | **2,15** |


## NOTA EXAMEN PRÁCTICO (sobre 5 puntos): 4.05