package com.aselsis.aselmanager.service;

import com.aselsis.aselmanager.dto.SaveOrderLineDto;
import com.aselsis.aselmanager.dto.UpdateOrderLineDto;
import com.aselsis.aselmanager.model.OrderLine;

import java.util.List;

public interface OrderLineService {
    OrderLine addOrderLine(SaveOrderLineDto saveOrderLineDto);

    List<OrderLine> findAll();

    OrderLine updateOrderLine(Integer orderLineId, UpdateOrderLineDto updateOrderLineDto);

    void deleteById(Integer id);

    OrderLine findById(Integer id);
}
