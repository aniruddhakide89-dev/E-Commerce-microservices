package com.ecommerce.dto;

import com.ecommerce.entity.Inventory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateReorderLevelDTO(@NotBlank String sku , @NotNull Integer reorderLevel){

}