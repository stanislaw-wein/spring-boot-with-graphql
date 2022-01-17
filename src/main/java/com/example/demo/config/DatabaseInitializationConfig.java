package com.example.demo.config;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
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

    private final ArticleRepository articleRepository;

    @PostConstruct
    public void initDatabase() {
        log.info("Starting database initialization");
        IntStream.range(1, 10).forEach(i -> articleRepository.save(buildArticle("The Article Number: " + i)));
    }

    private static Article buildArticle(final String title) {
        return Article.builder()
                .title(title)
                .text("Text")
                .comments(Collections.emptyList())
                .build();
    }
}
