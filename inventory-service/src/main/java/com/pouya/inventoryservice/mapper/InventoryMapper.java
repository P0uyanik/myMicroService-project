package com.pouya.inventoryservice.mapper;

import com.pouya.inventoryservice.dto.InventoryDto;
import com.pouya.inventoryservice.entities.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class) ;
    InventoryDto toInventoryDto (Inventory inventory) ;
    Inventory toInventory (InventoryDto inventoryDto) ;
    List<InventoryDto> toInventoryDtoAsList (List<Inventory> inventories) ;
    List<Inventory> tInventoryAsList (List<InventoryDto> inventoryDtos) ;


}
