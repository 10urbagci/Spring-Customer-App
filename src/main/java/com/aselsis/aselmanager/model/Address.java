package com.aselsis.aselmanager.model;


import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

    private String houseNo;

    private String province;

    private String district;

    private String neighborhood;

}
