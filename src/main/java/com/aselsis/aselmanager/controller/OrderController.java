package com.aselsis.aselmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aselsis.aselmanager.dto.SaveOrderDto;
import com.aselsis.aselmanager.model.Order;
import com.aselsis.aselmanager.service.OrderService;
import java.util.List;



@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    @GetMapping("/all")
    public List<Order> findAll(){
        return orderService.findAll();
    }
    @PostMapping("/save")
    public Order saveOrder(@RequestBody SaveOrderDto saveOrderDto){
        return orderService.addOrder(saveOrderDto);
    }
}
