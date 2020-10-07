package com.jjh.spring.controllers;

import com.jjh.spring.store.Book;
import com.jjh.spring.store.BookException;
import com.jjh.spring.store.BookImpl;
import com.jjh.spring.store.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookstoreController {

    @Autowired
    private BookStore bookstore;

    public BookstoreController() {
        System.out.println("BookstoreController.<init>()");
    }

    @GetMapping("{title}")
    public Book getBook(@PathVariable String title) {
        System.out.println("BookshopController.getBook(" + title + ")");
        return this.bookstore.getBookByTitle(title);
    }

    @GetMapping("list")
    public List<Book> getAllBooks() {
        System.out.println("BookshopController.getAllBooks()");
        return bookstore.getBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addBook(@RequestBody BookImpl book) {
        System.out.println("BookshopController.addBook(" + book + ")");
        this.bookstore.addBook(book);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@RequestBody BookImpl book) {
        System.out.println("BookshopController.updateBook(" + book + ")");
        this.bookstore.updateBook(book);
    }

    @DeleteMapping("{title}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable String title) {
        System.out.println("BookshopController.deleteBook(" + title + ")");
        bookstore.deleteBook(title);
    }

    @ExceptionHandler(BookException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book not found")
    public void updateFailure() {
    }

}
