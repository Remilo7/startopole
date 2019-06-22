package com.startopole.services.impl;

import com.startopole.dao.CategoryDAO;
import com.startopole.model.entity.Category;
import com.startopole.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    @Transactional
    public void add(Category category) {
        categoryDAO.add(category);
    }

    @Transactional
    public void edit(Category category) {
        categoryDAO.edit(category);
    }

    @Transactional
    public void delete(int categoryId) {
        categoryDAO.delete(categoryId);
    }

    @Transactional
    public Category getCategory(int categoryId) {
        return categoryDAO.getCategory(categoryId);
    }

    @Transactional
    public List getAllCategories() {
        return categoryDAO.getAllCategories();
    }
}
