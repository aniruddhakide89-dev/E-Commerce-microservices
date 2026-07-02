package com.ecommerce.dto;

import com.ecommerce.entity.Category;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDTO {

    @NotBlank
    private String productName;

    private String description;

    @NotBlank
    private String sku;

    @NotNull
    private Category category;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @NotNull
    private Boolean isActive;
}