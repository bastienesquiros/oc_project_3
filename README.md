# Châtop — Backend API

REST API pour la plateforme de location saisonnière Châtop, construite avec Spring Boot 4.

## Prérequis

- Java 21
- Maven (ou utiliser le wrapper `./mvnw` inclus)
- MySQL 8+

## Installation

### 1. Base de données

Créer la base de données et exécuter le script d'initialisation :

```sql
CREATE DATABASE chatop_db;
```

Puis exécuter `src/main/resources/sql/schema.sql` dans votre client MySQL via **Execute SQL Script**.

### 2. Configuration

Éditer `src/main/resources/application-dev.properties` avec vos identifiants :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/chatop_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=validate

jwt.secret=YOUR_BASE64_SECRET
jwt.expiration=86400000
```

### 3. Lancer l'application

```bash
./mvnw spring-boot:run
```

L'API est disponible sur `http://localhost:8080`.

## Swagger

Documentation interactive : `http://localhost:8080/swagger-ui.html`
