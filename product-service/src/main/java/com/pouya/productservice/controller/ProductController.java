package com.pouya.productservice.controller;

import com.pouya.productservice.dto.ProductDto;
import com.pouya.productservice.mapper.ProductMapper;
import com.pouya.productservice.model.Product;
import com.pouya.productservice.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/product")
public class ProductController {
    private final ProductServiceImpl productService;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDto productDto) {
        Product product = ProductMapper.INSTANCE.toProduct(productDto);
        productService.createProduct(product);
    }


    @GetMapping("get-products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getProduct ()
    {
        List<Product> allProducts = productService.findAllProducts();
        return ProductMapper.INSTANCE.toProductDtoAsList(allProducts);
    }
}
