# Author: Natalio Gomes

### Project 2: SimpleSchoolManagementSystem

This project exist for the sole purpose of getting familiar with Database relationship

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




The server will start at `http://localhost:8080`

## API Endpoints

### Students

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/student/add` | Create a new student |
| GET | `/api/v1/student/get/all` | Get all students |
| GET | `/api/v1/student/get/{id}` | Get student by ID |
| PUT | `/api/v1/student/update/{id}` | Update student by ID |
| DELETE | `/api/v1/student/delete/{id}` | Delete student by ID |
| POST | `/api/v1/student/get/{studentID}/register/{subjectID}` | Register student for a subject |

### Subjects

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/subject/add` | Create a new subject |
| GET | `/api/v1/subject/get/all` | Get all subjects |
| GET | `/api/v1/subject/get/{id}` | Get subject by ID |
| PUT | `/api/v1/subject/update/{id}` | Update subject by ID |
| DELETE | `/api/v1/subject/delete/{id}` | Delete subject by ID |
| GET | `/api/v1/subject/get/student/{id}` | Get all subjects for a student |

## Example Requests

### Create a Student

```bash
curl -X POST http://localhost:8080/api/v1/student/add \
  -H "Content-Type: application/json" \
  -d '{
    "username": "johndoe"
  }'
```

Response:
```json
{
  "id": 1,
  "username": "johndoe",
  "createdAt": "2026-01-27T15:00:00.000",
  "updatedAt": "2026-01-27T15:00:00.000",
  "subjects": []
}
```

### Create a Subject

```bash
curl -X POST http://localhost:8080/api/v1/subject/add \
  -H "Content-Type: application/json" \
  -d '{
    "crn": "CS101",
    "title": "Introduction to Computer Science"
  }'
```

Response:
```json
{
  "id": 1,
  "crn": "CS101",
  "title": "Introduction to Computer Science",
  "createdAt": "2026-01-27T15:00:00.000",
  "updatedAt": "2026-01-27T15:00:00.000"
}
```

### Register Student for a Subject

```bash
curl -X POST http://localhost:8080/api/v1/student/get/1/register/1
```

### Get All Students

```bash
curl http://localhost:8080/api/v1/student/get/all
```

### Get Student by ID

```bash
curl http://localhost:8080/api/v1/student/get/1
```

### Update a Student

```bash
curl -X PUT http://localhost:8080/api/v1/student/update/1 \
  -H "Content-Type: application/json" \
  -d '{
    "username": "janedoe"
  }'
```

### Delete a Student

```bash
curl -X DELETE http://localhost:8080/api/v1/student/delete/1
```

### Get Subjects by Student ID

```bash
curl http://localhost:8080/api/v1/subject/get/student/1
```

## Project Structure

```
src/main/java/dev/nataliogomes/twosimpleschoolmanagementsystem/
├── Controllers/
│   ├── StudentController.java
│   └── SubjectController.java
├── Models/
│   ├── StudentModel.java
│   └── SubjectModel.java
├── Repositories/
│   ├── StudentRepository.java
│   └── SubjectRepository.java
├── Services/
│   ├── StudentService.java
│   └── SubjectService.java
└── TwoSimpleSchoolManagementSystemApplication.java
```

## Database Schema

### Students Table
| Column | Type | Description |
|--------|------|-------------|
| id | Long | Primary key |
| username | String | Student username |
| created_at | DateTime | Record creation timestamp |
| updated_at | DateTime | Record update timestamp |

### Subjects Table
| Column | Type | Description |
|--------|------|-------------|
| id | Long | Primary key |
| crn | String | Course Reference Number |
| title | String | Subject title |
| created_at | DateTime | Record creation timestamp |
| updated_at | DateTime | Record update timestamp |

### Student_Subjects Table (Join Table)
| Column | Type | Description |
|--------|------|-------------|
| student_id | Long | Foreign key to students |
| subject_id | Long | Foreign key to subjects |

## License

This project is for educational purposes.