package com.pouya.productservice.mapper;

import com.pouya.productservice.dto.ProductDto;
import com.pouya.productservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class) ;
    ProductDto toProductDto (Product product) ;
    Product toProduct (ProductDto productDto) ;
    List<ProductDto> toProductDtoAsList (List<Product> productList) ;
    List<Product> toProductAsList (List<ProductDto> productDtos) ;
}
