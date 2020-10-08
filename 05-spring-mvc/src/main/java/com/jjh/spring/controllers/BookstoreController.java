package com.jjh.spring.controllers;

import com.jjh.spring.store.BookStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Controller
@RequestMapping("books")
public class BookstoreController {

	private BookStore bookstore;

	@Autowired
	public BookstoreController(BookStore bookstore) {
		this.bookstore = bookstore;
	}

	public BookstoreController() {
		System.out.println("BookstoreController.<init>()");
	}
	
	public void addViewControllers(ViewControllerRegistry registry) {
		System.out.println("BookstoreController.addViewControllers()");
        registry.addViewController("/error").setViewName("error");
    }
	
	// http://localhost:8080/books/list
	
	@RequestMapping("/list")
	public String getAllBooks(Model model) {
		System.out.println("BookstoreController.getAllBooks()");
		model.addAttribute("booklist", bookstore.getBooks());
		// application code
		return "books";
	}

	// http://localhost:8080/books/hello
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		System.out.println("BookstoreController.hello()");
		return "<h2>Hello World!</h2>";
	}
	
}
