package com.pouya.orderservice.repository;

import com.pouya.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository <Order, Long> {
}
