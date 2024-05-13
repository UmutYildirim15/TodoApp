package com.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// Enable Swagger for API documentation
@EnableSwagger2
@SpringBootApplication
public class TodoApplication {

	// Main method to start the Spring Boot application
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}
