package com.nads.book_database.model;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Book {
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Author cannot be blank")
    private String author;
    @Min(value = 1900, message = "Publish year must be equal to or greater than 1900")
    private int publishYear;
    @NotBlank(message = "Genre cannot be blank")
    private String genre;
    private UUID id;


    public Book() {
    }

    public Book(String title, String author, int publishYear, String genre) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.genre = genre;
        this.id = UUID.randomUUID();
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return this.publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}

    