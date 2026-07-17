package com.ecommerce.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductSummaryDTO {

    private String productName;
    private String sku;
    private BigDecimal price;
    private Boolean isActive;

}
