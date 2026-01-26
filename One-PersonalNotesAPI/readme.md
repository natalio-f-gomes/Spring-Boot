# Author: Natalio Gomes

### Project 1: PersonalNotesAPI

This project exist for the sole purpose of learning Spring Boot.

Order of the workflow:
1. Dependencies

Required dependencies for database access and ORM:

SQLite JDBC – SQLite database driver

Hibernate Community Dialects – SQLite dialect support

Spring Boot Starter Data JPA – JPA and Hibernate integration

    <dependency>
        <groupId>org.xerial</groupId>
        <artifactId>sqlite-jdbc</artifactId>
        <version>3.51.1.0</version>
    </dependency>
    
    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-community-dialects</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

2. SQLite Database configuration
    spring.datasource.url=jdbc:sqlite:src/main/resources/data/database.db // path of the db
    
    spring.datasource.driver-class-name=org.sqlite.JDBC
    spring.jpa.database-platform=org.hibernate.community.dialect.SQLiteDialect
    
    spring.jpa.hibernate.ddl-auto=update
    
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true

3. Model Set Up
4. Repository Set up
   - Tell Jpa what is Model that JPA should create a table and the id datatype
5. Services CRUD Functionality
6. Controllers - Mapping