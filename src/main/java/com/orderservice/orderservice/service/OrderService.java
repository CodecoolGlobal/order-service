package com.orderservice.orderservice.service;

import com.orderservice.orderservice.exception.OrderNotFoundException;
import com.orderservice.orderservice.model.Order;
import com.orderservice.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).
                orElseThrow(() -> new OrderNotFoundException(id));
    }

    public Order updateOrder(Long id, Order updatedOrder){
        Order order =getOrderById(id);
        order.setDate(updatedOrder.getDate());
        order.setUserId(updatedOrder.getUserId());
        order.setProductId(updatedOrder.getProductId());
        return orderRepository.save(order);

    }
}
