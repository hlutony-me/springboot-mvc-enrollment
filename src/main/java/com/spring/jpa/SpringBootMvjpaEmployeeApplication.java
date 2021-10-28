package com.spring.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class SpringBootMvjpaEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvjpaEmployeeApplication.class, args);
		System.out.println("Spring Boot MVC JPA app is ready...");
	}
}
