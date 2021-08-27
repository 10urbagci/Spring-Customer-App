package com.aselsis.aselmanager.dto;

import lombok.Data;

@Data
public class UpdateOrderLineDto {
    private Integer productId;

    private Integer quantity;

    private String item;


    private Double cost;
}
