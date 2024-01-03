package com.pouya.orderservice.mapper;

import com.pouya.orderservice.dto.OrderDto;
import com.pouya.orderservice.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class) ;
    OrderDto toOrderDto (Order order) ;
    Order  toOrder (OrderDto orderDto) ;
    List<OrderDto> toOrderDtoAsList (List<Order> orderList) ;
    List<Order> toOrderAsList (List<OrderDto> orderDtos) ;
}
