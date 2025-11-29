package com.example.library.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reader")
public class Reader {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String phone;

    public Reader() {}
    public Reader(String fullName, String phone) { this.fullName = fullName; this.phone = phone; }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getPhone() { return phone; }

    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setPhone(String phone) { this.phone = phone; }
}