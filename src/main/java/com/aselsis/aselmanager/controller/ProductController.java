package com.aselsis.aselmanager.controller;

import com.aselsis.aselmanager.dto.UpdateProductDto;
import com.aselsis.aselmanager.repository.ProductRepository;
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

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductService productService, ProductRepository productRepository){
        this.productService = productService;
        this.productRepository = productRepository;
    }
    @GetMapping("/all")
    public List<Product> findAll(){
        return productService.findAll();
    }
    @PostMapping("/save")
    public Product saveProduct(@RequestBody SaveProductDto saveProductDto){
        return productService.addProduct(saveProductDto);
    }
    @PutMapping("/product/{id}")
    public Product replaceProduct(@RequestBody UpdateProductDto productDto,@PathVariable Integer id){
        return productService.updateProduct(id,productDto);
    }
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteById(id);
    }
    @GetMapping("/product/{id}")
    public List<Product> findAll(@PathVariable Integer id){
        return productService.findAll();
    }
}
