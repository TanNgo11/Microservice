package com.thanhtan.identity.service;

import com.thanhtan.identity.dto.request.OrderItemRequest;
import com.thanhtan.identity.dto.request.OrderRequest;
import com.thanhtan.identity.dto.request.UpdateOrderRequest;
import com.thanhtan.identity.dto.response.MonthlySalesResponse;
import com.thanhtan.identity.dto.response.OrderResponse;
import com.thanhtan.identity.entity.Order;
import com.thanhtan.identity.enums.OrderStatus;
import jakarta.mail.MessagingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {
    OrderResponse createOrder(OrderRequest orderRequest) throws MessagingException;

    OrderResponse updateOrder(UpdateOrderRequest orderRequest);

    OrderResponse updateOrderStatus(Long orderId, OrderStatus status);

    OrderResponse getOrder(Long orderId);

    List<OrderResponse> getAllOrderWithoutOrderItems();

    Page<OrderResponse> getAllOrderWithoutOrderItems(Pageable pageable,String searchTerm);

    List<MonthlySalesResponse> getMonthlySales();

    Long findNumberOfOrderDaily();

    List<OrderResponse> findAllOrdersByUser();

    Double getMonthlyTotalSalesRevenue();

    Double getYearTotalSalesRevenue();

    double processOrderItems(Order savedOrder, List<OrderItemRequest> orderItems);
}
