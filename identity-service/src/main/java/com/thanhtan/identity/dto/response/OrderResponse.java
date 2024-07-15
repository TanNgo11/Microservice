package com.thanhtan.identity.dto.response;

import com.thanhtan.identity.enums.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse extends BaseDTO implements Serializable {
    String customerName;
    String email;
    String phoneNumber;
    String address;
    Double totalPay;
    String note;
    OrderStatus orderStatus;

    CouponResponse coupon;

    @NotNull
    List<OrderItemResponse> orderItems;
}