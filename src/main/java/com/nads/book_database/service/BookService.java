package com.nads.book_database.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.nads.book_database.model.Book;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    //Create
    public void addBook(Book bookToAdd) {
        books.add(bookToAdd);
    }

    //Read
    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById (UUID id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }

        return null;
    }

    //Update
    public Book updateBook(UUID id, Book book) {
        Book updatedBook = getBookById(id);
        if (updatedBook == null) {
            return null;
        }

        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setGenre(book.getGenre());
        updatedBook.setTitle(book.getTitle());
        updatedBook.setPublishYear(book.getPublishYear());

        return updatedBook;
    }

    //Delete
    public void deleteBook(UUID id) {
        Book deleteBook = getBookById(id);
        books.remove(deleteBook);

    }
}
