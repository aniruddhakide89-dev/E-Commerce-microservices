package com.ecommerce.util;

import com.ecommerce.dto.InventoryRequestDTO;
import com.ecommerce.dto.InventoryResponseDTO;
import com.ecommerce.entity.Inventory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-14T18:45:04+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class InventoryMapperImpl implements InventoryMapper {

    @Override
    public Inventory toEntity(InventoryRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Inventory.InventoryBuilder inventory = Inventory.builder();

        inventory.sku( dto.sku() );
        inventory.availableQuantity( dto.availableQuantity() );
        inventory.reorderLevel( dto.reorderLevel() );

        return inventory.build();
    }

    @Override
    public InventoryResponseDTO toDTO(Inventory inventory) {
        if ( inventory == null ) {
            return null;
        }

        InventoryResponseDTO.InventoryResponseDTOBuilder inventoryResponseDTO = InventoryResponseDTO.builder();

        inventoryResponseDTO.sku( inventory.getSku() );
        inventoryResponseDTO.availableQuantity( inventory.getAvailableQuantity() );
        inventoryResponseDTO.reservedQuantity( inventory.getReservedQuantity() );
        inventoryResponseDTO.reorderLevel( inventory.getReorderLevel() );
        inventoryResponseDTO.lastUpdated( inventory.getLastUpdated() );

        return inventoryResponseDTO.build();
    }

    @Override
    public List<InventoryResponseDTO> toDTOList(List<Inventory> inventories) {
        if ( inventories == null ) {
            return null;
        }

        List<InventoryResponseDTO> list = new ArrayList<InventoryResponseDTO>( inventories.size() );
        for ( Inventory inventory : inventories ) {
            list.add( toDTO( inventory ) );
        }

        return list;
    }
}
