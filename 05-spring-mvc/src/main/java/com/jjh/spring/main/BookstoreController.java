package com.jjh.spring.main;

import com.jjh.spring.store.BookStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Controller
@RequestMapping("books")
public class BookstoreController {

	@Autowired
	private BookStore bookstore;

	public BookstoreController() {
		System.out.println("BookstoreController.<init>()");
	}
	
	public void addViewControllers(ViewControllerRegistry registry) {
		System.out.println("BookstoreController.addViewControllers()");
        registry.addViewController("/error").setViewName("error");
    }
	
	// http://localhost:8080/books/list
	
	@RequestMapping("/list")
	public ModelAndView getAllBooks() {
		System.out.println("BookstoreController.getAllBooks()");
		ModelAndView mav = new ModelAndView("books");
		mav.addObject("booklist", this.bookstore.getBooks());
		// application code
		return mav;
	}

	// http://localhost:8080/books/hello
	
	@RequestMapping("/hello")
	@ResponseBody
	String hello() {
		System.out.println("BookstoreController.hello()");
		return "<h2>Hello World!</h2>";
	}
	
}
