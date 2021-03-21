package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(produces = MediaType.ALL_VALUE, consumes = MediaType.ALL_VALUE)
public class ArticleController {
    private final ArticleRepository articleRepository;

    @GetMapping(value = "/now")
    public String getCurrentTime() {
        log.info("Get current time request");
        return LocalTime.now().toString();
    }

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAllArticles() {
        log.info("Get all articles request");
        return ResponseEntity.ok(articleRepository.findAll());
    }

    @PostMapping("/graphql/test")
    public ResponseEntity<Object> test(@RequestBody String query) {
        log.info("graphql test");
        return new ResponseEntity<>(articleRepository.findAll(), HttpStatus.OK);
    }
}
