package com.thanhtan.identity.mapper;

import com.thanhtan.identity.dto.request.CategoryRequest;
import com.thanhtan.identity.dto.response.CategoryResponse;
import com.thanhtan.identity.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryRequest request);

    CategoryResponse toCategoryResponse(Category category);
}
