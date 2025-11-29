package com.example.library.repository;

import com.example.library.model.Reader;
import org.springframework.data.repository.CrudRepository;

public interface ReaderRepository extends CrudRepository<Reader, Long> {
    // Всі базові CRUD методи успадковані автоматично
}