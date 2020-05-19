package com.jjh.spring.main;

import com.jjh.spring.store.Book;
import com.jjh.spring.store.BookException;
import com.jjh.spring.store.BookStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("BookStore")
public class BookshopController {
    @Autowired
    private BookStore bookshop;

    @GetMapping("{title}")
    public Book getBook(@PathVariable String title) {
        System.out.println("BookshopController.getBook(" + title + ")");
        return this.bookshop.getBookByTitle(title);
    }

    @GetMapping("list")
    public List<Book> getAllBooks() {
        System.out.println("BookshopController.getAllBooks()");
        return bookshop.getBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addBook(@RequestBody Book book) {
        System.out.println("BookshopController.addBook(" + book + ")");
        this.bookshop.addBook(book);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@RequestBody Book book) {
        System.out.println("BookshopController.updateBook(" + book + ")");
        this.bookshop.updateBook(book);
    }

    @DeleteMapping("{title}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable String title) {
        System.out.println("BookshopController.deleteBook(" + title + ")");
        bookshop.deleteBook(title);
    }

    @ExceptionHandler(BookException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book not found")
    public void updateFailure() {
    }

}
