## 🎼 Docker Compose: El Director de Orquesta
*Gestiona varios contenedores como si fueran uno solo.*

### 🚀 Comandos principales
- **`docker-compose up -d`**: Enciende todo el entorno (PHP + DB + phpMyAdmin) en segundo plano.
- **`docker-compose stop`**: Apaga los servicios pero mantiene los contenedores.
- **`docker-compose down`**: Borra los contenedores y limpia la red (tus datos en `volumes` siguen a salvo).
- **`docker-compose logs -f`**: Mira qué errores está dando tu código PHP o la base de datos en tiempo real.

### 🌐 Direcciones de tu entorno
- **Web (PHP)**: `http://localhost`.
- **phpMyAdmin**: `http://localhost:8080` (Usuario: `root` / Pass: `root`).
- **Base de Datos (Host)**: En tu código PHP, el host no es "localhost", es **`db`**.

---

## 📁 Organización de Proyectos Múltiples

### 🛠️ Opción A: Por Carpetas (Recomendado)
Cada proyecto en su sitio para no mezclar redes ni volúmenes.
- `cd ~/proyectos/web && docker-compose up -d`
- `cd ~/proyectos/bbdd && docker-compose up -d`

### 🛠️ Opción B: Archivos con Nombre Específico
Si necesitas configuraciones distintas en un mismo sitio:
- **Lanzar**: `docker-compose -f nombre-archivo.yml up -d`
- **Detener**: `docker-compose -f nombre-archivo.yml down`

---

## ⚠️ ¡Cuidado con los Puertos!
Si tienes dos `docker-compose` distintos, no pueden usar el mismo puerto de tu Windows a la vez.
- **Proyecto 1**: Puerto `80:80` (Ocupa el puerto 80).
- **Proyecto 2**: Puerto `8080:80` (Ocupa el 8080 para no chocar con el 1).