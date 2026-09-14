CMS – Complaint Management System

A web-based Complaint Management System (CMS) built using Spring Boot. The application provides user authentication, complaint management, role-based access, and an admin dashboard.

Features
User registration and login
User authentication with Spring Security
Role-based access control
Submit and manage complaints
Admin dashboard
User management
Complaint management
MySQL database integration
Server-side rendered pages using Thymeleaf
JPA/Hibernate for database operations
Technologies Used
Java
Spring Boot
Spring MVC
Spring Security
Spring Data JPA
Hibernate
MySQL
Thymeleaf
HTML / CSS
Maven / Gradle
Project Structure
## Project Structure

```text
cms/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/cms/demo/
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── dto/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── security/
│   │   │       └── service/
│   │   └── resources/
│   │       ├── templates/
│   │       └── application.properties
│   └── test/
│       └── java/
├── gradle/
├── build.gradle
├── pom.xml
├── settings.gradle
├── gradlew
└── gradlew.bat
```
Database Setup

This project uses MySQL.

Create the database:

CREATE DATABASE cms;


Configure the database connection in:

src/main/resources/application.properties


Example:

spring.datasource.url=jdbc:mysql://localhost:3306/cms
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD


Make sure MySQL is running before starting the application.

Running the Application
Using Maven

On Windows:

mvnw.cmd spring-boot:run


Or, if Maven is installed globally:

mvn spring-boot:run

Using Gradle

On Windows:

gradlew.bat bootRun


The application runs on:

http://localhost:8081

Database Configuration

The project uses Spring Data JPA and Hibernate for database operations.

spring.jpa.hibernate.ddl-auto=update


This allows Hibernate to update the database schema based on the application's entity classes.

Main Modules
Authentication

Provides user registration, login, and authentication using Spring Security.

Complaint Management

Users can submit and manage complaints through the web application.

Admin Management

Administrators can access the admin dashboard and manage users and complaints.

Persistence

Spring Data JPA and Hibernate are used to communicate with the MySQL database.

Author

Vinod Kumar Reddy

GitHub: Vinodkumarreddy1978

License

This project is intended for educational and project-development purposes.
