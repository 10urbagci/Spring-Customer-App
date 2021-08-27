package com.aselsis.aselmanager.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Embedded
    private Address address;

    @ManyToOne
    private Customer customer;

    private Double totalPrice;

    private LocalDateTime dateTime;

    @OneToMany
    private List<OrderLine> orderLineList;

    public Order(){
    }
}
