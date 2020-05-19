package com.jjh.spring.bookstore;

public class Book {
    private String isbn;
    private String title;
    private String category;
    private String author;

    public Book() {}

    public Book(String isbn, String title, String category, String author) {
        this.isbn = isbn;
        this.title = title;
        this.category = category;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String id) {
        this.isbn = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

