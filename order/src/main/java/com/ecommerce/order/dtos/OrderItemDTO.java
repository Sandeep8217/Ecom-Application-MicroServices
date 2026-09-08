package com.ecommerce.order.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class OrderItemDTO {
    private Long id;
    private String productId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subPrice;

    public OrderItemDTO(Long id, Long productId, Integer quantity, BigDecimal price, BigDecimal multiply) {
    }
}
