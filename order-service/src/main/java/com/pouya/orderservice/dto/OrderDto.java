package com.pouya.orderservice.dto;

import com.pouya.orderservice.entities.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private List<OrderLineItemsDto> lineItemsDtos ;
}
