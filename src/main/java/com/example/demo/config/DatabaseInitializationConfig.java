package com.example.demo.config;

import com.example.demo.model.Article;
import com.example.demo.model.Comment;
import com.example.demo.repository.ArticleRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.stream.IntStream;

@Profile("docker")
@AllArgsConstructor
@Slf4j
@Component
public class DatabaseInitializationConfig {
    private final Faker faker = new Faker();
    private final ArticleRepository articleRepository;

    @PostConstruct
    public void initDatabase() {
        log.info("Starting database initialization");
        IntStream.range(1, 10).forEach(i -> articleRepository.save(buildArticle()));
    }

    private Article buildArticle() {
        return Article.builder()
                .title(faker.book().title())
                .text(faker.chuckNorris().fact())
                .comments(Collections.singletonList(new Comment(faker.cat().name())))
                .build();
    }
}
