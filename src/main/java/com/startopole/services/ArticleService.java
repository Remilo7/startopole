package com.startopole.services;

import com.startopole.model.entity.Article;

import java.util.List;

public interface ArticleService {

    public void add(Article news);
    public void edit(Article news);
    public void delete(int articleId);
    public Article getArticle(int articleId);
    public List getAllArticle();
}
