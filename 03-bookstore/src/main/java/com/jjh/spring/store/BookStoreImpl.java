package com.jjh.spring.store;

import com.jjh.spring.beans.DateService;
import com.jjh.spring.beans.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component("BookStore")
public class BookStoreImpl implements BookStore {

	private List<Book> books;
	private MessageService messageService;

	@Autowired
	private DateService dateService;

	public BookStoreImpl(@Autowired BookDAO bookDAO) {
		setBooks(bookDAO.getBooks());
	}

	@Override
	public String getName() {
		return "John's Bookstore";
	}

	@Override
	public String getDate() {
		return this.dateService.getDate();
	}

	@Override
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
