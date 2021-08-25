package com.aselsis.aselmanager.dto;


import lombok.Data;

import java.util.List;

@Data
public class SaveOrderRequestDto {

    private List<Integer> orderLineIdList;

    private Integer customerId;

}
