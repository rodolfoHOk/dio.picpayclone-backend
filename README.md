# PicPay Clone Backend

## Tecnologias

- Java
- Spring Framework (Spring Boot)
- PostgreSQL
- Clean Architecture (Hexagonal Architecture)

### Bibliotecas

- Spring WEB
- Spring Data JPA
- Spring DevTools
- Validation (Jakarta)
- PostgreSQL Driver
- Lombok

## Diagrama de classes

![Diagrama de classes](/files/diagrama-de-classes.png)

## Rodar

### Requisitos

- Docker instalado
- Java 21 Runtime instalado

### Comandos

- docker run --name postgresdev -p 5432:5432 -v postgres_vol:/var/lib/postgresql/data -e POSTGRES_PASSWORD=admin -e POSTGRES_USER=admin -e POSTGRES_DB=picpay -d postgres:alpine
- ./mvnw package
- java -jar target/picpayclone-0.0.1-SNAPSHOT.jar

#### até o final da parte 13
