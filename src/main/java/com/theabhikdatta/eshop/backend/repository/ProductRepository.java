package com.theabhikdatta.eshop.backend.repository;

import com.theabhikdatta.eshop.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);

//    List<Product> findByTitleContaining(String keyword);
}
