package com.example.library.repository;

import com.example.library.model.Borrowing;
import org.springframework.data.repository.CrudRepository;

public interface BorrowingRepository extends CrudRepository<Borrowing, Long> {
    // Всі базові CRUD методи успадковані автоматично
}