package com.example.demo.config;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Collections;
import java.util.stream.IntStream;

@Profile("docker")
@Configuration
@AllArgsConstructor
@Slf4j
public class DatabaseInitializationConfig {

    private final ArticleRepository articleRepository;

    @Bean
    public InitializingBean initDatabase() {
        log.info("Starting database initialization");
        final IntStream stream = IntStream.range(1, 10);
        return () -> stream.forEach(i -> articleRepository.save(buildArticle("The Article Number: " + i)));
    }

    private static Article buildArticle(final String title) {
        return Article.builder()
                .title(title)
                .comments(Collections.emptyList())
                .build();
    }
}
