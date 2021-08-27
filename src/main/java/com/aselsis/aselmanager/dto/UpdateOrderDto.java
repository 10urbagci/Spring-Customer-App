package com.aselsis.aselmanager.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateOrderDto {

    private Double totalPrice;

    private LocalDateTime dateTime;
}
