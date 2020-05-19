package com.jjh.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jjh.spring.beans","com.jjh.spring.store"})
public class Main {

	public static void main(String[] args) {
		System.out.println("---------------------------------------");
		System.out.print(("Main - Starting the Bookshop Service"));
		SpringApplication.run(Main.class, args);
		System.out.println("Main - Setup finished");
		System.out.println("---------------------------------------");
	}

}
