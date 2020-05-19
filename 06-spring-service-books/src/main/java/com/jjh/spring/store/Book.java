package com.jjh.spring.store;

public interface Book {
	String getTitle();

	String getAuthor();

	double getPrice();

	String getPublisher();

	String getIsbn();

	void setAuthor(String author);

	void setPrice(double price);

}
