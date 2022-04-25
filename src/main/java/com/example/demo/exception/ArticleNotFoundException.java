package com.example.demo.exception;

public class ArticleNotFoundException extends RuntimeException {

    private final String articleId;

    public ArticleNotFoundException(String message, String articleId) {
        super(message);
        this.articleId = articleId;
    }
}