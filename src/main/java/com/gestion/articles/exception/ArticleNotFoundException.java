package com.gestion.articles.exception;

public class ArticleNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public ArticleNotFoundException(String message) {
        super(message);
    }
}
