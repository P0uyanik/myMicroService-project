package com.pouya.orderservice.service;
import com.pouya.orderservice.entities.OrderLineItems;

import java.util.List;


public interface OrderService {
    void placeOrder(List<OrderLineItems> orderAsList) ;
}
