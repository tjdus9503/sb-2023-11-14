package com.ll.sb20231114.domain.article.article.repository;

import com.ll.sb20231114.domain.article.article.entity.Article;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleRepository {
    private final List<Article> articles = new ArrayList<>();

    public Article save(Article article) {
        if (article.getId() == null) {
            article.setId(articles.size() + 1L);
        }

        articles.add(article);

        return article;
    }

    public Article findLastArticle() {
        return articles.getLast();
    }

    public List<Article> findAll() {
        return articles;
    }
}