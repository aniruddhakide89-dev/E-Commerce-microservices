package com.ecommerce.repository;


import com.ecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    boolean existsByUserId(Integer userId);
    Optional<Cart> findByUserId(Integer userId);
    void deleteByUserId(Integer userId);
}
