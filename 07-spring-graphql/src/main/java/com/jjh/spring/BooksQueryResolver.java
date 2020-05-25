package com.jjh.spring;

import graphql.kickstart.tools.GraphQLQueryResolver;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BooksQueryResolver implements GraphQLQueryResolver {
    private Bookshop bookshop = new Bookshop();

    public List<Book> getBooks(int count) {
        System.out.println("Query.getBooks(" + count + ")");
        return bookshop.getBooks(count);
    }
}
