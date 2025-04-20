package com.gestion.articles.service;

import com.gestion.articles.entities.Article;
import com.gestion.articles.entities.Author;
import com.gestion.articles.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceArticle implements IServiceAritcle{

    private final ArticleRepository articleRepository;

    public ServiceArticle(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Page<Article> findAllArticles(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }


    @Override
    public Page<Article> findFavoriteArticles(Pageable pageable) {
        return articleRepository.findAllByIsFavoriteIsTrue(pageable);
    }

    @Override
    public Page<Article> findFavoriteArticlesByTitle(String title, Pageable pageable) {
        return articleRepository.findByIsFavoriteTrueAndTitleContainingIgnoreCase(title, pageable);
    }

    @Override
    public Boolean articleExist(int id) {
        return articleRepository.existsById(id);
    }

    @Override
    public Article findById(int id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public Page<Article> findByTitle(String title, Pageable pageable) {
        return articleRepository.findByTitleContainingIgnoreCase(title, pageable);
    }

    @Override
    public Page<Article> findByAuthor(Author author, Pageable pageable) {
        return articleRepository.findByAuthor(author, pageable);
    }

    @Override
    public Page<Article> findByTitleAndAuthor(String title, Author author, Pageable pageable) {
        return articleRepository.findByAuthorAndTitleContainingIgnoreCase(author, title, pageable);
    }

    @Override
    public Page<Article> findByCategory(String category, Pageable pageable) {
        return articleRepository.findByCategory(category, pageable);
    }

    @Override
    public Article updateArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }
}
