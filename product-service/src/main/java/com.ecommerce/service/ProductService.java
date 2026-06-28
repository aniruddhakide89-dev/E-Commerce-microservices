package com.ecommerce.service;

import com.ecommerce.dto.ProductRequestDTO;
import com.ecommerce.dto.ProductResponseDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ProductAlreadyExistsException;
import com.ecommerce.exception.ProductDoesNotExistsException;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.utils.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO){
        if (productRepository.existsByProductName(productRequestDTO.getProductName())){
            throw new ProductAlreadyExistsException("Product Already Exists");
        }
        return productMapper.toDTO(productRepository.save(productMapper.toEntity(productRequestDTO)));
    }

    public ProductResponseDTO getProductById(Integer id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductDoesNotExistsException("product with id: "+id+" does not exist"));
        return productMapper.toDTO(product);
    }

    public ProductResponseDTO getProductByName(String productName){
        Product product = productRepository.findByProductName(productName).orElseThrow(() -> new ProductDoesNotExistsException("product with name: " + productName + " does not exists"));
        return productMapper.toDTO(product);
    }

    public List<ProductResponseDTO> getALlProducts(){
        return productMapper.toDTOList(productRepository.findAll());
    }



}
