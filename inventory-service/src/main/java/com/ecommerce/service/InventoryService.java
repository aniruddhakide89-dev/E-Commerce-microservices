package com.ecommerce.service;

import com.ecommerce.dto.InventoryRequestDTO;
import com.ecommerce.dto.InventoryResponseDTO;
import com.ecommerce.repository.InventoryRepository;
import com.ecommerce.util.InventoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    public InventoryResponseDTO addInventory(InventoryRequestDTO inventoryRequestDTO){
        return inventoryMapper.toDTO(inventoryRepository.save(inventoryMapper.toEntity(inventoryRequestDTO)));
    }

}
