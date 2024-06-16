![Static Badge](https://img.shields.io/badge/Status-TERMINADO-green)


# LiterAlura

Este proyecto es parte de uno de los Challenges que a Propuest Alura Latam en su certificacion de Oracle One.

Para el desarrollo de esta aplicacion de consola se utilizo la API de Gutendex (https://gutendex.com/)


## Tech Stack

![Static Badge](https://img.shields.io/badge/Java-SDK_21-green)
![Static Badge](https://img.shields.io/badge/Gradle-Version_8.8-brown)
![Static Badge](https://img.shields.io/badge/PostgreSQL-Version_16-blue)
![Static Badge](https://img.shields.io/badge/Spring_Boot-Version_3.3.0-red)
## Documentation
**Installation**
- Descarga e instalar la ultima version de Gradle desde el sitio oficial https://gradle.org/install/
- Descargar e instalar la ultima version de PostgreSQL desde el sitio oficial https://www.postgresql.org/download/
- Descargar e instalar la version 21 o la ultima de Java https://www.oracle.com/es/java/technologies/downloads/#java21

**Configuracion**
- Clona el projecto por medio de SSH o https
- Abre application.properties y configura HOST, USER, PASS con las claves de acceso a tu base de datos de PostgreSQL
- Crea las tablas necesarias con las columnas correspondientes ```CREATE TABLE test (id INT, muerte INT, nacimiento INT, nombre VARCHAR(255));``` Y ```CREATE TABLE test (id INT, descargas INT, idioma VARCHAR(255), titulo VARCHAR(255), author_id int);```
- Run ```gradle clean``` para limpiar el proyecto
- Run ```gradle build``` para construir el projecto, al momento de correr el comando tendras un error ```Execution failed for task ':test'.``` ignoralo
- Abre el folder ```build > libs``` y contraras el JAR file para ejeuctar
- abre una consola de cmd y ejecuta ```java -jar YOUR_PATH_FILE\LiterAlura2\build\libs\LiterAlura2-0.0.1-SNAPSHOT.jar```