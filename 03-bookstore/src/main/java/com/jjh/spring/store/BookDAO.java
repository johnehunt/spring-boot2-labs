package com.jjh.spring.store;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("BookDAO")
public class BookDAO {

    private final List<Book> books = new ArrayList<Book>();

    public BookDAO() {
        Book b1 = new BookImpl("123", "Java and Spring", "John Smith", "Tech Books", 12.99);
        Book b2 = new BookImpl("124", "Java for Professionals", "Adam Young", "Tech Books", 15.95);
        books.add(b1);
        books.add(b2);
    }

    public List<Book> getBooks() {
        return books;
    }

}
