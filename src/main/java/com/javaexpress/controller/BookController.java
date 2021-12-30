package com.javaexpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.model.Book;
import com.javaexpress.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping(value = "/api/v1/book/create", produces = { "application/json" }, consumes = { "application/json" })
	public void saveBook(@RequestBody Book book) {
		bookService.saveBook(book);
	}

	@GetMapping("/api/v1/book/getAllBooks")
	public List<Book> getAllBook() {
		return bookService.getAllBook();
	}

	// input is primary key -output is object
	// pathvariable-mandentory to provide

	@GetMapping("/api/v1/book/{bookId}")
	public Book getByBookId(@PathVariable("bookId") int id) {
		return bookService.getByBookId(id);
	}

	@PutMapping("/api/v1/book/{bookId}")
	public Book updateBook(@PathVariable("bookId") int id, @RequestBody Book book) throws Exception {
		return (Book) bookService.updateBook(id, book);
	}

	@DeleteMapping("/api/v1/book/{bookId}")
	public void deleleBook(@PathVariable("bookId") int id) {
		bookService.deleteBook(id);

	}

}
