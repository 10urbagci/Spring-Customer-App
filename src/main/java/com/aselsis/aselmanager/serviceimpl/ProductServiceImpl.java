package com.aselsis.aselmanager.serviceimpl;

import com.aselsis.aselmanager.dto.SaveProductDto;
import com.aselsis.aselmanager.dto.UpdateProductDto;
import com.aselsis.aselmanager.model.Product;
import com.aselsis.aselmanager.repository.ProductRepository;
import com.aselsis.aselmanager.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Product updateProduct(Integer productId, UpdateProductDto updateProductDto) {
        Optional<Product> productOptional = productRepository.findById(productId);

        Product product = productOptional.get();

        product.setProductName(updateProductDto.getProductName());

        product.setDescription(updateProductDto.getDescription());

        product.setUnitPrice(updateProductDto.getUnitPrice());

        product = productRepository.save(product);

        return product;
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
    @Override
    public Product findById(Integer id){
       Optional<Product> opProduct = productRepository.findById(id);

       return opProduct.get();
    }


}




