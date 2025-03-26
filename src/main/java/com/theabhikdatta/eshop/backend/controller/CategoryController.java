package com.theabhikdatta.eshop.backend.controller;

import com.theabhikdatta.eshop.backend.entity.Category;
import com.theabhikdatta.eshop.backend.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/categories")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        var data = categoryService.getAllCategories();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id){
        var data = categoryService.getCategoryById(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@Valid @RequestBody Category category){
        var data = categoryService.saveCategory(category);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @Valid @RequestBody Category category){
        var data = categoryService.updateCategory(id, category);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
