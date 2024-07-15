package com.thanhtan.identity.mapper;

import com.thanhtan.identity.dto.response.OrderItemResponse;
import com.thanhtan.identity.entity.OrderItem;
import com.thanhtan.identity.dto.request.OrderItemRequest;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemMapper {


    @Mapping(target = "product", source = "productId", ignore = true)
    OrderItem toOrderItem(OrderItemRequest orderItemRequest);


    @Mapping(target = "productName", source = "product.name")
    @Mapping(target = "image", source = "product.image")
    OrderItemResponse toOrderItemResponse(OrderItem orderItem);




}