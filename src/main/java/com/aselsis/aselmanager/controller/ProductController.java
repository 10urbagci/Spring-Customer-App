package com.aselsis.aselmanager.controller;

import com.aselsis.aselmanager.dto.SaveProductDto;
import com.aselsis.aselmanager.dto.UpdateProductDto;
import com.aselsis.aselmanager.model.Product;
import com.aselsis.aselmanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    private final ProductService productService;



    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody SaveProductDto saveProductDto) {
        return productService.addProduct(saveProductDto);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@RequestBody UpdateProductDto productDto, @PathVariable Integer id) {
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Integer id) {
        return productService.findById(id);
    }
}
