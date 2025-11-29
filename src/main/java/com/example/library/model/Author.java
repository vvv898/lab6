package com.example.library.model;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;

    public Author() {}
    public Author(String name, String country) { this.name = name; this.country = country; }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCountry() { return country; }

    public void setName(String name) { this.name = name; }
    public void setCountry(String country) { this.country = country; }
}
