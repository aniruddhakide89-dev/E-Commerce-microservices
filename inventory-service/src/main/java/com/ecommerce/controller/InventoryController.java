package com.ecommerce.controller;

import com.ecommerce.dto.InventoryResponseDTO;
import com.ecommerce.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{id}")
    public ResponseEntity<InventoryResponseDTO> getInventoryById(Integer id) {
        return ResponseEntity.ok(inventoryService.getById(id));
    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<InventoryResponseDTO> getInventoryBySku(String sku){
        return ResponseEntity.ok(inventoryService.getBySku(sku));
    }

    @GetMapping
    public ResponseEntity<Page<InventoryResponseDTO>> getInventory(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(inventoryService.getInventory(page, size));
    }

}
