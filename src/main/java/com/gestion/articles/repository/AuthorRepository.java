package com.gestion.articles.repository;

import com.gestion.articles.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findByNameContainingIgnoreCase(String name);
}
