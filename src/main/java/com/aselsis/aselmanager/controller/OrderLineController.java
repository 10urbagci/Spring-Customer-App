package com.aselsis.aselmanager.controller;

import com.aselsis.aselmanager.dto.UpdateOrderLineDto;
import com.aselsis.aselmanager.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aselsis.aselmanager.dto.SaveOrderLineDto;
import com.aselsis.aselmanager.model.OrderLine;
import com.aselsis.aselmanager.service.OrderLineService;
import com.aselsis.aselmanager.service.ProductService;
import java.util.List;

@RestController
@RequestMapping("/orderline")
@CrossOrigin
public class OrderLineController {
    private final OrderLineService orderLineService;
    private final ProductService productService;
    private final OrderLineRepository orderLineRepository;

    @Autowired
    public OrderLineController(OrderLineService orderLineService, ProductService productService, OrderLineRepository orderLineRepository) {
        this.orderLineService = orderLineService;
        this.productService = productService;
        this.orderLineRepository = orderLineRepository;
    }
    @GetMapping("/all")
    public List<OrderLine> findAll(){
        return orderLineService.findAll();
    }
    @PostMapping("/save")
    public OrderLine saveOrderLine(@RequestBody SaveOrderLineDto saveOrderLineDto){
        return orderLineService.addOrderLine(saveOrderLineDto);
    }
    @PutMapping("/orderline/{id}")
    public OrderLine replaceOrderLine(@RequestBody UpdateOrderLineDto orderLineDto,@PathVariable Integer id){
        return orderLineService.updateOrderLine(id,orderLineDto);
    }
    @DeleteMapping("/orderline/{id}")
    public void deleteOrderLine(@PathVariable Integer id){
        orderLineRepository.deleteById(id);
    }
    @GetMapping("/orderline/{id}")
    public List<OrderLine> findAll(@PathVariable Integer id){
        return orderLineService.findAll();

    }
}
