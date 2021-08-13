package com.aselsis.aselmanager.repository;

import com.aselsis.aselmanager.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine,Integer> {
}
