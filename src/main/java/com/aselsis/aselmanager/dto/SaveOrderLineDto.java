package com.aselsis.aselmanager.dto;

import lombok.Data;

@Data
public class SaveOrderLineDto {

    private Integer productId;

    private Integer quantity;

    private String item;

    private Double cost;
}
