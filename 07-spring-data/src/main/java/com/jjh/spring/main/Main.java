package com.jjh.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.jjh.spring.beans",
		"com.jjh.spring.store",
		"com.jjh.spring.controllers"})
@EntityScan("com.jjh.spring.store")
@EnableJpaRepositories("com.jjh.spring.repo")
public class Main {

	public static void main(String[] args) {
		System.out.println("---------------------------------------");
		System.out.print(("Main - Starting the Bookshop Service"));
		SpringApplication.run(Main.class, args);
		System.out.println("Main - Server Started");
		System.out.println("\tSee - http://localhost:8080/books/list");
		System.out.println("---------------------------------------");
	}

}
