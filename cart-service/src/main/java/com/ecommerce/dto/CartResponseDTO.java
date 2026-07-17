package com.ecommerce.dto;

import com.ecommerce.entity.CartItem;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CartResponseDTO {
    private Integer userId;
    private List<CartItem> cartItemList;
    private BigDecimal totalPrice;
    private LocalDateTime lastUpdated;
}
