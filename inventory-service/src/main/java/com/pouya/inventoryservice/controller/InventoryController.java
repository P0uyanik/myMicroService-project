package com.pouya.inventoryservice.controller;

import com.pouya.inventoryservice.service.InventoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
private final InventoryServiceImpl inventoryService ;

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public  boolean isInStock(@PathVariable ("sku-code") String skuCode)
    {
       return inventoryService.isInStock(skuCode) ;
    }

}