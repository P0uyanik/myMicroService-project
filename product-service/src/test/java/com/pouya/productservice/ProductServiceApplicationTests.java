package com.pouya.productservice;

import com.pouya.productservice.dto.ProductDto;
import com.pouya.productservice.mapper.ProductMapper;
import com.pouya.productservice.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProductRepository productRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0");


    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);

    }

    @Test
    void shouldCreateProduct() throws Exception {
        ProductDto productDto = getProductDto();
        String productDtoAsString = objectMapper.writeValueAsString(productDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productDtoAsString)
        ).andExpect(status().isCreated());
        Assertions.assertThat(productRepository.findAll().size() == 1 ) ;
    }

    private ProductDto getProductDto() {
        return new ProductDto("name1", "description1", BigDecimal.valueOf(1000));
    }

    @Test
    public void getAllProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/product/get-products")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

}
