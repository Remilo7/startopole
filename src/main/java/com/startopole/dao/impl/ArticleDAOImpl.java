package com.startopole.dao.impl;

import com.startopole.dao.ArticleDAO;
import com.startopole.model.Article;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

    @Autowired
    private SessionFactory session;

    public void add(Article news){
        session.getCurrentSession().save(news);
    }

    public void edit(Article news) {
        session.getCurrentSession().update(news);
    }

    public void delete(int articleId) {
        session.getCurrentSession().delete(getArticle(articleId));
    }

    public Article getArticle(int articleId) {
        return (Article)session.getCurrentSession().get(Article.class, articleId);
    }

    public List getAllArticle() {
        return session.getCurrentSession().createQuery("FROM Article ").list();
    }
}
