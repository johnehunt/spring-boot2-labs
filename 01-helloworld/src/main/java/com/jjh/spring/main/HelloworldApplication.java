package com.jjh.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloworldApplication {

	public static void main(String[] args) {
		System.out.print(("Starting the application"));
		SpringApplication.run(HelloworldApplication.class, args);
		System.out.print(("Application startup completed"));
	}

}
