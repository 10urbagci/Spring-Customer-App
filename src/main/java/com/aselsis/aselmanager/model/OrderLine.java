package com.aselsis.aselmanager.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;

    @ManyToOne
    private Product product;

    private Double totalCost;

    public OrderLine() {

    }

}
