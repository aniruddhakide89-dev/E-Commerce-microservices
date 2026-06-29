package com.ecommerce.service;

import com.ecommerce.dto.ProductRequestDTO;
import com.ecommerce.dto.ProductResponseDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ProductAlreadyExistsException;
import com.ecommerce.exception.ProductDoesNotExistsException;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.utils.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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

    public Page<ProductResponseDTO> getALlProducts(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.map(productMapper::toDTO);
    }

    public void deleteProductById(Integer id){
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
        }
        else{
            throw new ProductDoesNotExistsException("Product with id: " +id+ " does not exist");
        }
    }

    public ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO) {

        Product product = productRepository
                .findByProductName(productRequestDTO.getProductName())
                .orElseThrow(() -> new ProductDoesNotExistsException(
                        "Product with name: " + productRequestDTO.getProductName() + " does not exist"));

        product.setDescription(productRequestDTO.getDescription());
        product.setSku(productRequestDTO.getSku());
        product.setCategory(productRequestDTO.getCategory());
        product.setActive(productRequestDTO.getActive());
        product.setPrice(productRequestDTO.getPrice());

        Product updatedProduct = productRepository.save(product);

        return productMapper.toDTO(updatedProduct);
    }



}
