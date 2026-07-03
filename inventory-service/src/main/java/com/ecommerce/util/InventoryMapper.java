package com.ecommerce.util;

import com.ecommerce.dto.InventoryRequestDTO;
import com.ecommerce.dto.InventoryResponseDTO;
import com.ecommerce.entity.Inventory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

    Inventory toEntity(InventoryRequestDTO dto);

    InventoryResponseDTO toDTO(Inventory inventory);

    List<InventoryResponseDTO> toDTOList(List<Inventory> inventories);
}
