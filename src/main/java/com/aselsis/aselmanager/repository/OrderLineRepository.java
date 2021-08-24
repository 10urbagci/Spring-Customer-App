package com.aselsis.aselmanager.repository;

import com.aselsis.aselmanager.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderLineRepository extends JpaRepository<OrderLine,Integer> {


}
