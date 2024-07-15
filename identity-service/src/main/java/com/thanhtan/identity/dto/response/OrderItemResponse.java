package com.thanhtan.identity.dto.response;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * DTO for {@link com.thanhtan.identity.entity.OrderItem}
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemResponse implements Serializable {
    String productName;
    String image;
    int quantity;
    double price;

}