package com.aselsis.aselmanager.serviceimpl;

import com.aselsis.aselmanager.dto.SaveOrderRequestDto;
import com.aselsis.aselmanager.dto.UpdateOrderDto;
import com.aselsis.aselmanager.model.Customer;
import com.aselsis.aselmanager.model.Order;
import com.aselsis.aselmanager.model.OrderLine;
import com.aselsis.aselmanager.repository.CustomerRepository;
import com.aselsis.aselmanager.repository.OrderLineRepository;
import com.aselsis.aselmanager.repository.OrderRepository;
import com.aselsis.aselmanager.service.OrderService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderLineRepository orderLineRepository;
    private final CustomerRepository customerRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderLineRepository orderLineRepository,
                            CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.orderLineRepository = orderLineRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public Order saveOrder(SaveOrderRequestDto saveOrderRequestDto) {

        Order order = new Order();

        List<OrderLine> orderLineList = orderLineRepository.findByIdIn(saveOrderRequestDto.getOrderLineIdList());

        Optional<Customer> customerOptional = customerRepository.findById(saveOrderRequestDto.getCustomerId());

        if (!customerOptional.isPresent()) {
            throw new EntityNotFoundException("Böyle bir customer bulunmamaktadır.");
        }

        Double totalPrice = 0D;

        for (OrderLine orderLine : orderLineList) {
            totalPrice += orderLine.getTotalCost();
        }

        order.setOrderLineList(orderLineList);
        order.setCustomer(customerOptional.get());
        order.setTotalPrice(totalPrice);

        order = orderRepository.save(order);

        return order;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Integer orderId, UpdateOrderDto orderDto) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);

        Order order = orderOptional.get();

        order.setTotalPrice(orderDto.getTotalPrice());

        order = orderRepository.save(order);

        return order;
    }

    @Override
    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }


}




