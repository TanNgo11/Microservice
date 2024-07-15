package com.thanhtan.identity.repository;

import com.thanhtan.identity.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT COUNT(p) FROM Product p WHERE p.category.name = ?1")
    long countProductByCategory(String categoryName);
}