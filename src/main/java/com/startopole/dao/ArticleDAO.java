package com.startopole.dao;

import com.startopole.model.Article;

import java.util.List;

public interface ArticleDAO {

    public void add(Article news);
    public void edit(Article news);
    public void delete(int articleId);
    public Article getArticle(int articleId);
    public List getAllArticle();
}
