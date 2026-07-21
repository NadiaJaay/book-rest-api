package com.nads.book_database.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.nads.book_database.model.Book;
import com.nads.book_database.repository.BookRepository;

@Service
public class BookService {
    //private final List<Book> books = new ArrayList<>();
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Create
    public Book addBook(Book bookToAdd) {
        //books.add(bookToAdd);
        return bookRepository.save(bookToAdd);
    }

    //Read
    public List<Book> getAllBooks() {
        //return books;
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById (UUID id) {
        // for (Book book : books) {
        //     if (book.getId().equals(id)) {
        //         return book;
        //     }
        // }

        return bookRepository.findById(id);
    }

    //Update
    public Book updateBook(UUID id, Book book) {
        // Book updatedBook = getBookById(id);
        // if (updatedBook == null) {
        //     return null;
        // }

        // updatedBook.setAuthor(book.getAuthor());
        // updatedBook.setGenre(book.getGenre());
        // updatedBook.setTitle(book.getTitle());
        // updatedBook.setPublishYear(book.getPublishYear());

        // return updatedBook;

        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook == null) {
            return null;
        }

        existingBook.setAuthor(book.getAuthor());
        existingBook.setGenre(book.getGenre());
        existingBook.setTitle(book.getTitle());
        existingBook.setPublishYear(book.getPublishYear());

        return bookRepository.save(existingBook);
    }

    //Delete
    public Boolean deleteBook(UUID id) {
        // Book deleteBook = getBookById(id);
        // if (deleteBook == null) {
        //     return false;
        // }

        // books.remove(deleteBook);
        // return true;
        if (!bookRepository.existsById(id)) {
            return false;
        }

        bookRepository.deleteById(id);
        return true;

    }
}
