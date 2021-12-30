package com.javaexpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.model.Book;
import com.javaexpress.respository.BookRepository;

// Business logic i.e contributing DB
@Service
public class BookService {

	
	@Autowired
	private BookRepository bookRepository;
	
	public Book saveBook(Book book) {
		  return bookRepository.save(book);
		
	}
	
	public List<Book> getAllBook() {
	return	bookRepository.findAll();
	}
	
	public Book getByBookId(int id) {
		Optional<Book>optional= bookRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
					
		}
		return null;
	}
	
	public Object updateBook( int bookId,Book book) throws Exception {
	Book dbbook=getByBookId(bookId);
	if(dbbook!=null) {
		dbbook.setName(book.getName());
	dbbook.setAuthorName(book.getAuthorName());
	  bookRepository.save(dbbook);

	}else {
		throw new Exception("id is not existing in db");
	}
	return dbbook;
	}
	
	public void deleteBook(int bookId) {
		Book dbbook=getByBookId(bookId);
		if(dbbook!=null) {
			bookRepository.delete(dbbook);
			}
		}
}
