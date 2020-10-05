package com.jjh.spring.store;

import com.jjh.spring.beans.DateService;
import com.jjh.spring.beans.MessageService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component("BookStore")
public class BookStoreImpl implements BookStore {

	private List<Book> books;
	private MessageService messageService;

	@Autowired
	private DateService dateService;

	@Autowired
	public BookStoreImpl(BookDAO bookDAO) {
		setBooks(bookDAO.getBooks());
	}

	public String getName() {
		return "John's Bookstore";
	}

	public String getDate() {
		return this.dateService.getDate();
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getMessage() {
		return this.messageService.getMessage();
	}

	@Autowired
	public void setMessageService(MessageService service) {
		System.out.println("WelcomeServiceImpl.setMessageService(" + service + ")");
		this.messageService = service;
	}

}
