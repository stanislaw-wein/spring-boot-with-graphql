package com.example.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.model.Article;
import com.example.demo.model.Comment;
import com.example.demo.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class CommentQueryResolver implements GraphQLQueryResolver {
    private ArticleRepository articleRepository;

    public Optional<List<Comment>> getArticleComments(final String articleId) {
        return articleRepository
                .findById(articleId)
                .map(Article::getComments);
    }

    public Article addComment(final String articleId, final String text) {
        return articleRepository.findById(articleId)
                .map(article -> {
                    article.getComments().add(new Comment(text));
                    return articleRepository.save(article);
                })
                .orElseThrow();
    }
}
