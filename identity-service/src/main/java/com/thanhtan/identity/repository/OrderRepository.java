package com.thanhtan.identity.repository;

import com.thanhtan.identity.entity.Order;
import com.thanhtan.identity.repository.custom.CustomOrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<Order, Long>, QuerydslPredicateExecutor<Order>, CustomOrderRepository {
    @Transactional
    @Modifying
    @Query("DELETE FROM OrderItem oi WHERE oi.order.id = ?1")
    void deleteByOrderId(Long orderId);
}