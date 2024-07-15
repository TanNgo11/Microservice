package com.thanhtan.identity.service;

import com.thanhtan.identity.dto.request.ProductRequest;
import com.thanhtan.identity.dto.request.UpdateProductRequest;
import com.thanhtan.identity.dto.response.ProductResponse;
import com.thanhtan.identity.dto.response.ProductSalesResponse;
import com.thanhtan.identity.dto.response.SalesCategory;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface IProductService {
    List<ProductResponse> findAll();

    ProductResponse createProduct(ProductRequest product, MultipartFile file);

    ProductResponse updateProduct(UpdateProductRequest product, MultipartFile file);

    List<ProductResponse> findByCategory(String categoryName);

    List<ProductResponse> find5ProductsByCategory(String categoryName);

    List<ProductResponse> findSalesProduct();

    ProductResponse findById(Long id);

    ProductResponse findBySlug(String slug);

    List<ProductResponse> findProductsByQueryString(String queryString);

    void deleteProductsById(Long[] id);

    void updateStatusByIds(Long[] id);

    List<ProductSalesResponse> findMostSoldProduct();

    List<SalesCategory> findSalesCategory(Date startDate, Date endDate);





}
