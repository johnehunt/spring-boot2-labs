package com.jjh.spring.store;

import com.jjh.spring.beans.DateService;
import com.jjh.spring.beans.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Component("BookStore")
public class BookStoreImpl implements BookStore {

	private List<Book> books;
	private MessageService messageService;

	@Autowired
	private DateService dateService;

	@Value("#{company.name}")
	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDate() {
		return this.dateService.getDate();
	}

	@Override
	public List<Book> getBooks() {
		return books;
	}

	@Value("#{BookDAO.getBooks()}")
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

	// Service bookStroe methods

	public Book getBookByTitle(String title) {
		System.out.println("Bookshop.getBook(" + title + ")");
		List<Book> books = this.books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title))
				.collect(Collectors.toList());
		if (books.size() > 0)
			return books.get(0);
		else
			return null;
	}

	public void addBook(Book book) {
		System.out.println("Bookshop.addBook(" + book + ")");
		if (!this.books.contains(book)) {
			this.books.add(book);
		}
	}

	public void updateBook(Book newVersionOfBook) {
		System.out.println("Bookshop.updateBook(" + newVersionOfBook + ")");
		Book originalBook = this.getBookByTitle(newVersionOfBook.getTitle());
		if (originalBook == null)
			throw new BookException("Book with title: " + newVersionOfBook.getTitle() + " not found");
		originalBook.setAuthor(newVersionOfBook.getAuthor());
		originalBook.setPrice(newVersionOfBook.getPrice());
	}

	public void deleteBook(String title) {
		System.out.println("Bookshop.deleteBook(" + title + ")");
		Book book = this.getBookByTitle(title);
		if (book != null)
			this.books.remove(book);
		else
			throw new BookException("Book with title: " + title + " not found");
	}

}
