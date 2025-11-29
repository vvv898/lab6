package com.example.library.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer yearPublished;
    private Integer pages;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Book() {}
    public Book(String title, Integer yearPublished, Integer pages, Author author, Genre genre) {
        this.title = title; this.yearPublished = yearPublished; this.pages = pages;
        this.author = author; this.genre = genre;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public Integer getYearPublished() { return yearPublished; }
    public Integer getPages() { return pages; }
    public Author getAuthor() { return author; }
    public Genre getGenre() { return genre; }

    public void setTitle(String title) { this.title = title; }
    public void setYearPublished(Integer yearPublished) { this.yearPublished = yearPublished; }
    public void setPages(Integer pages) { this.pages = pages; }
    public void setAuthor(Author author) { this.author = author; }
    public void setGenre(Genre genre) { this.genre = genre; }
}