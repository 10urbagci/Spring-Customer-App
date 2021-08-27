package com.aselsis.aselmanager.dto;

import lombok.Data;

@Data
public class UpdateAddressDto {

    private Integer houseNo;

    private String Province;

    private String District;

    private String Neighborhood;
}
