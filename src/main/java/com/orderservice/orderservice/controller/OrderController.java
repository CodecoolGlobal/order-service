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

    @GetMapping("/user-orders/{userId}")
    public List<Order> getOrderByUserId(@PathVariable Long userId){
        return orderRepository.findOrdersByUserId(userId);
    }

    @GetMapping("/product-orders/{productId}")
    public List<Order> getOrderByProductId(@PathVariable Long productId){
        return orderRepository.findOrdersByProductId(productId);
    }

    @PostMapping("/")
    public Order addOrder(@RequestBody Order order){
        Order neworder = orderRepository.save(order);
        return neworder;
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order){
        return orderService.updateOrder(id,order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderRepository.deleteById(id);
    }

//    @PostConstruct
//    private void generateOrders(){
//        LocalDateTime time = LocalDateTime.now();
//        Order one = new Order(1l,1l,3l,time);
//        Order two = new Order(2l,1l,2l,time);
//        Order three = new Order(3l,3l,3l,time);
//        orderRepository.save(one);
//    }
}
