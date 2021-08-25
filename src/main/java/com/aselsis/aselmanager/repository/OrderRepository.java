package com.aselsis.aselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aselsis.aselmanager.model.Order;

public interface OrderRepository  extends JpaRepository<Order,Integer> {


}
