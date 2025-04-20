package com.gestion.articles.controller;

import com.gestion.articles.entities.Article;
import com.gestion.articles.entities.Author;
import com.gestion.articles.exception.ArticleNotFoundException;
import com.gestion.articles.repository.ArticleRepository;
import com.gestion.articles.service.IServiceAritcle;
import com.gestion.articles.service.IServiceAuthor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/article")
public class AritcleController {

    private final IServiceAritcle serviceAritcle;
    private final IServiceAuthor serviceAuthor;

    public AritcleController(IServiceAritcle serviceAritcle, IServiceAuthor serviceAuthor) {
        this.serviceAritcle = serviceAritcle;
        this.serviceAuthor = serviceAuthor;
    }

    @GetMapping("")
    public ResponseEntity<Page<Article>> getArticles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String direction
    ) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(serviceAritcle.findAllArticles(pageable), HttpStatus.OK);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Page<Article>> getArticlesByAuthor(@PathVariable int id,
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "5") int size,
             @RequestParam(defaultValue = "createdAt") String sortBy,
             @RequestParam(defaultValue = "desc") String direction)
    {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Author author = serviceAuthor.findAuthorById(id);
        return new ResponseEntity<>(serviceAritcle.findByAuthor(author,pageable), HttpStatus.OK);
    }

    @PostMapping("/author/{id}")
    public ResponseEntity<Page<Article>> searchArticlesByAuthor(@PathVariable int id,
             @RequestParam String title,
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "5") int size,
             @RequestParam(defaultValue = "createdAt") String sortBy,
             @RequestParam(defaultValue = "desc") String direction)
    {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Author author = serviceAuthor.findAuthorById(id);
        return new ResponseEntity<>(serviceAritcle.findByTitleAndAuthor(title,author,pageable), HttpStatus.OK);
    }

    @GetMapping("/favorites")
    public ResponseEntity<Page<Article>> getFavorites(
            @RequestParam(required = false) String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Article> favorites;

        if (title != null && !title.isBlank()) {
            favorites = serviceAritcle.findFavoriteArticlesByTitle(title, pageable);
        } else {
            favorites = serviceAritcle.findFavoriteArticles(pageable);
        }

        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable int id) {
        if (!serviceAritcle.articleExist(id)) throw new ArticleNotFoundException("Article with id " + id + " not found");
        return new ResponseEntity<>(serviceAritcle.findById(id), HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Article>> searchArticles(
            @RequestParam String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(serviceAritcle.findByTitle(title, pageable), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        if(article.getCategory() == null || article.getCategory().equals("")){
            article.setCategory("Sans category");
        }
        article.setCreatedAt(LocalDateTime.now());
        return new ResponseEntity<>(serviceAritcle.createArticle(article), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        if (!serviceAritcle.articleExist(article.getId())) throw new ArticleNotFoundException("Article with id " + article.getId() + " not found");
        return new ResponseEntity<>(serviceAritcle.updateArticle(article), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Article> favoreisArticle(@PathVariable int id){
        if (!serviceAritcle.articleExist(id)) throw new ArticleNotFoundException("Article with id " + id + " not found");
        Article article = serviceAritcle.findById(id);
        article.setIsFavorite(!article.getIsFavorite());
        return new ResponseEntity<>(serviceAritcle.updateArticle(article), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable int id) {
        if (!serviceAritcle.articleExist(id)) throw new ArticleNotFoundException("Article with id " + id + " not found");
        serviceAritcle.deleteArticle(id);
        return new ResponseEntity<>("Deleted Article successfully", HttpStatus.OK);
    }


}
