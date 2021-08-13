package com.aselsis.aselmanager.service;

import com.aselsis.aselmanager.dto.SaveOrderDto;
import com.aselsis.aselmanager.model.Order;

import java.util.List;


public interface OrderService {
    Order addOrder(SaveOrderDto saveOrderDto);

    List<Order> findAll();
}
