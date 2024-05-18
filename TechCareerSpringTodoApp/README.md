# Umut Yıldırım - Todo App With Java Spring

# TechCareer Fullstack Bootcamp TodoApp Project

A simple Todo list application using Spring Boot with the following options:

- Spring MVC for algorithm design.
- Spring JPA and MySQL for data persistence.
- Thymeleaf and Bootstrap5 template for the rendering.
- H2DB for testing.
- Swagger for API operations (CRUD).
- Inheritance-Interfaces-Enum structures are applied.
- Docker for building and deploying.
- Lombok used for creating getter/setter methods in models.
- Servlet used to handle HTTP requests and generate responses in Java web applications. 


To build and run the application:

## Configure MySQL

1. Create a database in MySQL.
2. Update the application.properties file in the `src/main/resources` folder with your server URL, username and password for your MySQL instance. The table schema for the Todo objects will be created for you in the database via code first approach.


## Build and run the sample

N.B. This needs at least the Java 11 JDK.

1. `mvnw package`
2. Open a web browser to http://localhost:8080
3. For Swagger UI, http://localhost:8080/swagger-ui.html
4. For API services, http://localhost:8080/api/todos/?

As you add, delete and update some tasks in the app you can verify the changes in the database via MySQL console using simple queries like 
`SELECT * FROM todo_item`.

