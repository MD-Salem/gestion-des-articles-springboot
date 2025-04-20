package com.gestion.articles.service;

import com.gestion.articles.entities.Article;
import com.gestion.articles.entities.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceAritcle {
    public Article createArticle(Article article);
    public Page<Article> findAllArticles(Pageable pageable);
    Page<Article> findFavoriteArticles(Pageable pageable);
    Page<Article> findFavoriteArticlesByTitle(String title, Pageable pageable);
    public Boolean articleExist(int id);
    public Article findById(int id);
    public Page<Article> findByTitle(String title, Pageable pageable);
    public Page<Article> findByAuthor(Author author, Pageable pageable);
    public Page<Article> findByTitleAndAuthor(String title, Author author, Pageable pageable);
    public Page<Article> findByCategory(String category, Pageable pageable);
    public Article updateArticle(Article article);
    public void deleteArticle(int id);
}
