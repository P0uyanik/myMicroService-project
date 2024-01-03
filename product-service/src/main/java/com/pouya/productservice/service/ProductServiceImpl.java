package com.pouya.productservice.service;

import com.pouya.productservice.dto.ProductDto;
import com.pouya.productservice.model.Product;
import com.pouya.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
        log.info("product with productId   {}  is saved", product.getId());
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
