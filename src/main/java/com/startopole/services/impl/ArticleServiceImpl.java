package com.startopole.services.impl;

import com.startopole.dao.ArticleDAO;
import com.startopole.model.Article;
import com.startopole.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDAO articleDAO;

    @Transactional
    public void add(Article news) {
        articleDAO.add(news);
    }

    @Transactional
    public void edit(Article news) {
        articleDAO.edit(news);
    }

    @Transactional
    public void delete(int articleId) {
        articleDAO.delete(articleId);
    }

    @Transactional
    public Article getArticle(int articleId) {
        return articleDAO.getArticle(articleId);
    }

    @Transactional
    public List getAllArticle() {
        return articleDAO.getAllArticle();
    }
}
