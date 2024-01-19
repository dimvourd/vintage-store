package com.microservices.number;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;

import java.time.Instant;

public class IsbnNumbers {
    @JsonbProperty("isbn_13")
    public String isbn13;
    @JsonbProperty("isbn_10")
    public String isbn10;
    @JsonbTransient
    public Instant generationDate;

    public IsbnNumbers(String isbn13, String isbn10, Instant generationDate) {
        this.isbn13 = isbn13;
        this.isbn10 = isbn10;
        this.generationDate = generationDate;
    }

    @Override
    public String toString() {
        return "IsbnNumbers{" +
                "isbn13='" + isbn13 + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", generationDate=" + generationDate +
                '}';
    }
}
