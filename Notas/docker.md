---

---
# 🐋 Guía Maestra: Docker para el Grado de DAM
**Configuración optimizada para:** i5-12450H | 16GB RAM | RTX 4050

---

## 💻 1. Optimización del Sistema (Hardware)
*Configura estos límites para que Docker no ralentice tus juegos o VS Code.*

> **Comando Vital (PowerShell):** `wsl --shutdown` (Para aplicar cambios).

---

## 🛠️ 2. Gestión de Contenedores (Día a día)

*Usa estos comandos en tu terminal de **Ubuntu**.*

* **`docker ps`**: Lista contenedores encendidos.
* **`docker ps -a`**: Lista TODOS los contenedores (incluidos apagados).
* **`docker start <nombre>`**: Enciende un servicio (ej: `postgres-dam`).
* **`docker stop <nombre>`**: Apaga un servicio para liberar RAM.
* **`docker stop $(docker ps -q)`**: **BOTÓN DEL PÁNICO.** Apaga todo de golpe.

---

## 🐘 3. El "Sustituto de XAMPP" (Docker Compose)

*Crea una carpeta por proyecto con este archivo `docker-compose.yml`.*

```yaml
version: '3.8'
services:
  db:
    image: mariadb:latest
    container_name: mariadb-dam
    environment:
      MYSQL_ROOT_PASSWORD: root
    volumes:
      - db_data:/var/lib/mysql
  php:
    image: php:8.2-apache
    container_name: php-dam
    ports:
      - "80:80"
    volumes:
      - ./src:/var/www/html 
  phpmyadmin:
    image: phpmyadmin:latest
    ports:
      - "8080:80"
volumes:
  db_data:

```

* **Lanzar todo**: `docker-compose up -d`.
* **Cerrar todo**: `docker-compose down`.

---

## 🚀 4. Servicios Extra para DAM

*Herramientas que te harán destacar en clase.*

| Servicio | Comando de creación | Acceso |
| --- | --- | --- |
| **PostgreSQL** | `docker run -d --name pg-dam -e POSTGRES_PASSWORD=1234 -p 5432:5432 postgres` | `localhost:5432` |
| **MongoDB** | `docker run -d --name mongo-dam -p 27017:27017 mongo` | `localhost:27017` |
| **Portainer** | `docker run -d --name portainer -p 9000:9000 -v /var/run/docker.sock:/var/run/docker.sock portainer/portainer-ce` | `http://localhost:9000` |
| **Nginx Web** | `docker run -d --name web -p 80:80 -v /mnt/c/tu_ruta:/usr/share/nginx/html nginx` | `http://localhost:80` |

---

## 🔍 5. Inspección y Terminal

* **`docker logs -f <nombre>`**: Ver errores en tiempo real (ideal para debugging).
* **`docker exec -it <nombre> bash`**: Entra en la terminal del contenedor.
* **`docker exec -it postgres-dam psql -U postgres`**: Consola SQL directa.

---

## ⚡ 6. Automatización (Scripts de Productividad)

*Añade estos alias a tu `~/.bashrc` para ir más rápido.*

```bash
# Escribe 'estudiar' para encender tus servicios principales
alias estudiar='docker start postgres-dam mariadb-dam pgadmin-dam'

# Escribe 'descansar' para liberar tus 16GB de RAM al terminar
alias descansar='docker stop $(docker ps -q)'

```

---

## 🧹 7. Limpieza y Mantenimiento

*Tu disco de 512GB te lo agradecerá.*

* **`docker rm -f <nombre>`**: Borra un contenedor definitivamente.
* **`docker rmi <id_imagen>`**: Borra la imagen (el "instalador") para liberar gigas.
* **`docker system prune`**: Limpieza general de residuos.



