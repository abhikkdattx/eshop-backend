package com.theabhikdatta.eshop.backend.controller;

import com.theabhikdatta.eshop.backend.entity.Product;
import com.theabhikdatta.eshop.backend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/categories")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<Product>> getProductByCategoryId(@PathVariable("categoryId") Long categoryId){
        var data = productService.getProductByCategoryId(categoryId);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{categoryId}/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("categoryId") Long categoryId,
                                                  @PathVariable("productId") Long productId){
        var data = productService.getProductByProductId(categoryId, productId);
        return ResponseEntity.ok(data);
    }

    @PostMapping("{categoryId}/products")
    public ResponseEntity<Product> addProduct(@PathVariable("categoryId") Long categoryId ,@Valid @RequestBody Product product){
        var data = productService.saveProduct(categoryId, product);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("categoryId") Long categoryId,
                                                 @PathVariable("productId") Long productId,
                                                 @Valid @RequestBody Product updateProduct){
        var data = productService.updateProduct(categoryId, productId, updateProduct);
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/{categoryId}/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("categoryId") Long categoryId,
                                                 @PathVariable("productId") Long productId){
        productService.deleteProduct(categoryId, productId);
        return ResponseEntity.noContent().build();
    }
}
