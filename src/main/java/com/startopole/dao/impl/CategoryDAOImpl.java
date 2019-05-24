package com.startopole.dao.impl;

import com.startopole.dao.CategoryDAO;
import com.startopole.model.entity.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory session;

    public void add(Category category) {
        session.getCurrentSession().save(category);
    }

    public void edit(Category category) {
        session.getCurrentSession().update(category);
    }

    public void delete(int categoryId) {
        session.getCurrentSession().delete(getCategory(categoryId));
    }

    public Category getCategory(int categoryId) {
        return (Category) session.getCurrentSession().get(Category.class, categoryId);
    }

    public List getAllCategories() {
        return session.getCurrentSession().createQuery("FROM Category").list();
    }
}
