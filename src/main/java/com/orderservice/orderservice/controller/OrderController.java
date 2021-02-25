package com.orderservice.orderservice.controller;


import com.orderservice.orderservice.model.Order;
import com.orderservice.orderservice.repository.OrderRepository;
import com.orderservice.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addOrder(@RequestBody Order order){
        orderRepository.save(order);
        return ResponseEntity
                .accepted()
                .body("Order was successfully submitted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody Order order){
        orderService.updateOrder(id,order);
        return ResponseEntity
                .accepted()
                .body("Order was successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id){
        orderRepository.deleteById(id);
        return ResponseEntity
                .accepted()
                .body("Order was successfully deleted");
    }
}
