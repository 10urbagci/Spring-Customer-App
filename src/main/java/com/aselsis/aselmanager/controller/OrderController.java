package com.aselsis.aselmanager.controller;

import com.aselsis.aselmanager.dto.SaveOrderRequestDto;
import com.aselsis.aselmanager.dto.UpdateOrderDto;
import com.aselsis.aselmanager.model.Order;
import com.aselsis.aselmanager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @PutMapping("/{id}")
    public Order replaceOrder(@RequestBody UpdateOrderDto orderDto, @PathVariable Integer id) {
        return orderService.updateOrder(id, orderDto);
    }

    @DeleteMapping("/{id}")
    public void deleteController(@PathVariable Integer id) {
        orderService.deleteById(id);
    }

    @GetMapping("/{id}")
    Order findById(@PathVariable Integer id) {
        return orderService.findById(id);
    }
}
