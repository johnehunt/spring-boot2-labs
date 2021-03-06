package com.jjh.spring.main;

import com.jjh.spring.store.Book;
import com.jjh.spring.store.BookStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.jjh.spring.beans",
		"com.jjh.spring.store"})
public class Main {

	public static void main(String[] args) {
		System.out.print(("Main - Starting the application"));
		ApplicationContext ctx = SpringApplication.run(Main.class, args);

		BookStore store = ctx.getBean(BookStore.class);
		System.out.println("---------------------------------------");
		System.out.println("BookStore.getName(): " + store.getName());
		System.out.println("BookStore.getMessage(): " + store.getMessage());
		System.out.println("BookStore.getDate(): " + store.getDate());
		System.out.println("---------------------------------------");
		for (Book book : store.getBooks()) {
			System.out.println("Book: " + book);
		}
		System.out.println("---------------------------------------");
	}

}
