# Sistema de Gestión de Eventos y Participantes

Este proyecto consiste en dos microservicios: uno para la gestión de eventos y otro para la gestión de participantes. Ambos microservicios están desarrollados con Java y Spring Boot, y se utilizan Docker y Docker Compose para la contenerización y orquestación. La persistencia de datos se realiza mediante MySQL.

## Requisitos Previos

- JDK 17 o superior
- Docker y Docker Compose
- Gradle

## Variables de entorno
Las variables para la conexión con la base de datos se encuentran en el archivo .env

## Colección postman
Se adjunta la colección para realizar la prueba en la carpeta ./doc

## Ejecución
1. Crear el jar de cada microservicio bien sea con el IDE o dentro de la carpeta de cada uno, ejecutar el comando ./gradlew clean build. Esto desde una terminal
2. Levantar todos los servicios. Desde un terminal ejecutar docker-compose up -d. Este comando debe realizarse parado en la raiz de la aplicación. 