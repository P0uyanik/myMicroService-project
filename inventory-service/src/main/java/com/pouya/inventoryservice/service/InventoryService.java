package com.pouya.inventoryservice.service;

import com.pouya.inventoryservice.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {
    List <InventoryResponse>  isInStock (List<String> skuCode) ;
}
