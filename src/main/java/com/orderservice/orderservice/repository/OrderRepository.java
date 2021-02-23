package com.orderservice.orderservice.repository;


import com.orderservice.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findOrdersByUserId(Long userId);
    List<Order> findOrdersByProductId(Long productId);
}
