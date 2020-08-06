package com.jjh.spring.store;

import java.util.List;

public interface BookStore {

	String getName();

	List<Book> getBooks();

	String getMessage();

	String getDate();

}