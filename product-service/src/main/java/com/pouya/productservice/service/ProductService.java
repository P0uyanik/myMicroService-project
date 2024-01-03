package com.pouya.productservice.service;

import com.pouya.productservice.dto.ProductDto;
import com.pouya.productservice.model.Product;

import java.util.List;

public interface ProductService {
      void createProduct (Product product) ;
     List<Product> findAllProducts() ;
}
