package com.theabhikdatta.eshop.backend.repository;

import com.theabhikdatta.eshop.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
