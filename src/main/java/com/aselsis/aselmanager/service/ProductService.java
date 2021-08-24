package com.aselsis.aselmanager.service;

import com.aselsis.aselmanager.dto.SaveProductDto;
import com.aselsis.aselmanager.dto.UpdateProductDto;
import com.aselsis.aselmanager.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(SaveProductDto saveProductDto);

    List<Product> findAll();

    Product updateProduct(Integer productId, UpdateProductDto updateProductDto);
}
