package com.aselsis.aselmanager.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aselsis.aselmanager.dto.SaveOrderLineDto;
import com.aselsis.aselmanager.model.OrderLine;
import com.aselsis.aselmanager.model.Product;
import com.aselsis.aselmanager.repository.OrderLineRepository;
import com.aselsis.aselmanager.repository.ProductRepository;
import com.aselsis.aselmanager.service.OrderLineService;
import java.util.List;
import java.util.Optional;


@Service
public class OrderLineServiceImpl implements OrderLineService {
    private final OrderLineRepository orderLineRepository;
    private final ProductRepository productRepository;


    @Autowired
    public OrderLineServiceImpl(OrderLineRepository orderLineRepository, ProductRepository productRepository) {
        this.orderLineRepository = orderLineRepository;
        this.productRepository = productRepository;
    }
    @Override
    public OrderLine addOrderLine(SaveOrderLineDto saveOrderLineDto){

        OrderLine orderLine = new OrderLine();

        Optional<Product> product = productRepository.findById(saveOrderLineDto.getProductId());

        orderLine.setProduct(product.get());
        orderLine.setCost(saveOrderLineDto.getCost());
        orderLine.setQuantity(saveOrderLineDto.getQuantity());
        orderLine = orderLineRepository.save(orderLine);

        return orderLine;
    }

    @Override
    public List<OrderLine> findAll(){
        return orderLineRepository.findAll();
    }

}
