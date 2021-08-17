package com.aselsis.aselmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aselsis.aselmanager.dto.SaveProductDto;
import com.aselsis.aselmanager.model.Product;
import com.aselsis.aselmanager.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/all")
    public List<Product> findAll(){
        return productService.findAll();
    }
    @PostMapping("/save")
    public Product saveProduct(@RequestBody SaveProductDto saveProductDto){
        return productService.addProduct(saveProductDto);
    }
}
