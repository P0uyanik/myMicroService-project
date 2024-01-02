package com.pouya.orderservice.entities;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }
    private  String orderNumber ;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItems ;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<OrderLineItems> getOrderLineItems() {
        return Collections.unmodifiableList(orderLineItems);
    }

    public void setOrderLineItems(List<OrderLineItems> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }
}
