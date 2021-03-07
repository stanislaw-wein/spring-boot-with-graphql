package com.example.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.model.Article;
import com.example.demo.model.Comment;

public class CommentResolver implements GraphQLResolver<Comment> {

    public Article getArticle() {
        return null;
    }
}
