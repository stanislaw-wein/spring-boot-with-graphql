package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
public class Article {
    @Id
    private String id;
    private String title;
    private String text;
    private String thumbnail;
    private List<Comment> comments;

}
