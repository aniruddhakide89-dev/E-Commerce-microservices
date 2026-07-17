package com.ecommerce.dto;

import lombok.Data;

@Data
public class AddItemToCartRequestDTO {
    private String sku;
    private Integer quantity;
}
