package com.jjh.spring.repo;

import com.jjh.spring.store.BookImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookImpl, Integer> {}