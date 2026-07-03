package com.ecommerce.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InventoryRequestDTO(@NotBlank  String sku, @NotNull @Min(0) Integer availableQuantity, @NotNull @Min(0) Integer reorderLevel) {
}
