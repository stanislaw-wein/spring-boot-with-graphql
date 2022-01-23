package com.example.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ArticleMutationResolver implements GraphQLMutationResolver {
    private ArticleRepository articleRepository;

    public Article addArticle(final String title, final String text, final String thumbnail) {
        return articleRepository.save(Article.builder()
                .title(title)
                .text(text)
                .thumbnail(thumbnail)
                .build());
    }
}
