package com.ecommerce.service;

import com.ecommerce.dto.*;
import com.ecommerce.entity.Inventory;
import com.ecommerce.repository.InventoryRepository;
import com.ecommerce.util.InventoryMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    public InventoryResponseDTO addInventory(InventoryRequestDTO inventoryRequestDTO){
        return inventoryMapper.toDTO(inventoryRepository.save(inventoryMapper.toEntity(inventoryRequestDTO)));
    }

    public InventoryResponseDTO getById(Integer id){
        return inventoryMapper.toDTO(inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Cant find Inventory with id: " + id)));
    }

    public InventoryResponseDTO getBySku(String sku){
        return inventoryMapper.toDTO(inventoryRepository.getBySku(sku).orElseThrow(() -> new RuntimeException("Cant find by SKU: " + sku)));
    }

    @Transactional
    public InventoryResponseDTO restockInventory(StockUpdateRequestDTO dto){
        Inventory inventory = inventoryRepository.getBySku(dto.sku()).orElseThrow(() -> new RuntimeException("cannot find"));
        inventory.setAvailableQuantity(inventory.getAvailableQuantity() + dto.quantity());
        inventoryRepository.save(inventory);
        return inventoryMapper.toDTO(inventory);
    }

    @Transactional
    public InventoryResponseDTO reserveQuantity(ReservedStockRequestDTO dto){
        Inventory inventory = inventoryRepository.getBySku(dto.sku()).orElseThrow(() -> new RuntimeException("cannot find"));
        if(inventory.getAvailableQuantity() < dto.quantity()){
            throw new RuntimeException("Reservation Quantity cannot be more than available quantity");
        }
        inventory.setAvailableQuantity(inventory.getAvailableQuantity() - dto.quantity());
        inventory.setReservedQuantity(inventory.getReservedQuantity() + dto.quantity());
        inventoryRepository.save(inventory);
        return inventoryMapper.toDTO(inventory);
    }

    @Transactional
    public InventoryResponseDTO releaseReservedStockQuantity(String sku){
        Inventory inventory = inventoryRepository.getBySku(sku).orElseThrow(() -> new RuntimeException("cannot find"));
        inventory.setAvailableQuantity(inventory.getAvailableQuantity() + inventory.getReservedQuantity());
        inventory.setReservedQuantity(0);
        inventoryRepository.save(inventory);
        return inventoryMapper.toDTO(inventory);
    }

    @Transactional
    public InventoryResponseDTO deductQuantity(String sku){
        Inventory inventory = inventoryRepository.getBySku(sku).orElseThrow(() -> new RuntimeException("cannot find"));
        inventory.setReservedQuantity(0);
        inventoryRepository.save(inventory);
        return inventoryMapper.toDTO(inventory);
    }

    @Transactional
    public InventoryResponseDTO updateReorderLevel(UpdateReorderLevelDTO dto){
        Inventory inventory = inventoryRepository.getBySku(dto.sku()).orElseThrow(() -> new RuntimeException("cannot find"));
        inventory.setReorderLevel(inventory.getReorderLevel() + dto.reorderLevel());
        inventoryRepository.save(inventory);
        return inventoryMapper.toDTO(inventory);
    }

    public Page<InventoryResponseDTO> getInventory(int page , int size){
        return inventoryRepository.findAll(PageRequest.of(page, size)).map(inventoryMapper::toDTO);
    }

    public void deleteInventory(String sku){
        inventoryRepository.deleteBySku(sku);
    }

}
