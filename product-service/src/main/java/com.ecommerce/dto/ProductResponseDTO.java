package com.ecommerce.dto;

import com.ecommerce.entity.Category;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class ProductResponseDTO {

    private String productName;

    private String description;

    private String sku;

    private Category category;

    private Boolean active;

    private BigDecimal price;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}