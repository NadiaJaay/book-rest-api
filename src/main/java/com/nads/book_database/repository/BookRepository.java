package com.nads.book_database.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nads.book_database.model.Book;

/**
 * Book - the entity stored by the repository
 * UUID - Type of emtity's ID
**/ 
public interface BookRepository extends JpaRepository<Book, UUID> {
    
}
