package com.theabhikdatta.eshop.backend.service.impl;

import com.theabhikdatta.eshop.backend.entity.Category;
import com.theabhikdatta.eshop.backend.entity.Product;
import com.theabhikdatta.eshop.backend.exception.EshopApiException;
import com.theabhikdatta.eshop.backend.exception.ResourceNotFoundException;
import com.theabhikdatta.eshop.backend.repository.CategoryRepository;
import com.theabhikdatta.eshop.backend.repository.ProductRepository;
import com.theabhikdatta.eshop.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductByCategoryId(Long categoryId) {
        // retrieve product by category id
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public Product getProductByProductId(Long categoryId, Long productId) {
        //retrieve product by id
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product", "productId", productId));
        //retrieve product by category id
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));
        if(!product.getCategory().getId().equals(category.getId())){
            throw new EshopApiException(HttpStatus.BAD_REQUEST, "product does not belong to category");
        }
        return product;
    }

    @Override
    public Product saveProduct(Long categoryId, Product saveProduct) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));

        saveProduct.setCategory(category);

        return productRepository.save(saveProduct);
    }

//    @Override
//    public List<Product> searchProducts(String keyword) {
//        return productRepository.findByTitleContaining(keyword);
//    }


    @Override
    public Product updateProduct(Long categoryId, Long productId, Product updateProduct) {
        //retrieve product by id
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product", "productId", productId));
        //retrieve product by category id
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));
        if(!product.getCategory().getId().equals(category.getId())){
            throw new EshopApiException(HttpStatus.BAD_REQUEST, "product does not belong to category");
        } //title, price, description, image
        product.setTitle(updateProduct.getTitle());
        product.setPrice(updateProduct.getPrice());
        product.setDescription(updateProduct.getDescription());
        product.setImage(updateProduct.getImage());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long categoryId, Long productId) {
        //retrieve product by id
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product", "productId", productId));
        //retrieve product by category id
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));
        if(!product.getCategory().getId().equals(category.getId())){
            throw new EshopApiException(HttpStatus.BAD_REQUEST, "product does not belong to category");
        }
        productRepository.deleteById(productId);
    }
}
