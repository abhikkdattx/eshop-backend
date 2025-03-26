package com.theabhikdatta.eshop.backend.service;

import com.theabhikdatta.eshop.backend.entity.Category;

import java.util.List;

public interface CategoryService {

    // get all categories
    List<Category> getAllCategories();

    //get category by id
    Category getCategoryById(Long id);

    //save category
    Category saveCategory(Category category);

    //update category
    Category updateCategory(Long id, Category category);

    //delete category
    void deleteCategory(Long id);

}
