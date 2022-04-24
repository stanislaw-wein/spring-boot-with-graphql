package com.example.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@AllArgsConstructor
@Component
public class ArticleMutationResolver implements GraphQLMutationResolver {
    private ArticleRepository articleRepository;

    public Article addArticle(final String title, final String text, final String thumbnail) {
        log.info("Add article: {}, {}, {}", title, text, thumbnail);
        return articleRepository
                .save(Article.builder()
                             .title(title)
                             .text(text)
                             .thumbnail(thumbnail)
                             .comments(new ArrayList<>())
                             .build());
    }
}
