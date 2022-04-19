package com.example.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.model.Article;
import com.example.demo.model.Comment;
import com.example.demo.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Component
public class CommentMutationResolver implements GraphQLMutationResolver {
    private ArticleRepository articleRepository;

    public Article addComment(final String articleId, final String text) {
        return articleRepository.findById(articleId)
                                .map(article -> {
                                    log.info("Adding a comment to the article {}", article.getId());
                                    Optional.ofNullable(article.getComments())
                                            .ifPresentOrElse(comments -> comments.add(new Comment(text)),
                                                    () -> article.setComments(Collections.singletonList(new Comment(text))));
                                    return articleRepository.save(article);
                                })
                                .orElseThrow(() -> {
                                    log.error("Article is not found {}", articleId);
                                    return new RuntimeException("Article is not found");
                                });
    }
}
