package com.aselsis.aselmanager.service;

import com.aselsis.aselmanager.dto.SaveAddressDto;
import com.aselsis.aselmanager.dto.UpdateAddressDto;
import com.aselsis.aselmanager.model.Address;

import java.util.List;

public interface AddressService {

    Address addAddress(SaveAddressDto saveAddressDto);

    List<Address> findAll();

    Address updateAddress(Integer addressId, UpdateAddressDto updateAddressDto);

    void deleteById(Integer id);

    Address findById(Integer id);


}
