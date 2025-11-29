package com.example.library.repository;

import com.example.library.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    // Всі базові CRUD методи успадковані автоматично
}