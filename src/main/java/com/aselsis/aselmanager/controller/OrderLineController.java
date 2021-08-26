package com.aselsis.aselmanager.controller;

import com.aselsis.aselmanager.dto.SaveOrderLineDto;
import com.aselsis.aselmanager.dto.UpdateOrderLineDto;
import com.aselsis.aselmanager.model.OrderLine;
import com.aselsis.aselmanager.service.OrderLineService;
import com.aselsis.aselmanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderline")
@CrossOrigin
public class OrderLineController {
    private final OrderLineService orderLineService;
    private final ProductService productService;


    @Autowired
    public OrderLineController(OrderLineService orderLineService, ProductService productService) {
        this.orderLineService = orderLineService;
        this.productService = productService;

    }

    @GetMapping("/all")
    public List<OrderLine> findAll() {
        return orderLineService.findAll();
    }

    @PostMapping("/save")
    public OrderLine saveOrderLine(@RequestBody SaveOrderLineDto saveOrderLineDto) {
        return orderLineService.addOrderLine(saveOrderLineDto);
    }

    @PutMapping("/{id}")
    public OrderLine replaceOrderLine(@RequestBody UpdateOrderLineDto orderLineDto, @PathVariable Integer id) {
        return orderLineService.updateOrderLine(id, orderLineDto);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderLine(@PathVariable Integer id) {
        orderLineService.deleteById(id);
    }

    @GetMapping("/{id}")
    public OrderLine findById(@PathVariable Integer id) {
        return orderLineService.findById(id);

    }
}
