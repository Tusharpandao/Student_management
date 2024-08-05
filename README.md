## Student Management System

A Spring Boot project for managing students, subjects, and enrollments, with JWT authentication and role-based authorization.

### Prerequisites

* Java 21
* MySQL
* Maven

### Setup

1. Clone the repository.
2. Create a MySQL database named `student_management`.
3. Update `application.properties` with your MySQL credentials.
4. Build the project: `mvn clean install`.
5. Run the application: `mvn spring-boot:run`.

### API Endpoints

* `/api/auth/login` (POST): Authenticate and get a JWT token.
* `/api/students` (GET/POST): Get all students (admin) / Create a student (admin).
* ... (add other endpoints)
