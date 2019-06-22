package com.startopole.services;

import com.startopole.model.entity.Category;

import java.util.List;

public interface CategoryService {

    public void add(Category category);
    public void edit(Category category);
    public void delete(int categoryId);
    public Category getCategory(int categoryId);
    public List getAllCategories();
}
