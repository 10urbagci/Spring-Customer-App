package com.aselsis.aselmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aselsis.aselmanager.dto.SaveOrderLineDto;
import com.aselsis.aselmanager.model.OrderLine;
import com.aselsis.aselmanager.service.OrderLineService;
import com.aselsis.aselmanager.service.ProductService;
import java.util.List;

@RestController
@RequestMapping("/api/orderline")

public class OrderLineController {
    private final OrderLineService orderLineService;
    private final ProductService productService;

    @Autowired
    public OrderLineController(OrderLineService orderLineService,ProductService productService) {
        this.orderLineService = orderLineService;
        this.productService = productService;
    }
    @GetMapping("/all")
    public List<OrderLine> findAll(){
        return orderLineService.findAll();
    }
    @PostMapping("/save")
    public OrderLine saveOrderLine(@RequestBody SaveOrderLineDto saveOrderLineDto){
        return orderLineService.addOrderLine(saveOrderLineDto);
    }
}
