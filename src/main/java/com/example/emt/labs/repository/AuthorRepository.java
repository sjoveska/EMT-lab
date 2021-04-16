package com.example.emt.labs.repository;

import com.example.emt.labs.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
