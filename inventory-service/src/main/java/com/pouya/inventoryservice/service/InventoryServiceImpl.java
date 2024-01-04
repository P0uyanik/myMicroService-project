package com.pouya.inventoryservice.service;

import com.pouya.inventoryservice.dto.InventoryResponse;
import com.pouya.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
private final InventoryRepository inventoryRepository ;
    @Override
    @Transactional(readOnly = true)
    public List <InventoryResponse> isInStock(List<String> skuCode) {
        return  inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map( inventory -> {
                    return InventoryResponse.builder().
                            skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity()>0)
                            .build();
                }).toList() ;
    }
}
