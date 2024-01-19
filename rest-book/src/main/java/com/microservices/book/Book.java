package com.microservices.book;


import io.smallrye.common.constraint.NotNull;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Book {

    public String title;
    public String author;
    @JsonbProperty("year_of_publication")
    public int yearOfPublication;
    public String genre;
    @JsonbDateFormat("yyyy-MM-dd")
    @JsonbProperty("creation_date")
    public LocalDate creationDate;

    @JsonbProperty("isbn_13")
    @NotNull
    public String isbn13;

    public Book(String title, String author, int yearOfPublication, String genre, LocalDate creationDate, String isbn13) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.genre = genre;
        this.creationDate = creationDate;
        this.isbn13 = isbn13;
    }

    public Book(){}

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", genre='" + genre + '\'' +
                ", creationDate=" + creationDate +
                ", isbn13='" + isbn13 + '\'' +
                '}';
    }
}
