package com.thanhtan.identity.mapper;

import com.thanhtan.identity.dto.request.ProductRequest;
import com.thanhtan.identity.dto.request.UpdateProductRequest;
import com.thanhtan.identity.dto.response.ProductResponse;
import com.thanhtan.identity.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "relatedProducts", ignore = true)
    Product toProduct(ProductRequest request);

    @Mapping(target = "relatedProducts", ignore = true)
    @Mapping(target = "ratings", ignore = true)
    ProductResponse toProductResponse(Product product);


    @Mapping(target = "relatedProducts", ignore = true)
    void updateProduct(@MappingTarget Product product, UpdateProductRequest request);


}
