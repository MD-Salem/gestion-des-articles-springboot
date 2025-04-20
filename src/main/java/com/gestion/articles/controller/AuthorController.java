package com.gestion.articles.controller;

import com.gestion.articles.entities.Author;
import com.gestion.articles.exception.AuthorNotFoundException;
import com.gestion.articles.service.IServiceAuthor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final IServiceAuthor serviceAuthor;

    public AuthorController(IServiceAuthor serviceAuthor) {
        this.serviceAuthor = serviceAuthor;
    }

    @GetMapping("")
    public ResponseEntity<List<Author>> getAuthors() {
        return new ResponseEntity<>(serviceAuthor.findAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Integer id) {
        if (!serviceAuthor.authorExist(id)) throw new AuthorNotFoundException("Author with id " + id + " not found");
        return new ResponseEntity<>(serviceAuthor.findAuthorById(id), HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Author>> searchAuthor(@RequestParam String name) {
        return new ResponseEntity<>(serviceAuthor.findAuthorByName(name), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        return new ResponseEntity<>(serviceAuthor.createAuthor(author), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
        if (!serviceAuthor.authorExist(author.getId())) throw new AuthorNotFoundException("Author with id " + author.getId() + " not found");
        return new ResponseEntity<>(serviceAuthor.updateAuthor(author), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Integer id) {
        if (!serviceAuthor.authorExist(id)) throw new AuthorNotFoundException("Author with id " + id + " not found");
        serviceAuthor.deleteAuthor(id);
        return new ResponseEntity<>("Deleted author successfully", HttpStatus.OK);
    }
}
