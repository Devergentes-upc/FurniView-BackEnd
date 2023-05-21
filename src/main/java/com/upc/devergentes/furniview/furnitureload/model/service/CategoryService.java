package com.upc.devergentes.furniview.furnitureload.model.service;

import com.upc.devergentes.furniview.furnitureload.model.domain.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    Category getCategoryById(Long id);

    List<Category> getAllCategories();

    Category updateCategory(Category category);

    void deleteCategory(Long id);
}
