package com.aselsis.aselmanager.service;

import com.aselsis.aselmanager.dto.SaveOrderLineDto;
import com.aselsis.aselmanager.model.OrderLine;

import java.util.List;

public interface OrderLineService {
    OrderLine addOrderLine(SaveOrderLineDto saveOrderLineDto);

    List<OrderLine> findAll();
}
