package com.javaexpress.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
