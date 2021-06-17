# Examen Quarkus

Último examen realizado de programación durante el primer año de la Formación Profesional de Desarrollo Web Dual. El objetivo de está prueba es crear nuestra propia aplicación web conecatada a una base de datos que contiene múltiples tablas con distintas relaciones entre ellas, aplicación desarrollada con el Framework de Java llamado Quarkus. Este framework ha sido seleccionado en lugar de Sping ya que para gente que se está iniciando, aunque no necesariamente, ofrece una gran versatildad a la hora de trabajar con el lenguage compilado Java. 

> https://quarkus.io/



## Table of Contents

1. [Porqué usar Quarkus ?](#porqué-usar-quarkus-?)
1. [Tecnologías Usadas](#tecnologías-usadas)
1. [Comandos Docker](#comandos-docker)
1. [Comandos Quarkus](#comandos-quarkus)
1. [Documentación](#documentación)
---



## Porqué usar Quarkus ?

1. Poder usarla en la nube, contenedores y entornos de servidor. El bajo consumo de memoria y el rápido tiempo de respuesta

2. Mejora la productividad. Incluye capacidades integradas para automatizar tareas repetitivas, lo que permite a los desarrolladores hacer su trabajo más rápido

3. Poder escoger tu modelo de desarrollo. Quarkus une a la perfección los modelos imperativo y reactivo para wue los desarrolladores puedan utilizar la tecnología que mejor se adapte a ellos mismos

4. LA oportunidad de optimizar Java. Quarkus optimiza Java y lo hace eficinete para contendores, entronos en la nube y sin servidor con optimización del consumo de memoria y un timepo de primera respuesta rápido

---

**[⬆ back to top](#table-of-contents)**



## Tecnologías Usadas

- Java
- Quarkus
- Maven
- Docker
- Relational DataBase SQL
- MarkDown
- Github
- Data Base H2

#### Extensiones de Quarkus

- Quarkus Resteasy Jackson
- Quarkus Reasteasy
- Quarkus Arc
- Rest Assuerd
- Assertj Core
- Quarkus Hibernate Validator
- Quarkus Hibernate ORM Panache
- Quarkus JDBC H2
- H2
- Quarkus Jacoco
- Maven Site
- Maven JavaDoc

---

**[⬆ back to top](#table-of-contents)**



## Comandos Docker

### Subir imagen app a Docker Hub

Debes seguir está serie de comandos para conseguir subir tu imagen a Docker Hub:

- .\mvnw clean package -DskipTests=true

- docker build -f src/main/docker/Dockerfile.jvm -t paulli123/olliexamen .

- docker push paulli123/olliexamen

- docker run -d --name olliContainer -p 8080:8080 paulli123/olliExamen:latest



### Gestionar contenedores

- docker pull <img_name>:<tag>

- docker rm <container_name>



### Formas de ejecutar los contenedores

#### Opción 1

###### MariaDB o MySQL

- docker run -it --rm --name maria_container -e MYSQL_ROOT_PASSWORD=developer -e MYSQL_USR=developer -e MYSQL_PASSWORD=developer -e MYSQL_DATABASE=people -p 6666:3306 -d mariadb:latest

###### PostgreSQL

- docker run -it --rm=true --name persons -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=fruit -p 6666:3306 postgres:latest


#### Opción 2

- docker build -f src/main/docker/Dockerfile.mariadb --no-cache -t my-mariadb-container .

- docker run -d --name fruits-db -p 6666:3306 my-mariadb-container

---

**[⬆ back to top](#table-of-contents)**



## Comandos Quarkus

### Creacion Proyecto Quarkus

- mvn io.quarkus:quarkus-maven-plugin:1.13.1.Final:create -DprojectGroupId=edu.pingpong -DprojectArtifactId=activerecordexamen -DclassName="edu.pingpong.activerecordexamen.ExamenResource" -Dpath="/examen"


### Añadir extensiones

- Listar extensiones disponibles <br>
`.\mvnw quarkus:list-extensions`

- Añadir una extensión <br>
`.\mvnw quarkus:add-extension -Dextensions="quarkus-hibernate-validator"`

- Eliminar una extensión <br>
`.\mvnw quarkus:remove-extension -Dextension="quarkus-resteasy-jsonb"`


### Ejecutar la aplicación

- Modo desarrollo <br>
`.\mvnw clean compile quarkus:dev -Dquarkus.profile=dev`

- Modo produción <br>
`.\mvnw clean compile quarkus:dev`


### Ejecutar casos test

- Todos los casos test <br>
`.\mvnw test`

- Tests de unidad <br>
`.\mvnw -Dtest="<nombre_archivo_casos_test>" test`

- Tests de integración <br>
`.\mvnw -Dtest="<nombre_archivo_casos_test>" test`


### Package y Creación de un Über-jar

- Package <br>
`.\mvnw package`

- Über-jar <br>
`.\mvnw package -Dquarkus.package.type=uber-jar`

### Crear un nativo ejecutable 

- Con GraalVM instalado <br>
`.\mvnw package -Pnative`

- Sin GraalVM instalado <br>
`.\mvnw package -Pnative -Dquarkus.native.container-build=true`

---

**[⬆ back to top](#table-of-contents)**



## Documentación

> En el interior del directorio **target** encontraremos un directorio llamado **site**, en su interior encontraremos toda la documentación del proyecto Quarkus, con la posibilidad de poder leerla tanto en español, como inglés o francés. Espero que te ayude y resuelva cualquier duda generada entorno a la aplicación Quarkus. 

> En el caso de que la documentación no se haya generado o no se haya puesto en seguimiento puedes crearla con tan solo un comando desde la terminal, ejecuta `mvn clean site`.

---

**[⬆ back to top](#table-of-contents)**