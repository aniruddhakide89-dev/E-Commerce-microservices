package com.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "productName",nullable = false)
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "sku", nullable = false ,  unique = true)
    private String sku;

    @Enumerated(EnumType.STRING)
    @Column(name = "category" , nullable = false)
    private Category category;

    @Column(name = "active",nullable = false)
    private Boolean isActive;

    @Column(name = "price",nullable = false)
    private BigDecimal price;

    @Column(name = "created_time")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    void onCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
