package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Comment {
    @Id
    private String id;
    private String name;
    private String text;
    private String articleId;
}
