package com.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class InventoryResponseDTO {

    private String sku;

    private Integer availableQuantity;

    private Integer reservedQuantity;

    private Integer reorderLevel;

    private LocalDateTime lastUpdated;

}
