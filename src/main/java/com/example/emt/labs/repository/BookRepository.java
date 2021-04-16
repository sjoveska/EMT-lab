package com.example.emt.labs.repository;

import com.example.emt.labs.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findByName(String name);
}
