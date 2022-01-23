package com.example.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.model.Article;
import com.example.demo.model.Comment;
import com.example.demo.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CommentMutationResolver implements GraphQLMutationResolver {
    private ArticleRepository articleRepository;

    public Article addComment(final String articleId, final String text) {
        return articleRepository.findById(articleId)
                .map(article -> {
                    article.getComments().add(new Comment(text));
                    return articleRepository.save(article);
                })
                .orElseThrow();
    }
}
