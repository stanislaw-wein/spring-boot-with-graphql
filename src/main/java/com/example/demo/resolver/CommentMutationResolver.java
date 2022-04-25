package com.example.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.exception.ArticleNotFoundException;
import com.example.demo.model.Article;
import com.example.demo.model.Comment;
import com.example.demo.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Component
public class CommentMutationResolver implements GraphQLMutationResolver {
    private ArticleRepository articleRepository;

    public Article addComment(String id, String text) {
        return articleRepository.findById(id)
                                .map(article -> addComment(article, text))
                                .orElseThrow(() -> new ArticleNotFoundException("Article is not found", id));
    }

    private Article addComment(Article article, String text) {
        Optional.ofNullable(article.getComments())
                .ifPresentOrElse(comments -> comments.add(new Comment(text)), () -> article.setComments(List.of(new Comment(text))));
        return articleRepository.save(article);
    }

}
