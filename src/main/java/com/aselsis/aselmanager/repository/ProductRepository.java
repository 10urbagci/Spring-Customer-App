package com.aselsis.aselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aselsis.aselmanager.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
