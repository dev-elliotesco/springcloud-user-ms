# User Microservice 

## Descripción
Este es un microservicio de usuario desarrollado con Spring Boot y Spring Cloud.
Este microservicio se encarga de la gestión de usuarios, incluyendo operaciones 
como la creación, actualización, eliminación y consulta de usuarios.


## Requisitos & Tecnologías
- Java Development Kit (JDK) 17
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Cloud](https://spring.io/projects/spring-cloud)
- [Eureka Server](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-eureka-server.html)
- [Gradle](https://gradle.org/)
- [Docker](https://www.docker.com/)

## Instalación
Pasos para instalar las dependencias y el proyecto.

```bash
# Clona este repositorio
git clone https://github.com/dev-elliotesco/springcloud-user-ms.git

# Entra en el directorio del proyecto
cd springcloud-user-ms

# Compila el proyecto usando Gradle
./gradlew build

```

## Configuración
1. Antes de ejecutar el proyecto, asegúrate de tener una base de datos MySQL en ejecución 
y de configurar las siguientes variables de entorno con las credenciales correctas de 
la base de datos:

- `DB_URL`: La URL de tu base de datos. Por ejemplo, `jdbc:mysql://localhost:3308/user_db`.
- `DB_USERNAME`: El nombre de usuario de tu base de datos. Por ejemplo, `root`.
- `DB_PASSWORD`: La contraseña de tu base de datos.

2. Asegúrate de tener el servidor Eureka en ejecución. 
Puedes encontrar el código fuente y las instrucciones para ejecutar el servidor 
Eureka en el siguiente repositorio: [springcloud-eureka-service](https://github.com/dev-elliotesco/springcloud-eureka-service)

## Uso
Pasos para ejecutar el proyecto.

```bash
# Comando para iniciar el proyecto usando Gradle
./gradlew bootRun
```

```bash
# O ejecutando el JAR directamente
java -jar build/libs/user-ms-0.0.1-SNAPSHOT.jar
```

```bash
# O utilizando Docker Compose
docker-compose up
```

## Autor
- Elliot Escovicth Riaño - [Github](https://github.com/dev-elliotesco)
- [LinkedIn](https://https://www.linkedin.com/in/elliot-escovitch-580007205/)
- Correo electrónico: eescovitchr@gmail.com