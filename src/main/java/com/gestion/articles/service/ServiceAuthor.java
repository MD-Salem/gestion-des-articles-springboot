package com.gestion.articles.service;

import com.gestion.articles.entities.Author;
import com.gestion.articles.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAuthor implements IServiceAuthor {

    private final AuthorRepository authorRepository;

    public ServiceAuthor(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Boolean authorExist(int id) {
        return authorRepository.existsById(id);
    }

    @Override
    public Author findAuthorById(int id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public List<Author> findAuthorByName(String name) {
        return authorRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }
}
