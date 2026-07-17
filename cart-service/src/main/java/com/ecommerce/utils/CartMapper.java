package com.ecommerce.utils;

import com.ecommerce.dto.CartResponseDTO;
import com.ecommerce.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartResponseDTO toDTO(Cart cart);
    Cart toEntity(CartResponseDTO cartResponseDTO);
}
