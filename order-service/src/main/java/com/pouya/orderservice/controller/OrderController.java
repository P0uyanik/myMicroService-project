package com.pouya.orderservice.controller;
import com.pouya.orderservice.dto.OrderDto;
import com.pouya.orderservice.dto.OrderLineItemsDto;
import com.pouya.orderservice.entities.OrderLineItems;
import com.pouya.orderservice.mapper.OrderLineItemsMapper;
import com.pouya.orderservice.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
private final OrderLineItemsMapper orderLineItemsMapper = OrderLineItemsMapper.INSTANCE ;
private final OrderServiceImpl orderService ;
    @PostMapping
    public String placeOrder(@RequestBody OrderDto orderDto) {
        log.info("hier  ist mein palceOrder");
        List<OrderLineItemsDto> lineItemsDtos = orderDto.getLineItemsDtos();
        List<OrderLineItems> orderAsList = orderLineItemsMapper.toOrderAsList(lineItemsDtos);
        orderService.placeOrder(orderAsList) ;
        return "order Placed Successfully";
    }
}
