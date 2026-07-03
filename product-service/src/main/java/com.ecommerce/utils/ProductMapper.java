package com.ecommerce.utils;


import com.ecommerce.dto.ProductRequestDTO;
import com.ecommerce.dto.ProductResponseDTO;
import com.ecommerce.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductRequestDTO productRequestDTO);
    ProductResponseDTO toDTO(Product product);
    List<ProductResponseDTO> toDTOList(List<Product> productList);
}
