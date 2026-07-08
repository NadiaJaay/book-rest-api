package com.nads.book_database.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nads.book_database.model.Book;
import com.nads.book_database.service.BookService;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController (BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") UUID id) {
        return bookService.getBookById(id);
    }
    
    @PostMapping
    public void addBook(@RequestBody Book bookToAdd) {        
        bookService.addBook(bookToAdd);
    }
    
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") UUID id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") UUID id) {
        bookService.deleteBook(id);
    }
    
    
}
