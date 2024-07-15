package com.thanhtan.identity.mapper;

import com.thanhtan.identity.dto.request.OrderRequest;
import com.thanhtan.identity.dto.request.UpdateOrderRequest;
import com.thanhtan.identity.entity.Order;
import com.thanhtan.identity.dto.response.OrderResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderItemMapper.class)
public interface OrderMapper {
    @Mapping(target = "orderItems", source = "orderItems")
    Order toOrder(OrderRequest orderRequest);

    @Mapping(target = "orderItems", source = "orderItems")
    OrderResponse toOrderResponse(Order order);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "orderItems", source = "orderItems")
    void updateOrder(@MappingTarget Order order, UpdateOrderRequest request);


    List<OrderResponse> toOrderResponseList(List<Order> allOrders);
}