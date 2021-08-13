package com.aselsis.aselmanager.serviceimpl;

import org.springframework.stereotype.Service;
import com.aselsis.aselmanager.dto.SaveOrderDto;
import com.aselsis.aselmanager.model.Order;
import com.aselsis.aselmanager.repository.OrderRepository;
import com.aselsis.aselmanager.service.OrderService;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order addOrder(SaveOrderDto saveOrderDto) {
        Order order = new Order();

        order.setTotalPrice(saveOrderDto.getTotalPrice());

        order = orderRepository.save(order);

        return order;

    }
    @Override
    public List<Order> findAll(){
        return orderRepository.findAll();
    }


}
