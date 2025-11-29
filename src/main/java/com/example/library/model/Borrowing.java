package com.example.library.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "borrowing")
public class Borrowing {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Reader reader;

    @ManyToOne
    private Book book;

    private LocalDate borrowDate;

    public Borrowing() {}
    public Borrowing(Reader reader, Book book, LocalDate borrowDate) {
        this.reader = reader; this.book = book; this.borrowDate = borrowDate;
    }

    public Long getId() { return id; }
    public Reader getReader() { return reader; }
    public Book getBook() { return book; }
    public LocalDate getBorrowDate() { return borrowDate; }
}