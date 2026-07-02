package com.ecommerce.repository;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpecification {

    public static Specification<Product> hasName(String name){
        return (root, query, criteriaBuilder) -> name == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("productName")) , "%" + name.toLowerCase() + "%");
    }

    public static Specification<Product> hasCategory(Category category){
        return (root, query, criteriaBuilder) -> category == null ? null : criteriaBuilder.equal(root.get("category"),category);
    }

    public static Specification<Product> hasMinPrice(BigDecimal price){
        return (root, query, criteriaBuilder) -> price == null ? null : criteriaBuilder.greaterThan(root.get("price"),price);
    }

    public static Specification<Product> hasMaxPrice(BigDecimal price){
        return (root, query, criteriaBuilder) -> price == null ? null : criteriaBuilder.lessThanOrEqualTo(root.get("price"),price);
    }

}
