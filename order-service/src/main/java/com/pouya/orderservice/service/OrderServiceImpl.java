package com.pouya.orderservice.service;

import com.pouya.orderservice.entities.Order;
import com.pouya.orderservice.entities.OrderLineItems;
import com.pouya.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements  OrderService {
    private final OrderRepository orderRepository ;
    @Override
    public void placeOrder(List<OrderLineItems> orderAsList) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLineItems(orderAsList) ;
        orderRepository.save(order) ;
    }
}
