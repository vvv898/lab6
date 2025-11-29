package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    // Явно перевизначаємо findAll для повернення List, як вимагає завдання
    @Override 
    List<Book> findAll(); 
    
    // Приклад кастомного методу: знайти книги за назвою, що містить певний рядок
    List<Book> findByTitleContaining(String title);
}