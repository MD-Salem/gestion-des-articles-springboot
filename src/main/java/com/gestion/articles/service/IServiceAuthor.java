package com.gestion.articles.service;

import com.gestion.articles.entities.Author;

import java.util.List;

public interface IServiceAuthor {
    public Author createAuthor(Author author);
    public Boolean authorExist(int id);
    public Author findAuthorById(int id);
    public List<Author> findAuthorByName(String name);
    public List<Author> findAllAuthors();
    public Author updateAuthor(Author author);
    public void deleteAuthor(int id);
}
