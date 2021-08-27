package com.aselsis.aselmanager.dto;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SaveOrderRequestDto {

    private List<Integer> orderLineIdList;

    private Integer customerId;

    private LocalDateTime dateTime;

}
