package com.example.demo.model;

import lombok.Data;

@Data
public class Comment {
    private String id;
    private String name;
    private String text;
    private String articleId;
}
