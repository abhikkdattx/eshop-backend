package com.theabhikdatta.eshop.backend.service;

import com.theabhikdatta.eshop.backend.entity.Product;

import java.util.List;

public interface ProductService {
    // get all products
    List<Product> getAllProducts();

    //get product by categoryId
    List<Product> getProductByCategoryId(Long categoryId);

    //get product by productId
    Product getProductByProductId(Long categoryId, Long productId);

    // add product
    Product saveProduct(Long categoryId, Product saveProduct);

//    //search product
//    List<Product> searchProducts(String title);

    //update product
    Product updateProduct(Long categoryId, Long productId, Product updateProduct);

    //delete product
    void deleteProduct(Long categoryId, Long productId);
}
