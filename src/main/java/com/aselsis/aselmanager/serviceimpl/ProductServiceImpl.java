package com.aselsis.aselmanager.serviceimpl;

import org.springframework.stereotype.Service;
import com.aselsis.aselmanager.dto.SaveProductDto;
import com.aselsis.aselmanager.model.Product;
import com.aselsis.aselmanager.repository.ProductRepository;
import com.aselsis.aselmanager.service.ProductService;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(SaveProductDto saveProductDto) {
        Product product = new Product();

        product.setProductName(saveProductDto.getProductName());
        product.setDescription(saveProductDto.getDescription());
        product.setUnitPrice(saveProductDto.getUnitPrice());

        product = productRepository.save(product);

        return product;
    }
    @Override
    public List<Product> findAll(){
        return productRepository.findAll();
    }



}
