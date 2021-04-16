package com.example.emt.labs.service;

import com.example.emt.labs.model.Book;
import com.example.emt.labs.model.dto.BookDto;
import com.example.emt.labs.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByName(String name);

    Optional<Book> save(String name, Category category, Long author, Integer availableCopies);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, String name, Category category,Long author, Integer availableCopies);

    Optional<Book> edit(Long id, BookDto bookDto);
   void decreaseAvailableCopies(Long id);

    void deleteById(Long id);
}
