package com.jjh.spring.store;

import com.jjh.spring.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("BookDAO")
public class BookDAO {

    @Autowired
    private BookRepository repository;

    public List<Book> getBooks() {
        System.out.println("BookDAO.getBooks()");
        Iterable<BookImpl> iterable = repository.findAll();
        List<Book> books = new ArrayList<Book>();
        for (Book b : iterable) {
            books.add(b);
        }
        return books;
    }

    public void saveBook(Book book) {
        System.out.println("BookDAO.saveBook(" + book + ")");
        repository.save((BookImpl)book);
    }

    public void deleteBook(Book book) {
        System.out.println("BookDAO.deleteBook(" + book + ")");
        repository.delete((BookImpl)book);
    }

    public Optional<Book> getBookByISBN(int isbn) {
        System.out.println("BookDAO.getBookByISBN(" + isbn + ")");
        BookImpl bookImpl = repository.findById(isbn).get();
        return Optional.of((Book)bookImpl);
    }

}
