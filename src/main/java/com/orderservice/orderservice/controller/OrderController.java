package com.orderservice.orderservice.controller;


import com.orderservice.orderservice.model.Order;
import com.orderservice.orderservice.repository.OrderRepository;
import com.orderservice.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderRepository.getOne(id);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrderByUserId(@PathVariable Long userId){
        return orderRepository.findOrdersByUserId(userId);
    }

    @GetMapping("/product/{productId}")
    public List<Order> getOrderByProductId(@PathVariable Long productId){
        return orderRepository.findOrdersByProductId(productId);
    }

    @PostMapping("/")
    public Order addOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order){
        return orderService.updateOrder(id,order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderRepository.deleteById(id);
    }
}
