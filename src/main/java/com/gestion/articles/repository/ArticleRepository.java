package com.gestion.articles.repository;

import com.gestion.articles.entities.Article;
import com.gestion.articles.entities.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Page<Article> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    Page<Article> findByAuthor(Author author, Pageable pageable);
    Page<Article> findByAuthorAndTitleContainingIgnoreCase(Author author, String title, Pageable pageable);
    Page<Article> findAllByIsFavoriteIsTrue(Pageable pageable);

    Page<Article> findByCategory(String category, Pageable pageable);
    Page<Article> findByIsFavoriteTrueAndTitleContainingIgnoreCase(String title, Pageable pageable);

}
