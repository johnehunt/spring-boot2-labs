package com.jjh.spring.store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { TestConfig.class} )
class BookStoreImplTest {

    @Autowired
    private BookStore bookstore;

    @Test
    void checkNameOfBookstore() {
        String name = bookstore.getName();
        Assertions.assertEquals("My Company", name);
    }

    @Test
    void getBooks() {
        int number = bookstore.getBooks().size();
        Assertions.assertEquals(2, number, "There should be 2 books in the bookstore");
    }

    @Test
    void getMessage() {
        String message = bookstore.getMessage();
        Assertions.assertEquals("Welcome", message);
    }

    @Test
    void getBookByTitle() {
        Book book = bookstore.getBookByTitle("Java and Spring");
        Assertions.assertNotNull(book);
        Assertions.assertEquals("123", book.getIsbn());
    }
}