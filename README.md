# PicPay Clone Backend

## Tecnologias

- Java
- Spring Framework (Spring Boot)
- PostgreSQL
- Clean Architecture (Hexagonal Architecture)
- Authentication with JWT
- Cache
- Redis

### Bibliotecas

- Spring WEB 6
- Spring Data JPA
- Spring Security 6
- Spring DevTools
- Spring Data Redis
- Validation (Jakarta)
- PostgreSQL Driver
- JJWT
- Lombok
- ModelMapper

## Diagrama de classes

![Diagrama de classes](/files/diagrama-de-classes.png)

## Rodar

### Requisitos

- Docker instalado
- Java 21 Runtime instalado

### Comandos

- docker compose up -d
- popular dados src/main/resources/data.sql no banco
- ./mvnw package
- java -jar target/picpayclone-0.0.1-SNAPSHOT.jar
