package com.theabhikdatta.eshop.backend.service.impl;

import com.theabhikdatta.eshop.backend.entity.Category;
import com.theabhikdatta.eshop.backend.exception.ResourceNotFoundException;
import com.theabhikdatta.eshop.backend.repository.CategoryRepository;
import com.theabhikdatta.eshop.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", id));
        return category;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category saveCategory = categoryRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", id));
        saveCategory.setName(category.getName());
        saveCategory.setImage(category.getImage());
        return categoryRepository.save(saveCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", id));
        categoryRepository.delete(category);
    }
}
