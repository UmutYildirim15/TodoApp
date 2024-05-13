package com.todo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// This code enables a Spring Boot application to be deployed as a WAR file
// by extending SpringBootServletInitializer and overriding the configure method
// to set TodoApplication as the application source.
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TodoApplication.class);
	}

}
