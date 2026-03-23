package com.codewithmosh.store.orders;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderItemDto {
    private ProductDto product;
    private int quantity;
    private BigDecimal totalPrice;
}
