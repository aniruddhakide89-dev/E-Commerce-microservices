package com.ecommerce.client;

import com.ecommerce.dto.ProductResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "PRODUCT-SERVICE", path = "/products")
public interface ProductClient {

    @GetMapping("/sku/{sku}")
    ResponseEntity<ProductResponseDTO> getProductBySKU(String sku);

}
