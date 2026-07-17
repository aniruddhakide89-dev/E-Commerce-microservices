package com.ecommerce.service;

import com.ecommerce.dto.CartResponseDTO;
import com.ecommerce.dto.CreateCartRequestDTO;
import com.ecommerce.entity.Cart;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.utils.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartMapper mapper;

    public void createCart(CreateCartRequestDTO cartRequestDTO){
        if(cartRepository.existsByUserId(cartRequestDTO.getUserId())){
            throw new RuntimeException("User already has a cart");
        }
        Cart cart = new Cart();
        cart.setUserId(cartRequestDTO.getUserId());
        cart.setTotalPrice(BigDecimal.ZERO);
        cart.setLastUpdated(LocalDateTime.now());
        cartRepository.save(cart);
    }

    public CartResponseDTO getCartByUserId(Integer userId){
        return mapper.toDTO(cartRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("cannot find such")));
    }

    public void deleteCartByUserId(Integer userId){
        cartRepository.deleteByUserId(userId);
    }

    public CartResponseDTO addCartItemToCart(){

    }




}
