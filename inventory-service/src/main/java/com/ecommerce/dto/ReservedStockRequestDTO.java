package com.ecommerce.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReservedStockRequestDTO(@NotBlank String sku,@NotNull @Min(1) Integer quantity) {
}
