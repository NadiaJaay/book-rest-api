package com.nads.book_database.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nads.book_database.model.Book;
import com.nads.book_database.service.BookService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Book>> getAllBooks() {
       List<Book> books =  bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}") // ResponseEntity allows us to control the HTTP status and response body.
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable("id") UUID id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(book);
    }
    
    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {        
        bookService.addBook(book);

        return ResponseEntity.status(HttpStatus.CREATED).body(book); //returns 201 created

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") UUID id, @Valid @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        
        if (updatedBook == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    //ResponseEntity<Void> means the response has a status code but no body.
    public ResponseEntity<Void> deleteBook(@PathVariable("id") UUID id) {
        boolean deleted = bookService.deleteBook(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
    
    
}
