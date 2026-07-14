package com.ecommerce.utils;

import com.ecommerce.dto.ProductRequestDTO;
import com.ecommerce.dto.ProductResponseDTO;
import com.ecommerce.entity.Product;
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
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductRequestDTO productRequestDTO) {
        if ( productRequestDTO == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.productName( productRequestDTO.getProductName() );
        product.description( productRequestDTO.getDescription() );
        product.sku( productRequestDTO.getSku() );
        product.category( productRequestDTO.getCategory() );
        product.isActive( productRequestDTO.getIsActive() );
        product.price( productRequestDTO.getPrice() );

        return product.build();
    }

    @Override
    public ProductResponseDTO toDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponseDTO.ProductResponseDTOBuilder productResponseDTO = ProductResponseDTO.builder();

        productResponseDTO.productName( product.getProductName() );
        productResponseDTO.description( product.getDescription() );
        productResponseDTO.sku( product.getSku() );
        productResponseDTO.category( product.getCategory() );
        productResponseDTO.isActive( product.getIsActive() );
        productResponseDTO.price( product.getPrice() );
        productResponseDTO.createdAt( product.getCreatedAt() );
        productResponseDTO.updatedAt( product.getUpdatedAt() );

        return productResponseDTO.build();
    }

    @Override
    public List<ProductResponseDTO> toDTOList(List<Product> productList) {
        if ( productList == null ) {
            return null;
        }

        List<ProductResponseDTO> list = new ArrayList<ProductResponseDTO>( productList.size() );
        for ( Product product : productList ) {
            list.add( toDTO( product ) );
        }

        return list;
    }
}
