package com.aselsis.aselmanager.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Customer customer;

    private Integer totalPrice;

    @OneToMany
    private List<OrderLine> lines;

    public Order(){
    }
}
