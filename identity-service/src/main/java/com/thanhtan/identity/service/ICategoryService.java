package com.thanhtan.identity.service;

import com.thanhtan.identity.dto.request.CategoryRequest;
import com.thanhtan.identity.dto.request.UpdateCategoryRequest;
import com.thanhtan.identity.dto.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    CategoryResponse createCategory(CategoryRequest category);

   List<CategoryResponse>  findAll();

   long countProductByCategory(String categoryName);

    CategoryResponse findById(Long id);

    CategoryResponse updateCategory(UpdateCategoryRequest category);

    void deleteCategory(Long [] ids);
}
