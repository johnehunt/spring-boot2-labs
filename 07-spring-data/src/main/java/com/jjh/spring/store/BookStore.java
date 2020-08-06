package com.jjh.spring.store;

import java.util.List;

public interface BookStore {

    String getName();

    List<Book> getBooks();

    String getMessage();

    String getDate();

    Book getBookByTitle(String title);

    void addBook(Book book);

    void updateBook(Book newVersionOfBook);

    void deleteBook(String title);

}