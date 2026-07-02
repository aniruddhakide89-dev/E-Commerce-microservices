package com.ecommerce.repository;

import com.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> , JpaSpecificationExecutor<Product> {
    boolean existsByProductName(String productName);
    Optional<Product> findByProductName(String productName);
}
