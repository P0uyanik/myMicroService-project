package com.pouya.orderservice.mapper;

import com.pouya.orderservice.dto.OrderDto;
import com.pouya.orderservice.dto.OrderLineItemsDto;
import com.pouya.orderservice.entities.Order;
import com.pouya.orderservice.entities.OrderLineItems;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public
interface OrderLineItemsMapper {
    OrderLineItemsMapper INSTANCE = Mappers.getMapper(OrderLineItemsMapper.class) ;
    OrderLineItemsDto toOrderLineItemsDto (OrderLineItems orderLineItems) ;
    OrderLineItems  toOrder (OrderLineItemsDto orderLineItemsDto) ;
    List<OrderLineItemsDto> toOrderLineItemsDtoAsList (List<OrderLineItems> orderLineItems) ;
    List<OrderLineItems> toOrderAsList (List<OrderLineItemsDto> lineItemsDtos) ;
}
