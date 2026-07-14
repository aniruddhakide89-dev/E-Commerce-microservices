package com.ecommerce.controller;

import com.ecommerce.dto.*;
import com.ecommerce.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{id}")
    public ResponseEntity<InventoryResponseDTO> getInventoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(inventoryService.getById(id));
    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<InventoryResponseDTO> getInventoryBySku(@PathVariable String sku){
        return ResponseEntity.ok(inventoryService.getBySku(sku));
    }

    @GetMapping
    public ResponseEntity<Page<InventoryResponseDTO>> getInventory(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(inventoryService.getInventory(page, size));
    }

    @PostMapping
    public ResponseEntity<InventoryResponseDTO> addInventory(@Valid @RequestBody InventoryRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(inventoryService.addInventory(dto));
    }

    @PatchMapping("/restock")
    public ResponseEntity<InventoryResponseDTO> restockInventory(@Valid @RequestBody StockUpdateRequestDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(inventoryService.restockInventory(dto));
    }

    @PatchMapping("/reserve")
    public ResponseEntity<InventoryResponseDTO> reserveQuantity(@Valid @RequestBody ReservedStockRequestDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(inventoryService.reserveQuantity(dto));
    }

    @PatchMapping("/release-reservation")
    public ResponseEntity<InventoryResponseDTO> releaseReservation(@RequestParam String sku){
        return ResponseEntity.ok(inventoryService.releaseReservedStockQuantity(sku));
    }

    @PatchMapping("/deduct-quantity")
    public ResponseEntity<InventoryResponseDTO> deductQuantity(@RequestParam String sku){
        return ResponseEntity.ok(inventoryService.deductQuantity(sku));
    }

    @PatchMapping("/update-reorder-level")
    public ResponseEntity<InventoryResponseDTO> updateReorderLevel(@Valid @RequestBody UpdateReorderLevelDTO dto){
        return ResponseEntity.ok(inventoryService.updateReorderLevel(dto));
    }

    @DeleteMapping("/{sku}")
    public ResponseEntity<String> deleteInventory(@PathVariable String sku){
        inventoryService.deleteInventory(sku);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Inventory deleted");
    }

}
