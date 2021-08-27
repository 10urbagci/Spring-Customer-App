package com.aselsis.aselmanager.service;

import com.aselsis.aselmanager.dto.SaveOrderRequestDto;
import com.aselsis.aselmanager.dto.UpdateOrderDto;
import com.aselsis.aselmanager.model.Address;
import com.aselsis.aselmanager.model.Order;

import java.util.List;


public interface OrderService {

    Order saveOrder(Order order);

    List<Order> findAll();

    Order updateOrder(Integer orderId, UpdateOrderDto updateOrderDto);

    void deleteById(Integer id);

    Order findById(Integer id);


}
